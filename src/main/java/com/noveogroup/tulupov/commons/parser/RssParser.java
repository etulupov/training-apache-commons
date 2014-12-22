package com.noveogroup.tulupov.commons.parser;

import com.noveogroup.tulupov.commons.model.RssChannel;
import com.noveogroup.tulupov.commons.parser.exception.RssParseException;

/**
 * Rss parser.
 */
public interface RssParser {
    RssChannel parse(String data) throws RssParseException;
}
