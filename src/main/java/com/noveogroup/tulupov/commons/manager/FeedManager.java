package com.noveogroup.tulupov.commons.manager;

/**
 * Feed manager.
 */
public interface FeedManager {
    void add(String url);

    void remove(String url);

    void refreshAll();
}
