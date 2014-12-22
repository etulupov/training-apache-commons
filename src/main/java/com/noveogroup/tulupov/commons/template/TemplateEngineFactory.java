package com.noveogroup.tulupov.commons.template;

import com.noveogroup.tulupov.commons.config.ConfigurationConstants;
import com.noveogroup.tulupov.commons.config.ConfigurationManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Template engine factory.
 */
public final class TemplateEngineFactory {
    private static final Log LOGGER = LogFactory.getLog(TemplateEngineFactory.class);

    private TemplateEngineFactory() {
        throw new UnsupportedOperationException();
    }


    public static TemplateEngine createEngine() {
        final TemplateEngineType type = ConfigurationManager.getInstance()
                .get(TemplateEngineType.class, ConfigurationConstants.TEMPLATE_ENGINE_TYPE);

        if (type == null) {
            LOGGER.error("Cannot get template engine type");
            return null;
        }

        try {
            return type.getClazz().newInstance();
        } catch (Exception e) {
            LOGGER.error("Cannot create template engine", e);
        }

        return null;
    }
}
