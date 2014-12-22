package com.noveogroup.tulupov.commons.database.dao.impl;

import com.noveogroup.tulupov.commons.database.dao.LinkDao;
import com.noveogroup.tulupov.commons.database.storage.Storage;
import com.noveogroup.tulupov.commons.model.Link;
import org.apache.commons.validator.GenericValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Link dao implementation.
 */
public class LinkDaoImpl implements LinkDao {
    private final Storage storage;

    public LinkDaoImpl(final Storage storage) {
        this.storage = storage;
    }

    @Override
    public void add(final Link link) {
        validateLink(link);
        storage.add(link.getLocation());
    }

    @Override
    public void remove(final Link link) {
        validateLink(link);
        storage.remove(link.getLocation());
    }

    @Override
    public List<Link> queryAll() {
        final List<String> lines = storage.queryAll();
        if (lines == null) {
            return null;
        }

        final List<Link> result = new ArrayList<Link>();

        for (final String line : lines) {
            result.add(Link.builder().location(line).build());
        }

        return result;
    }

    private void validateLink(final Link link) {
        if (!GenericValidator.isUrl(link.getLocation())) {
            throw new IllegalArgumentException("Url is invalid");
        }
    }
}
