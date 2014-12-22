package com.noveogroup.tulupov.commons.command;

/**
 * Command constants.
 */
public final class CommandConstants {
    public static final String COMMAND_SHORT_ADD = "a";
    public static final String COMMAND_SHORT_REMOVE = "r";
    public static final String COMMAND_SHORT_REFRESH = "u";
    public static final String COMMAND_SHORT_HELP = "h";

    public static final String COMMAND_LONG_ADD = "add";
    public static final String COMMAND_LONG_REMOVE = "remove";
    public static final String COMMAND_LONG_REFRESH = "update";
    public static final String COMMAND_LONG_HELP = "help";

    public static final String COMMAND_DESCRIPTION_ADD = "Add new feed url";
    public static final String COMMAND_DESCRIPTION_REMOVE = "Remove feed url";
    public static final String COMMAND_DESCRIPTION_REFRESH = "Refresh all feeds";
    public static final String COMMAND_DESCRIPTION_HELP = "Show usage help";

    public static final String SYNTAX = "-a <url> | -r <url> | -u | -h";

    private CommandConstants() {
        throw new UnsupportedOperationException();
    }
}
