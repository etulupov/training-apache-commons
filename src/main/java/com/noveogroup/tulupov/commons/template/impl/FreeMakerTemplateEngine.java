package com.noveogroup.tulupov.commons.template.impl;

import com.noveogroup.tulupov.commons.template.TemplateEngine;
import com.noveogroup.tulupov.commons.template.exception.TemplateEngineException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import org.apache.commons.io.Charsets;

import java.io.Writer;
import java.util.Map;

/**
 * FreeMaker template engine.
 */
public class FreeMakerTemplateEngine implements TemplateEngine {
    private static final int FREE_MAKER_MAJOR_VERSION = 2;
    private static final int FREE_MAKER_MINOR_VERSION = 3;
    private static final int FREE_MAKER_MICRO_VERSION = 20;

    private static final String TEMPLATE = "template/rss.ftl";

    private Configuration configuration;

    public FreeMakerTemplateEngine() {
        configuration = new Configuration();
        configuration.setClassForTemplateLoading(FreeMakerTemplateEngine.class, "/");
        configuration.setIncompatibleImprovements(
                new Version(FREE_MAKER_MAJOR_VERSION,
                        FREE_MAKER_MINOR_VERSION,
                        FREE_MAKER_MICRO_VERSION));
        configuration.setDefaultEncoding(Charsets.UTF_8.toString());
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }

    @Override
    public void generate(final Map<String, Object> context, final Writer writer) throws TemplateEngineException {
        try {
            final Template template = configuration.getTemplate(TEMPLATE);
            template.process(context, writer);
        } catch (Exception e) {
            throw new TemplateEngineException("Cannot generate page with Free Maker", e);
        }
    }
}