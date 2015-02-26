package com.noveogroup.tulupov.commons.manager.impl;

import com.noveogroup.tulupov.commons.database.dao.DaoFactory;
import com.noveogroup.tulupov.commons.database.dao.LinkDao;
import com.noveogroup.tulupov.commons.manager.FeedManager;
import com.noveogroup.tulupov.commons.manager.impl.util.FileUtils;
import com.noveogroup.tulupov.commons.model.Link;
import com.noveogroup.tulupov.commons.model.RssChannel;
import com.noveogroup.tulupov.commons.network.NetworkClient;
import com.noveogroup.tulupov.commons.network.NetworkClientFactory;
import com.noveogroup.tulupov.commons.network.exception.NetworkException;
import com.noveogroup.tulupov.commons.parser.RssParser;
import com.noveogroup.tulupov.commons.parser.RssParserFactory;
import com.noveogroup.tulupov.commons.parser.exception.RssParseException;
import com.noveogroup.tulupov.commons.template.TemplateConstants;
import com.noveogroup.tulupov.commons.template.TemplateEngine;
import com.noveogroup.tulupov.commons.template.TemplateEngineFactory;
import com.noveogroup.tulupov.commons.util.BeanUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Rss manager implementation.
 */
public class RssFeedManagerImpl implements FeedManager {
    private static final Log LOGGER = LogFactory.getLog(RssFeedManagerImpl.class);
    private final LinkDao linkDao;

    public RssFeedManagerImpl() {
        this.linkDao = DaoFactory.createLinkDao();
    }

    @Override
    public void add(final String url) {
        linkDao.add(Link.builder().location(url).build());
    }

    @Override
    public void remove(final String url) {
        linkDao.remove(Link.builder().location(url).build());
    }

    @Override
    public void refreshAll() {
        final List<Link> links = linkDao.queryAll();

        if (links == null) {
            return;
        }

        for (final Link link : links) {
            final NetworkClient client = NetworkClientFactory.createClient();
            String content;
            try {
                content = client.get(link.getLocation());
            } catch (NetworkException e) {
                LOGGER.error("Cannot load content from " + link, e);
                continue;
            }

            final RssParser parser = RssParserFactory.createParser();
            RssChannel channel;
            try {
                channel = parser.parse(content);
            } catch (RssParseException e) {
                LOGGER.error("Cannot parse content from " + link, e);
                continue;
            }

            final TemplateEngine templateEngine = TemplateEngineFactory.createEngine();
            final Map<String, Object> context = new HashMap<String, Object>();

            try {
                context.put(TemplateConstants.RSS_CHANNEL, BeanUtils.escapeStringProperties(channel));
            } catch (Exception e) {
                LOGGER.error("Cannot escape strings from " + link, e);
            }

            Writer writer = null;
            try {
                writer = new FileWriter(FileUtils.getOutputFile(channel.getTitle()));
                templateEngine.generate(context, writer);
            } catch (Exception e) {
                LOGGER.error("Cannot generate file from " + link, e);
            } finally {
                IOUtils.closeQuietly(writer);
            }
        }
    }
}
