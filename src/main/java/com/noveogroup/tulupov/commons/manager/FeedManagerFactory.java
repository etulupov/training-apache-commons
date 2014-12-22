package com.noveogroup.tulupov.commons.manager;

import com.noveogroup.tulupov.commons.manager.impl.RssFeedManagerImpl;

/**
 * Feed manager factory.
 */
public final class FeedManagerFactory {
    private FeedManagerFactory() {
        throw new UnsupportedOperationException();
    }

    public static FeedManager createFeedManager() {
        return new RssFeedManagerImpl();
    }
}
