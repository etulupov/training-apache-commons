package com.noveogroup.tulupov.commons.parser.exception;

/**
 * Rss parse exception.
 */
public class RssParseException extends Exception {

    public RssParseException(final String message) {
        super(message);
    }

    public RssParseException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
