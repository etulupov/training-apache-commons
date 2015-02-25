package com.noveogroup.tulupov.commons.command.parser.impl;

import com.noveogroup.tulupov.commons.command.parser.Parser;
import com.noveogroup.tulupov.commons.command.parser.Result;
import com.noveogroup.tulupov.commons.command.parser.impl.util.Utils;
import com.noveogroup.tulupov.commons.command.predicate.CommandPredicate;
import org.apache.commons.cli.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * Command line parser.
 */
public class CommandLineParserImpl implements Parser {
    private static final Log LOGGER = LogFactory.getLog(CommandLineParserImpl.class);

    private final Options options;
    private final List<CommandPredicate> predicates;

    public CommandLineParserImpl(final Options options, final List<CommandPredicate> predicates) {
        this.options = options;
        this.predicates = predicates;
    }

    @Override
    public Result parse(final String[] args) {
        final CommandLineParser parser = new BasicParser();
        try {
            final CommandLine commandLine = parser.parse(options, args);
            for (final CommandPredicate predicate : predicates) {
                if (predicate.evaluate(commandLine)) {
                    return new Result(predicate.getCommand(), commandLine);
                }
            }
        } catch (ParseException e) {
            LOGGER.error("Cannot parse command line", e);
        }

        Utils.showHelp(options);
        return null;
    }
}
