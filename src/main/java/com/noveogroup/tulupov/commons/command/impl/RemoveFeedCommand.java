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
 * Remove url from feed list command.
 */
public class RemoveFeedCommand implements Command {
    private static final Log LOGGER = LogFactory.getLog(RemoveFeedCommand.class);

    @Override
    public void execute(final Context context) {
        Validate.notNull(context, "context is null");

        final FeedManager feedManager = context.getFeedManager();
        final CommandLine commandLine = context.getCommandLine();

        Validate.notNull(feedManager, "feedManager is null");
        Validate.notNull(commandLine, "commandLine is null");

        final String url = commandLine.getOptionValue(CommandConstants.COMMAND_SHORT_REMOVE);

        if (GenericValidator.isUrl(url)) {
            LOGGER.info("Remove from feed list url=" + url);
            feedManager.remove(url);
        } else {
            LOGGER.error("Invalid url=" + url);
        }
    }
}
