package com.noveogroup.tulupov.commons.database.storage.impl;

import com.noveogroup.tulupov.commons.database.storage.Storage;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * PlainStorageImpl test.
 */
public class PlainStorageImplTest extends AbstractStorageImplTest {

    @Override
    protected List<String> loadList(final File file) throws IOException {
        return FileUtils.readLines(file);
    }

    @Override
    protected Storage createStorage(final File file) {
        return new PlainStorageImpl(file.getPath());
    }
}
