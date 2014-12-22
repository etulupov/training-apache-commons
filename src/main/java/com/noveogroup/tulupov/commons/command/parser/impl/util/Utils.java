package com.noveogroup.tulupov.commons.command.parser.impl.util;

import com.noveogroup.tulupov.commons.command.CommandConstants;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

/**
 * Command util class.
 */
public final class Utils {

    private Utils() {
        throw new UnsupportedOperationException();
    }


    public static void showHelp(final Options options) {
        final HelpFormatter helpFormatter = new HelpFormatter();

        helpFormatter.printHelp(CommandConstants.SYNTAX, options);
    }
}
