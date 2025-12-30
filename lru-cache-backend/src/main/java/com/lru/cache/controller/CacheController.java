package com.lru.cache.controller;

import com.lru.cache.model.CacheRequest;
import com.lru.cache.model.CacheResponse;
import com.lru.cache.service.LruCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cache")
@CrossOrigin(origins = "http://localhost:3000")
public class CacheController {

    @Autowired
    private LruCacheService cacheService;

    @PostMapping("/simulate")
    public CacheResponse simulateCache(@RequestBody CacheRequest request) {
        return cacheService.simulate(request);
    }
}
