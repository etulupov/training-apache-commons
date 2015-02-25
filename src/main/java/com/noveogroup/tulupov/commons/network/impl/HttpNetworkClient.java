package com.noveogroup.tulupov.commons.network.impl;

import com.noveogroup.tulupov.commons.network.NetworkClient;
import com.noveogroup.tulupov.commons.network.exception.NetworkException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;

/**
 * Http network client.
 */
public class HttpNetworkClient implements NetworkClient {
    private static final int CONNECTION_TIMEOUT = 10 * 1000;

    @Override
    public String get(final String url) throws NetworkException {
        final HttpClient httpClient = new HttpClient();

        final HttpClientParams params = httpClient.getParams();
        params.setIntParameter(HttpConnectionParams.CONNECTION_TIMEOUT, CONNECTION_TIMEOUT);
        params.setIntParameter(HttpConnectionParams.SO_TIMEOUT, CONNECTION_TIMEOUT);

        final GetMethod getMethod = new GetMethod(url);

        try {
            final int statusCode = httpClient.executeMethod(getMethod);

            if (statusCode == HttpStatus.SC_OK) {
                final BufferedInputStream inputStream = new BufferedInputStream(getMethod.getResponseBodyAsStream());

                return IOUtils.toString(inputStream, Charsets.UTF_8);
            } else {
                throw new NetworkException("Bad status code=" + statusCode);
            }
        } catch (Exception e) {
            throw new NetworkException("Cannot download the data", e);
        }
    }
}
