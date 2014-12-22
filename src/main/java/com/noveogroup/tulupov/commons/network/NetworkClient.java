package com.noveogroup.tulupov.commons.network;

import com.noveogroup.tulupov.commons.network.exception.NetworkException;

/**
 * Network client.
 */
public interface NetworkClient {
    String get(String url) throws NetworkException;
}
