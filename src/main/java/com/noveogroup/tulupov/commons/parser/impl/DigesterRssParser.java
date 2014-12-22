package com.noveogroup.tulupov.commons.parser.impl;

import com.noveogroup.tulupov.commons.model.RssChannel;
import com.noveogroup.tulupov.commons.parser.RssParser;
import com.noveogroup.tulupov.commons.parser.exception.RssParseException;
import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.annotations.FromAnnotationsRuleModule;
import org.apache.commons.digester3.binder.DigesterLoader;

import java.io.StringReader;

/**
 * Rss parser implementation.
 */
public class DigesterRssParser implements RssParser {
    private final Digester digester;

    public DigesterRssParser() {
        final DigesterLoader digesterLoader = DigesterLoader.newLoader(new FromAnnotationsRuleModule() {
            @Override
            protected void configureRules() {
                bindRulesFrom(RssChannel.class);
            }
        });
        digesterLoader.setErrorHandler(new ErrorHandler());

        this.digester = digesterLoader.newDigester();
    }

    @Override
    public RssChannel parse(final String data) throws RssParseException {
        try {
            return digester.parse(new StringReader(data));
        } catch (Exception e) {
            throw new RssParseException("Cannot parse RSS document", e);
        }
    }
}
