package com.noveogroup.tulupov.commons.database.storage;

import com.noveogroup.tulupov.commons.config.ConfigurationConstants;
import com.noveogroup.tulupov.commons.config.ConfigurationManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Storage factory.
 */
@SuppressWarnings("SameReturnValue")
public final class StorageFactory {
    private static final Log LOGGER = LogFactory.getLog(StorageFactory.class);

    private StorageFactory() {
        throw new UnsupportedOperationException();
    }

    public static Storage getLinkStorage() {
        return StorageHolder.INSTANCE;
    }

    /**
     * Instance holder.
     */
    private static class StorageHolder {
        public static final Storage INSTANCE;

        static {
            INSTANCE = initStorage();
        }

        private static Storage initStorage() {
            final String path = ConfigurationManager.getInstance()
                    .get(String.class, ConfigurationConstants.STORAGE_LINK);

            final StorageType type = ConfigurationManager.getInstance()
                    .get(StorageType.class, ConfigurationConstants.STORAGE_TYPE, StorageType.PLAIN);

            try {
                final Class<? extends Storage> clazz = type.getClazz();
                return clazz.getConstructor(String.class).newInstance(path);
            } catch (Exception e) {
                LOGGER.error("Cannot create storage", e);
            }

            return null;
        }
    }


}
