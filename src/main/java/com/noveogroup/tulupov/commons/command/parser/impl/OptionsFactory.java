package com.noveogroup.tulupov.commons.command.parser.impl;

import com.noveogroup.tulupov.commons.command.CommandConstants;
import org.apache.commons.cli.Options;

/**
 * Options factory.
 */
public final class OptionsFactory {
    private OptionsFactory() {
        throw new UnsupportedOperationException();
    }

    public static Options createOptions() {
        final Options options = new Options();

        options.addOption(CommandConstants.COMMAND_SHORT_ADD,
                CommandConstants.COMMAND_LONG_ADD,
                true,
                CommandConstants.COMMAND_DESCRIPTION_ADD);

        options.addOption(CommandConstants.COMMAND_SHORT_REMOVE,
                CommandConstants.COMMAND_LONG_REMOVE,
                true,
                CommandConstants.COMMAND_DESCRIPTION_REMOVE);

        options.addOption(CommandConstants.COMMAND_SHORT_REFRESH,
                CommandConstants.COMMAND_LONG_REFRESH,
                false,
                CommandConstants.COMMAND_DESCRIPTION_REFRESH);

        options.addOption(CommandConstants.COMMAND_SHORT_HELP,
                CommandConstants.COMMAND_LONG_HELP,
                false,
                CommandConstants.COMMAND_DESCRIPTION_HELP);

        return options;
    }
}
