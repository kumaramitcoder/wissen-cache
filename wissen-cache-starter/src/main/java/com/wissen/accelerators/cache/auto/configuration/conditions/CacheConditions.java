package com.wissen.accelerators.cache.auto.configuration.conditions;

import org.springframework.boot.autoconfigure.condition.AnyNestedCondition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

public class CacheConditions extends AnyNestedCondition {

	public CacheConditions() {
		super(ConfigurationPhase.PARSE_CONFIGURATION);
	}
	
	@ConditionalOnProperty(prefix = "spring.cache", name = "type", havingValue = "redis")
	public class RedisCondition {
		
	}
	
	@ConditionalOnProperty(prefix = "spring.cache", name = "type", havingValue = "hazelcast")
	public class HazelcastCondition {
		
	}
	
	@ConditionalOnProperty(prefix = "memcached.cache", name = "provider", havingValue = "static")
	public class MemcachedCondition {
		
	}

}
