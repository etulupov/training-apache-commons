package com.noveogroup.tulupov.commons.command.impl;

import com.noveogroup.tulupov.commons.command.Command;
import com.noveogroup.tulupov.commons.command.Context;
import com.noveogroup.tulupov.commons.command.parser.impl.OptionsFactory;
import com.noveogroup.tulupov.commons.command.parser.impl.util.Utils;

/**
 * Help command.
 */
public class HelpCommand implements Command {
    @Override
    public void execute(final Context context) {
        Utils.showHelp(OptionsFactory.createOptions());
    }
}
