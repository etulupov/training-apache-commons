package com.noveogroup.tulupov.commons.database.storage;

import com.noveogroup.tulupov.commons.config.ConfigurationConstants;
import com.noveogroup.tulupov.commons.config.ConfigurationManager;
import com.noveogroup.tulupov.commons.database.storage.impl.StorageImpl;

/**
 * Storage factory.
 */
public final class StorageFactory {

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
            final String path = ConfigurationManager.getInstance()
                    .get(String.class, ConfigurationConstants.STORAGE_LINK);

            INSTANCE = new StorageImpl(path);
        }
    }
}
