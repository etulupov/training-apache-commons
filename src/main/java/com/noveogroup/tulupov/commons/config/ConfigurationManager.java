package com.noveogroup.tulupov.commons.config;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.DataConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Configuration manager.
 */
public final class ConfigurationManager {
    private static final String CONFIG_FILE = "config.properties";
    private static final Log LOGGER = LogFactory.getLog(ConfigurationManager.class);

    private static ConfigurationManager instance;

    private DataConfiguration configuration;

    private ConfigurationManager() {
        try {
            this.configuration = new DataConfiguration(new PropertiesConfiguration(CONFIG_FILE));
        } catch (ConfigurationException e) {
            LOGGER.error("Cannot load config file", e);
        }
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }

        return instance;
    }

    public <T> T get(final Class<T> clazz, final String key) {
        if (configuration != null) {
            return configuration.get(clazz, key);
        }

        return null;
    }
}
