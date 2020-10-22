package com.javadevjournal.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.javadevjournal.caching.CustomCacheResolver;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class MultiCacheManagerConfig extends CachingConfigurerSupport {

    public String[] cacheNames = {"products"};

    /**
     * We are using CachingConfigurerSupport to define out main caching
     * provider. In our case it's Caffeine cache. This will be the default cache provider
     * for our application. If we don't provide explicit cache manager, Spring Boot
     * will pick this as default cache provider.
     * @return
     */
    @Override
    @Bean // good to have but not strictly necessary
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCacheNames(Arrays.asList(
                "customers",
                "products"
        ));
        cacheManager.setCaffeine(caffeineCacheBuilder());
        return cacheManager;
    }

    Caffeine < Object, Object > caffeineCacheBuilder() {
        return Caffeine.newBuilder()
                .initialCapacity(100)
                .maximumSize(500)
                .expireAfterAccess(10, TimeUnit.MINUTES)
                .weakKeys()
                .recordStats();
    }

    /**
     * Second cache provider which can work as fallback or will be used when invoked explicitly in the
     * code base.
     */
    @Bean
    CacheManager alternateCacheManager() {
        return new ConcurrentMapCacheManager(cacheNames);
    }

    /**
     *  alternate cache manager.
     * @return CacheResolver
     */
    @Bean
    @Override
    public CacheResolver cacheResolver() {
        return new CustomCacheResolver(cacheManager(), alternateCacheManager());
    }
}
