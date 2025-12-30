package com.lru.cache.model;

import java.util.List;

public class CacheResponse {
    private List<List<Integer>> cacheStates;
    private List<Integer> evictedPages;
    private int hits;
    private int misses;

    // Getters and Setters
    public List<List<Integer>> getCacheStates() { return cacheStates; }
    public void setCacheStates(List<List<Integer>> cacheStates) { this.cacheStates = cacheStates; }

    public List<Integer> getEvictedPages() { return evictedPages; }
    public void setEvictedPages(List<Integer> evictedPages) { this.evictedPages = evictedPages; }

    public int getHits() { return hits; }
    public void setHits(int hits) { this.hits = hits; }

    public int getMisses() { return misses; }
    public void setMisses(int misses) { this.misses = misses; }
}
