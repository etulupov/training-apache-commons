package com.noveogroup.tulupov.commons.database.dao;

import com.noveogroup.tulupov.commons.database.dao.impl.LinkDaoImpl;
import com.noveogroup.tulupov.commons.database.storage.Storage;
import com.noveogroup.tulupov.commons.database.storage.StorageFactory;

/**
 * Dao factory.
 */
public final class DaoFactory {
    public static LinkDao createLinkDao() {
        final Storage storage = StorageFactory.getLinkStorage();

        return new LinkDaoImpl(storage);
    }
}
