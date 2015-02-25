package com.noveogroup.tulupov.commons.database.storage.impl;

import com.noveogroup.tulupov.commons.database.storage.Storage;
import org.apache.commons.lang.ObjectUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Abstract storage test.
 */
@SuppressWarnings("ResultOfMethodCallIgnored")
public abstract class AbstractStorageImplTest {
    private static final String TEST_FILE_PREFIX = "commons_storage_test";
    private static final String TEST_STRING = "test_string";
    private static final String TEST_STRING_2 = "test_string2";

    @Test
    public void testAdd() throws IOException {
        final File file = File.createTempFile(TEST_FILE_PREFIX, null);
        final Storage storage = createStorage(file);

        storage.add(TEST_STRING);

        final List<String> lines = loadList(file);

        assertTrue(ObjectUtils.equals(lines, storage.queryAll()));

        file.delete();
    }

    @Test
    public void testRemove() throws IOException {
        final File file = File.createTempFile(TEST_FILE_PREFIX, null);
        final Storage storage = createStorage(file);

        storage.add(TEST_STRING);
        storage.remove(TEST_STRING);

        final List<String> lines = loadList(file);

        assertTrue(ObjectUtils.equals(lines, storage.queryAll()));

        file.delete();
    }

    @Test
    public void testQueryAll() throws IOException {
        final File file = File.createTempFile(TEST_FILE_PREFIX, null);
        final Storage storage = createStorage(file);

        storage.add(TEST_STRING);
        storage.add(TEST_STRING_2);

        final List<String> lines = loadList(file);

        assertTrue(ObjectUtils.equals(lines, storage.queryAll()));

        file.delete();
    }


    protected abstract List<String> loadList(final File file) throws IOException;

    protected abstract Storage createStorage(final File file);

}
