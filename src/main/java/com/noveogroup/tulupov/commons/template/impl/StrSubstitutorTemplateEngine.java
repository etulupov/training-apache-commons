package com.noveogroup.tulupov.commons.template.impl;

import com.noveogroup.tulupov.commons.model.Item;
import com.noveogroup.tulupov.commons.model.RssChannel;
import com.noveogroup.tulupov.commons.template.TemplateConstants;
import com.noveogroup.tulupov.commons.template.TemplateEngine;
import com.noveogroup.tulupov.commons.template.exception.TemplateEngineException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.text.StrBuilder;
import org.apache.commons.lang.text.StrSubstitutor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import static com.noveogroup.tulupov.commons.template.TemplateConstants.*;

/**
 * Substr template engine.
 */
@SuppressWarnings("UnusedDeclaration")
public class StrSubstitutorTemplateEngine implements TemplateEngine {
    private static final Log LOGGER = LogFactory.getLog(StrSubstitutorTemplateEngine.class);

    private static final String TEMPLATE_ITEM = "/template/rss_item.html";
    private static final String TEMPLATE_BASE = "/template/rss_base.html";

    private String itemTemplate;
    private String baseTemplate;

    public StrSubstitutorTemplateEngine() {

    }

    private void loadTemplates() throws TemplateEngineException {
        try {
            itemTemplate = loadDataFromResource(TEMPLATE_ITEM);
            baseTemplate = loadDataFromResource(TEMPLATE_BASE);
        } catch (IOException e) {
            throw new TemplateEngineException("Error while loading templates", e);
        }
    }

    @Override
    public void generate(final Map<String, Object> context, final Writer writer) throws TemplateEngineException {
        loadTemplates();

        final PrintWriter printWriter = new PrintWriter(writer);
        final RssChannel channel = (RssChannel) context.get(TemplateConstants.RSS_CHANNEL);

        final StrBuilder itemsStrBuilder = new StrBuilder();

        for (final Item item : channel.getItems()) {
            itemsStrBuilder.append(generateItem(item));
        }

        final Map<String, String> valuesMap = new HashMap<String, String>();

        valuesMap.put(RSS_TITLE, channel.getTitle());
        valuesMap.put(RSS_ITEMS, itemsStrBuilder.toString());

        final StrSubstitutor substitutor = new StrSubstitutor(valuesMap);

        printWriter.append(substitutor.replace(baseTemplate));
    }

    private String generateItem(final Item item) {
        final Map<String, String> valuesMap = new HashMap<String, String>();

        valuesMap.put(ITEM_LINK, item.getLink());
        valuesMap.put(ITEM_TITLE, item.getTitle());

        final StrSubstitutor substitutor = new StrSubstitutor(valuesMap);

        return substitutor.replace(itemTemplate);
    }


    private String loadDataFromResource(final String resource) throws IOException {
        final File file = FileUtils.toFile(getClass().getResource(resource));

        if (file != null) {
            return FileUtils.readFileToString(file);
        }

        return null;
    }
}
