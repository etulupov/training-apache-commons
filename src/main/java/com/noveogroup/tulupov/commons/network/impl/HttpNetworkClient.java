package com.noveogroup.tulupov.commons.network.impl;

import com.noveogroup.tulupov.commons.network.NetworkClient;
import com.noveogroup.tulupov.commons.network.exception.NetworkException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.IOException;

/**
 * Http network client.
 */
public class HttpNetworkClient implements NetworkClient {
    @Override
    public String get(final String url) throws NetworkException {
        final HttpClient httpClient = new HttpClient();
        final GetMethod getMethod = new GetMethod(url);

        try {
            final int statusCode = httpClient.executeMethod(getMethod);

            if (statusCode == HttpStatus.SC_OK) {
                final BufferedInputStream inputStream = new BufferedInputStream(getMethod.getResponseBodyAsStream());

                return IOUtils.toString(inputStream, Charsets.UTF_8);
            } else {
                throw new NetworkException("Bad status code=" + statusCode);
            }
        } catch (IOException e) {
            throw new NetworkException("Cannot download the data", e);
        }
    }
}
