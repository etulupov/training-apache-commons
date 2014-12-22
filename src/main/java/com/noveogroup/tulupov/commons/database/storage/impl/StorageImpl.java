package com.noveogroup.tulupov.commons.database.storage.impl;

import com.noveogroup.tulupov.commons.database.storage.Storage;
import com.noveogroup.tulupov.commons.database.storage.exception.StorageException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Storage implementation.
 */
public class StorageImpl implements Storage {
    private final File file;

    public StorageImpl(final String path) {
        this.file = new File(path);
    }

    @Override
    public synchronized void add(final String line) {
        try {
            final List<String> lines = queryAll();
            final Set<String> set = new HashSet<String>(lines != null ? lines : new ArrayList<String>());

            set.add(line);
            FileUtils.writeLines(file, set, false);
        } catch (IOException e) {
            throw new StorageException("Cannot add new line", e);
        }
    }

    @Override
    public synchronized void remove(final String line) {
        try {
            final List<String> lines = queryAll();
            final Set<String> set = new HashSet<String>(lines != null ? lines : new ArrayList<String>());

            if (set.remove(line)) {
                FileUtils.writeLines(file, set, false);
            } else {
                throw new StorageException("The line was not found");
            }
        } catch (IOException e) {
            throw new StorageException("Cannot remove line", e);
        }
    }

    @Override
    public synchronized List<String> queryAll() {
        if (!file.exists()) {
            return null;
        }

        try {
            final List<String> lines = FileUtils.readLines(file);
            return lines;
        } catch (Exception e) {
            throw new StorageException("Cannot load list of lines");
        }
    }
}
