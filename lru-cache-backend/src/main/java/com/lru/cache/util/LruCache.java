package com.lru.cache.util;

import java.util.*;

public class LruCache {
    private final int capacity;
    private final LinkedHashMap<Integer, Integer> cache;

    public LruCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public boolean access(int page) {
        boolean hit = cache.containsKey(page);
        if (hit) {
            cache.get(page); // access to update order
        } else {
            if (cache.size() >= capacity) {
                Iterator<Integer> it = cache.keySet().iterator();
                Integer lru = it.next();
                it.remove();
            }
            cache.put(page, page);
        }
        return hit;
    }

    public List<Integer> getCurrentState() {
        return new ArrayList<>(cache.keySet());
    }

    public Integer getEvictedPage(List<Integer> previousState) {
        for (Integer p : previousState) {
            if (!cache.containsKey(p)) return p;
        }
        return null;
    }
}
