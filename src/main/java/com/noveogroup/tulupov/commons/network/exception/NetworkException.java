package com.noveogroup.tulupov.commons.network.exception;

/**
 * Network exception.
 */
public class NetworkException extends Exception {
    public NetworkException(final String message) {
        super(message);
    }

    public NetworkException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
