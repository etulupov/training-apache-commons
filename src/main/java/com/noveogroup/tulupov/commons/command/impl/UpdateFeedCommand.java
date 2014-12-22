package com.noveogroup.tulupov.commons.command.impl;

import com.noveogroup.tulupov.commons.command.Command;
import com.noveogroup.tulupov.commons.command.Context;
import com.noveogroup.tulupov.commons.manager.FeedManager;
import org.apache.commons.lang.Validate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Update feeds command.
 */
public class UpdateFeedCommand implements Command {
    private static final Log LOGGER = LogFactory.getLog(UpdateFeedCommand.class);

    @Override
    public void execute(final Context context) {
        Validate.notNull(context, "context is null");

        final FeedManager feedManager = context.getFeedManager();

        Validate.notNull(feedManager, "feedManager is null");

        LOGGER.info("Updating rss feeds");
        feedManager.refreshAll();
    }
}
