package com.noveogroup.tulupov.commons.database.storage;

import com.noveogroup.tulupov.commons.database.storage.impl.PlainStorageImpl;
import com.noveogroup.tulupov.commons.database.storage.impl.SerializationStorageImpl;
import lombok.Getter;

/**
 * Storage type.
 */
@SuppressWarnings("UnusedDeclaration")
public enum StorageType {
    PLAIN(PlainStorageImpl.class),
    SERIALIZATION(SerializationStorageImpl.class);

    @Getter
    private final Class<? extends Storage> clazz;

    private StorageType(final Class<? extends Storage> clazz) {
        this.clazz = clazz;
    }

}
