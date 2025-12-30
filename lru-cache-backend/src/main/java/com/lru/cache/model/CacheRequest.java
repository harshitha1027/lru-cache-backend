package com.lru.cache.model;

import java.util.List;

public class CacheRequest {
    private int cacheSize;
    private List<Integer> pages;

    // Getters and Setters
    public int getCacheSize() { return cacheSize; }
    public void setCacheSize(int cacheSize) { this.cacheSize = cacheSize; }

    public List<Integer> getPages() { return pages; }
    public void setPages(List<Integer> pages) { this.pages = pages; }
}
