package com.noveogroup.tulupov.commons.command.impl;

import com.noveogroup.tulupov.commons.command.Command;
import com.noveogroup.tulupov.commons.command.CommandConstants;
import com.noveogroup.tulupov.commons.command.Context;
import com.noveogroup.tulupov.commons.manager.FeedManager;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.lang.Validate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.GenericValidator;

/**
 * Add new feed url command.
 */
public class AddFeedCommand implements Command {
    private static final Log LOGGER = LogFactory.getLog(AddFeedCommand.class);

    @Override
    public void execute(final Context context) {
        Validate.notNull(context, "context is null");

        final FeedManager feedManager = context.getFeedManager();
        final CommandLine commandLine = context.getCommandLine();

        Validate.notNull(feedManager, "feedManager is null");
        Validate.notNull(commandLine, "commandLine is null");

        final String url = commandLine.getOptionValue(CommandConstants.COMMAND_SHORT_ADD);

        if (GenericValidator.isUrl(url)) {
            LOGGER.info("Add new feed url=" + url);
            feedManager.add(url);
        } else {
            LOGGER.error("Invalid url=" + url);
        }
    }
}
