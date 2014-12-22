package com.noveogroup.tulupov.commons.network;

import com.noveogroup.tulupov.commons.network.impl.HttpNetworkClient;

/**
 * Network client factory.
 */
public final class NetworkClientFactory {
    private NetworkClientFactory() {
        throw new UnsupportedOperationException();
    }

    public static NetworkClient createClient() {
        return new HttpNetworkClient();
    }
}
