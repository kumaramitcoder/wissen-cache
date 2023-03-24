package com.wissen.accelerators.cache.service.impl;

import static com.wissen.accelerators.cache.constants.CacheConstants.DEFAULT_CACHE_NAME;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.wissen.accelerators.cache.service.WissenCache;

@Service
public class WissenCacheImpl implements WissenCache {

	private static final Log LOG = LogFactory.getLog(WissenCacheImpl.class);

	@Cacheable(cacheNames = "#cacheName", key = "#cacheKeyName", unless = "#result == null")
	@Override
	public <T> T get(String cacheName, String cacheKeyName) {
		LOG.info(String.format("Data doesn't exists with cache key name %s", cacheKeyName));
		return null;
	}

	@Cacheable(cacheNames = DEFAULT_CACHE_NAME, key = "#cacheKeyName", unless = "#result == null")
	@Override
	public <T> T get(String cacheKeyName) {
		LOG.info(String.format("Data doesn't exists with cache key name %s", cacheKeyName));
		return null;
	}

	@CachePut(cacheNames = "#cacheName", key = "#cacheKeyName", unless = "#result == null")
	@Override
	public <T> T addOrUpdate(String cacheName, String cacheKeyName, T data) {
		LOG.info(String.format("Data adding/updating to cache key name %s", cacheKeyName));
		return data;
	}

	@CachePut(cacheNames = DEFAULT_CACHE_NAME, key = "#cacheKeyName", unless = "#result == null")
	@Override
	public <T> T addOrUpdate(String cacheKeyName, T data) {
		LOG.info(String.format("Data adding/updating to cache key name %s", cacheKeyName));
		return data;
	}

	@CacheEvict(cacheNames = "#cacheName", key = "#cacheKeyName")
	@Override
	public void remove(String cacheName, String cacheKeyName) {
		LOG.info(String.format("Removing data exists name %s", cacheName));
	}

	@CacheEvict(cacheNames = DEFAULT_CACHE_NAME, key = "#cacheKeyName")
	@Override
	public void remove(String cacheKeyName) {
		remove(DEFAULT_CACHE_NAME, cacheKeyName);
	}

	@CacheEvict(cacheNames = DEFAULT_CACHE_NAME, allEntries = true)
	@Override
	public void removeAll() {
		LOG.info("Removing all cache entries from default cache manager");
	}

	@CacheEvict(cacheNames = "#cacheName", allEntries = true)
	@Override
	public void removeAll(String cacheName) {
		LOG.info(String.format("Removing all cache entries from %s cache name ", 				cacheName));
	}
}
