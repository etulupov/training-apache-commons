package com.noveogroup.tulupov.commons.template.exception;

/**
 * Template engine exception.
 */
@SuppressWarnings("unused")
public class TemplateEngineException extends Exception {

    public TemplateEngineException(final String message) {
        super(message);
    }

    public TemplateEngineException(final String message, final  Throwable cause) {
        super(message, cause);
    }
}
