package com.iHexa.code.cache.serviceImpl;

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

public class CacheContext {
	Caffeine<Object, Object> caffeine;
	
	public <K, V> LoadingCache<K, V> build(CacheLoader<K, V> loader) {
		LoadingCache<K, V> cache;

		//cache = isAsync() ? caffeine.buildAsync(loader).synchronous() : caffeine.build(loader);
		cache = caffeine.build(loader);
		return cache;
	}

}
