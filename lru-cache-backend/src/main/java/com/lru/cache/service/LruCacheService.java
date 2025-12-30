package com.lru.cache.service;

import com.lru.cache.model.CacheRequest;
import com.lru.cache.model.CacheResponse;
import com.lru.cache.util.LruCache;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LruCacheService {

    public CacheResponse simulate(CacheRequest request) {
        int cacheSize = request.getCacheSize();
        List<Integer> pages = request.getPages();

        LruCache lruCache = new LruCache(cacheSize);

        List<List<Integer>> cacheStates = new ArrayList<>();
        List<Integer> evictedPages = new ArrayList<>();
        int hits = 0, misses = 0;

        for (int page : pages) {
            List<Integer> prevState = lruCache.getCurrentState();
            boolean hit = lruCache.access(page);
            if (hit) hits++;
            else misses++;

            cacheStates.add(new ArrayList<>(lruCache.getCurrentState()));
            evictedPages.add(lruCache.getEvictedPage(prevState));
        }

        CacheResponse response = new CacheResponse();
        response.setCacheStates(cacheStates);
        response.setEvictedPages(evictedPages);
        response.setHits(hits);
        response.setMisses(misses);

        return response;
    }
}
