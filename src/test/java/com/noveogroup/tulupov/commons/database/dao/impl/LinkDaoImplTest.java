package com.noveogroup.tulupov.commons.database.dao.impl;

import com.noveogroup.tulupov.commons.database.dao.LinkDao;
import com.noveogroup.tulupov.commons.database.storage.Storage;
import com.noveogroup.tulupov.commons.model.Link;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * LinkDaoImpl test.
 */
public class LinkDaoImplTest {
    private static final Link LINK_INVALID = new Link("invalid.url");
    private static final Link LINK_VALID = new Link("http://example.com");

    @Test
    public void testValidUrl() {
        final Storage storage = Mockito.mock(Storage.class);
        final LinkDao dao = new LinkDaoImpl(storage);

        dao.add(LINK_VALID);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidUrl() {
        final Storage storage = Mockito.mock(Storage.class);
        final LinkDao dao = new LinkDaoImpl(storage);

        dao.add(LINK_INVALID);
    }
}
