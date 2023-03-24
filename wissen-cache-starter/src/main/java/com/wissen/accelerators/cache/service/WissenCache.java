package com.wissen.accelerators.cache.service;

public interface WissenCache {

	<T> T addOrUpdate(String cacheKeyName, T data);

	<T> T addOrUpdate(String cacheName, String cacheKeyName, T data);

	<T> T get(String cacheKeyName);

	<T> T get(String cacheName, String cacheKeyName);

	void remove(String cacheKeyName);

	void remove(String cacheName, String cacheKeyName);

	void removeAll();

	void removeAll(String cacheName);
}