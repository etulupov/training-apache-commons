package com.noveogroup.tulupov.commons.database.dao;

import com.noveogroup.tulupov.commons.model.Link;

import java.util.List;

/**
 * Link dao.
 */
public interface LinkDao {
    void add(Link link);

    void remove(Link link);

    List<Link> queryAll();
}
