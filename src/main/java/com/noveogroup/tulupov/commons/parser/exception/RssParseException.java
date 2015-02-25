package com.noveogroup.tulupov.commons.parser.exception;

/**
 * Rss parse exception.
 */
@SuppressWarnings({ "SameParameterValue", "unused" })
public class RssParseException extends Exception {

    public RssParseException(final String message) {
        super(message);
    }

    public RssParseException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
