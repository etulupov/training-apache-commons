package com.noveogroup.tulupov.commons.parser;

import com.noveogroup.tulupov.commons.parser.impl.DigesterRssParser;

/**
 * Rss parser factory.
 */
public final class RssParserFactory {
    private RssParserFactory() {
        throw new UnsupportedOperationException();
    }

    public static RssParser createParser() {
        return new DigesterRssParser();
    }
}
