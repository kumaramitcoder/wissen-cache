package com.wissen.accelerators.cache.auto.configuration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

import com.wissen.accelerators.cache.auto.configuration.conditions.CacheConditions;
import com.wissen.accelerators.cache.service.WissenCache;
import com.wissen.accelerators.cache.service.impl.WissenCacheImpl;

@AutoConfiguration
@Conditional(CacheConditions.class)
@EnableCaching
public class WissenCacheAutoConfiguration {
	
	private static final Log LOG = LogFactory.getLog(WissenCacheAutoConfiguration.class);

	public WissenCacheAutoConfiguration() {

	}

	@Bean
	@ConditionalOnMissingBean
	public WissenCache wissenCache() {
		LOG.debug("WissenCache bean about to create");
		return new WissenCacheImpl();
	}
}
