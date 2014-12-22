package com.noveogroup.tulupov.commons.template.impl;

import com.noveogroup.tulupov.commons.template.TemplateEngine;
import com.noveogroup.tulupov.commons.template.exception.TemplateEngineException;
import org.apache.commons.io.Charsets;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.Writer;
import java.util.Map;

/**
 * Velocity template engine.
 */
public class VelocityTemplateEngine implements TemplateEngine {
    private static final String RESOURCE_LOADER_CLASS = "classpath.resource.loader.class";
    private static final String RESOURCE_LOADER_CLASSPATH = "classpath";
    private static final String TEMPLATE = "template/rss.vm";

    public VelocityTemplateEngine() {
        Velocity.setProperty(RuntimeConstants.RESOURCE_LOADER, RESOURCE_LOADER_CLASSPATH);
        Velocity.setProperty(RESOURCE_LOADER_CLASS, ClasspathResourceLoader.class.getName());
        Velocity.init();
    }

    @Override
    public void generate(final Map<String, Object> data, final Writer writer) throws TemplateEngineException {
        final VelocityContext context = new VelocityContext(data);

        try {
            Velocity.mergeTemplate(TEMPLATE, Charsets.UTF_8.toString(), context, writer);
        } catch (Exception e) {
            throw new TemplateEngineException("Cannot generate page with Velocity", e);
        }
    }
}
