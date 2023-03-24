package com.wissen.accelerators.cache.auto.configuration.redis;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import com.wissen.accelerators.cache.constants.CacheConstants;

@AutoConfiguration
@ConditionalOnProperty(prefix = "spring.cache", name = "type", havingValue = "redis")
public class RedisCachingConfig {

	private static final Log LOG = LogFactory.getLog(RedisCachingConfig.class);

	@Value("${spring.cache.cache-names}")
	List<String> redisCacheNames;

	@Value("${spring.cache.cache-ttls}")
	List<Long> redisCacheTTLs;

	@Value("${spring.cache.redis.time-to-live}")
	long defaultTTL;

	@Value("${spring.cache.redis.cache-null-values}")
	boolean allowNullValues;

	@ConditionalOnMissingBean
	@Primary
	@Bean(name = CacheConstants.REDIS_CACHE_MANAGER_NAME)
	public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {

		LOG.debug("Redis cache is chooses to configure");

		Map<String, RedisCacheConfiguration> cacheConfigurations = new HashMap<>();

		RedisCacheConfiguration cacheRef = RedisCacheConfiguration.defaultCacheConfig()
				.entryTtl(Duration.ofMillis(defaultTTL));
		if (allowNullValues) {
			cacheRef = cacheRef.disableCachingNullValues();
		}
		cacheConfigurations.put(CacheConstants.DEFAULT_CACHE_NAME, cacheRef);

		// dynamic cache references
		int maxLength = redisCacheNames.size() <= redisCacheTTLs.size() ? redisCacheNames.size()
				: redisCacheTTLs.size();
		for (int i = 0; i < maxLength; i++) {
			cacheRef = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMillis(redisCacheTTLs.get(i)));

			if (allowNullValues) {
				cacheRef = cacheRef.disableCachingNullValues();
			}

			cacheConfigurations.put(redisCacheNames.get(i), cacheRef);
			LOG.debug(redisCacheNames.get(i) + " " + redisCacheTTLs.get(i));
		}

		return RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(connectionFactory)
				.withInitialCacheConfigurations(cacheConfigurations).build();
	}
}
