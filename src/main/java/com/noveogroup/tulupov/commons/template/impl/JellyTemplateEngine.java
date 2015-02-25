package com.noveogroup.tulupov.commons.template.impl;

import com.noveogroup.tulupov.commons.template.TemplateEngine;
import com.noveogroup.tulupov.commons.template.exception.TemplateEngineException;
import org.apache.commons.jelly.JellyContext;
import org.apache.commons.jelly.XMLOutput;

import java.io.Writer;
import java.util.Map;

/**
 * Jelly template engine.
 */
@SuppressWarnings("UnusedDeclaration")
public class JellyTemplateEngine implements TemplateEngine {
    private static final String TEMPLATE = "template/rss.xml";

    public JellyTemplateEngine() {

    }

    @Override
    public void generate(final Map<String, Object> data, final Writer writer) throws TemplateEngineException {
        try {
            final JellyContext context = new JellyContext();
            context.setVariables(data);

            final XMLOutput xmlOutput = XMLOutput.createXMLOutput(writer);
            context.runScript(getClass().getClassLoader().getResource(TEMPLATE), xmlOutput);
            xmlOutput.flush();
        } catch (Exception e) {
            throw new TemplateEngineException("Cannot generate page with Jelly", e);
        }
    }
}
