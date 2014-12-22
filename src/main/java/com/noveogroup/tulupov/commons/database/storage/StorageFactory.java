package com.noveogroup.tulupov.commons.database.storage;

import com.noveogroup.tulupov.commons.config.ConfigurationConstants;
import com.noveogroup.tulupov.commons.config.ConfigurationManager;
import com.noveogroup.tulupov.commons.database.storage.impl.StorageImpl;

/**
 * Storage factory.
 */
public final class StorageFactory {
    private static Storage linkStorage;

    private StorageFactory() {
        throw new UnsupportedOperationException();
    }

    public static Storage getLinkStorage() {
        if (linkStorage == null) {
            final String path = ConfigurationManager.getInstance()
                    .get(String.class, ConfigurationConstants.STORAGE_LINK);

            linkStorage = new StorageImpl(path);
        }

        return linkStorage;
    }
}
