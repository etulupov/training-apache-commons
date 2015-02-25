package com.noveogroup.tulupov.commons.database.storage.impl;

import com.noveogroup.tulupov.commons.database.storage.Storage;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.SerializationUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * PlainStorageImpl test.
 */
@SuppressWarnings("unchecked")
public class SerializationStorageImplTest extends AbstractStorageImplTest {

    @Override
    protected List<String> loadList(final File file) throws IOException {
        return (List<String>) SerializationUtils.deserialize(FileUtils.openInputStream(file));
    }

    @Override
    protected Storage createStorage(final File file) {
        return new SerializationStorageImpl(file.getPath());
    }
}
