package com.noveogroup.tulupov.commons.database.storage.exception;

/**
 * Storage exception.
 */
public class StorageException extends RuntimeException {
    public StorageException(final String message) {
        super(message);
    }

    public StorageException(final String message, final Throwable cause) {
        super(message, cause);
    }
}