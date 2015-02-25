package com.noveogroup.tulupov.commons.network.impl;

import com.noveogroup.tulupov.commons.network.NetworkClient;
import com.noveogroup.tulupov.commons.network.exception.NetworkException;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import static net.jadler.Jadler.*;
import static org.junit.Assert.assertEquals;

/**
 * HttpNetworkClient test.
 */
@FixMethodOrder
public class HttpNetworkClientTest {
    private static final String TEST_CONTENT = "This is test content!";
    private static final String TEST_URL = "http://localhost:8080/test.txt";
    private static final String TEST_BAD_URL = "http://localhost:8080/not_found";

    private static final int DEFAULT_PORT = 8080;
    private static final int DEFAULT_STATUS = 200;
    private static final String DEFAULT_CONTENT_TYPE = "text/plain; charset=UTF-8";
    private static final String DEFAULT_METHOD = "GET";
    private static final String DEFAULT_PATH = "/test.txt";
    private static final long GOOD_TIMEOUT = 1;
    private static final long BAD_TIMEOUT = 10;

    @Before
    public void setUp() {
        initJadlerListeningOn(DEFAULT_PORT)
                .that()
                .respondsWithDefaultStatus(DEFAULT_STATUS)
                .respondsWithDefaultContentType(DEFAULT_CONTENT_TYPE)
                .respondsWithDefaultEncoding(StandardCharsets.UTF_8);
    }

    @After
    public void tearDown() {
        closeJadler();
    }

    @Test
    public void testSuccess() throws NetworkException {
        onRequest()
                .havingMethodEqualTo(DEFAULT_METHOD)
                .havingURIEqualTo(DEFAULT_PATH)
                .respond()
                .withTimeout(GOOD_TIMEOUT, TimeUnit.SECONDS)
                .withBody(TEST_CONTENT);

        final NetworkClient networkClient = new HttpNetworkClient();
        assertEquals(TEST_CONTENT, networkClient.get(TEST_URL));
    }

    @Test(expected = NetworkException.class)
    public void testTimeoutIsOver() throws NetworkException {
        onRequest()
                .havingMethodEqualTo(DEFAULT_METHOD)
                .havingURIEqualTo(DEFAULT_PATH)
                .respond()
                .withTimeout(BAD_TIMEOUT, TimeUnit.SECONDS)
                .withBody(TEST_CONTENT);

        final NetworkClient networkClient = new HttpNetworkClient();
        assertEquals(TEST_CONTENT, networkClient.get(TEST_URL));
    }

    @Test(expected = NetworkException.class)
    public void testNotFound() throws NetworkException {
        final NetworkClient networkClient = new HttpNetworkClient();
        assertEquals(TEST_CONTENT, networkClient.get(TEST_BAD_URL));
    }

}
