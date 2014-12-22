package com.noveogroup.tulupov.commons.parser.impl;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * Error handler.
 */
public class ErrorHandler implements org.xml.sax.ErrorHandler {
    @Override
    public void warning(final SAXParseException e) throws SAXException {
        throw e;
    }

    @Override
    public void error(final SAXParseException e) throws SAXException {
        throw e;
    }

    @Override
    public void fatalError(final SAXParseException e) throws SAXException {
        throw e;
    }
}
