package com.javadevjournal.caching;

import com.javadevjournal.service.impl.DefaultCustomerService;
import com.javadevjournal.service.impl.DefaultProductService;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CustomCacheResolver implements CacheResolver {

    private final CacheManager cacheManager;
    private final CacheManager alternateCacheManager;

    public CustomCacheResolver(final CacheManager cacheManager, CacheManager alternateCacheManager){
        this.cacheManager= cacheManager;
        this.alternateCacheManager=cacheManager;
    }

    @Override
    public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> context) {
        Collection<String> cacheNames = getCacheNames(context);
        if (cacheNames == null) {
            return Collections.emptyList();
        }
        Collection<Cache> result = new ArrayList<>(cacheNames.size());
        if(context.getTarget() instanceof DefaultProductService){
            for (String cacheName : cacheNames) {
                Cache cache = cacheManager.getCache(cacheName);
                if(cache ==null){
                    throw new IllegalArgumentException("Cannot find cache named '" +
                            cacheName + "' for " + context.getOperation());
                }
                result.add(cache);
            }
        }
        if(context.getTarget() instanceof DefaultCustomerService){
            for (String cacheName : cacheNames) {
                Cache cache = alternateCacheManager.getCache(cacheName);
                if(cache ==null){
                    throw new IllegalArgumentException("Cannot find cache named '" +
                            cacheName + "' for " + context.getOperation());
                }
                result.add(cache);
            }
        }
        return result;
    }

    protected Collection<String> getCacheNames(CacheOperationInvocationContext<?> context) {
        return context.getOperation().getCacheNames();
    }
}
