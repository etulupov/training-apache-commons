package com.noveogroup.tulupov.commons.template;

import com.noveogroup.tulupov.commons.template.exception.TemplateEngineException;

import java.io.Writer;
import java.util.Map;

/**
 * Template engine.
 */
public interface TemplateEngine {
    void generate(Map<String, Object> context, Writer writer) throws TemplateEngineException;
}
