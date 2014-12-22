package com.noveogroup.tulupov.commons.database.storage;

import java.util.List;

/**
 * Storage.
 */
public interface Storage {
    void add(String line);

    void remove(String line);

    List<String> queryAll();
}
