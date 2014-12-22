package com.noveogroup.tulupov.commons.parser.impl;

import com.noveogroup.tulupov.commons.model.RssChannel;
import com.noveogroup.tulupov.commons.parser.RssParser;
import com.noveogroup.tulupov.commons.parser.exception.RssParseException;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * DigesterRssParser test.
 */
public class DigesterRssParserTest {
    public static final int ITEM_COUNT = 20;
    @Test
    public void testValidRss() throws Exception {
        final RssParser parser = new DigesterRssParser();
        final String data = loadDataFromResource("/rss.xml");
        final RssChannel channel = parser.parse(data);

        assertNotNull(channel);
        assertNotNull(channel.getTitle());
        assertNotNull(channel.getItems());

        assertEquals("NYT > World", channel.getTitle());
        assertEquals(ITEM_COUNT, channel.getItems().size());
    }

    @Test(expected = RssParseException.class)
    public void testInvalidRss() throws Exception {
        final RssParser parser = new DigesterRssParser();
        final String data = loadDataFromResource("/bad_rss.xml");

        parser.parse(data);
    }

    private String loadDataFromResource(final String resource) throws IOException {
        return FileUtils.readFileToString(FileUtils.toFile(getClass().getResource(resource)));
    }
}
