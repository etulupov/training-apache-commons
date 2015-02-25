package com.noveogroup.tulupov.commons.template.impl;

import com.noveogroup.tulupov.commons.model.RssChannel;
import com.noveogroup.tulupov.commons.parser.RssParser;
import com.noveogroup.tulupov.commons.parser.RssParserFactory;
import com.noveogroup.tulupov.commons.template.TemplateConstants;
import com.noveogroup.tulupov.commons.template.TemplateEngine;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Velocity template engine test.
 */

public abstract class AbstractTemplateEngineTest {
    private final Class<? extends TemplateEngine> clazz;
    private final String expectedResultFilename;

    public AbstractTemplateEngineTest(final Class<? extends TemplateEngine> clazz,
                                      final String expectedResultFilename) {
        this.clazz = clazz;
        this.expectedResultFilename = expectedResultFilename;
    }

    @Test
    public void test() throws Exception {
        final RssParser parser = RssParserFactory.createParser();
        final String data = loadDataFromResource("/rss.xml");
        final RssChannel channel = parser.parse(data);
        final TemplateEngine templateEngine = clazz.newInstance();

        final Map<String, Object> context = new HashMap<String, Object>();
        context.put(TemplateConstants.RSS_CHANNEL, channel);

        final Writer writer = new StringWriter();

        templateEngine.generate(context, writer);

        Assert.assertEquals(loadDataFromResource(expectedResultFilename), writer.toString());
    }

    private String loadDataFromResource(final String resource) throws IOException {
        final File file = FileUtils.toFile(getClass().getResource(resource));

        if (file != null) {
            return FileUtils.readFileToString(file);
        }

        return null;
    }
}
