package com.noveogroup.tulupov.commons.database.storage.impl;

import com.noveogroup.tulupov.commons.database.storage.Storage;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * StorageImpl test.
 */
@SuppressWarnings("ResultOfMethodCallIgnored")
public class StorageImplTest {
    private static final String TEST_FILE = "test.db";
    private static final String TEST_STRING = "test_string";
    private static final String TEST_STRING_2 = "test_string2";

    @Test
    public void testAdd() throws IOException {
        final Storage storage = new StorageImpl(TEST_FILE);
        final File file = new File(TEST_FILE);

        storage.add(TEST_STRING);

        final List<String> lines = FileUtils.readLines(file);
        assertNotNull(lines);
        assertEquals(1, lines.size());
        assertEquals(TEST_STRING, lines.get(0));

        file.delete();
    }

    @Test
    public void testRemove() throws IOException {
        final Storage storage = new StorageImpl(TEST_FILE);
        final File file = new File(TEST_FILE);

        storage.add(TEST_STRING);
        storage.remove(TEST_STRING);

        final List<String> lines = FileUtils.readLines(file);
        assertNotNull(lines);
        assertEquals(0, lines.size());

        file.delete();
    }

    @Test
    public void testQueryAll() throws IOException {
        final Storage storage = new StorageImpl(TEST_FILE);
        final File file = new File(TEST_FILE);

        storage.add(TEST_STRING);
        storage.add(TEST_STRING_2);

        final List<String> lines = FileUtils.readLines(file);
        assertNotNull(lines);
        assertEquals(2, lines.size());

        file.delete();
    }
}
