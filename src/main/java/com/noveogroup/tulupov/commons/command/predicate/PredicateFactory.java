package com.noveogroup.tulupov.commons.command.predicate;

import com.noveogroup.tulupov.commons.command.CommandConstants;
import com.noveogroup.tulupov.commons.command.impl.AddFeedCommand;
import com.noveogroup.tulupov.commons.command.impl.HelpCommand;
import com.noveogroup.tulupov.commons.command.impl.RemoveFeedCommand;
import com.noveogroup.tulupov.commons.command.impl.UpdateFeedCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * Predicate factory.
 */
public final class PredicateFactory {
    private PredicateFactory() {
        throw new UnsupportedOperationException();
    }

    public static List<CommandPredicate> createPredicates() {
        final List<CommandPredicate> predicates = new ArrayList<CommandPredicate>();

        predicates.add(new CommandPredicate(
                new AddFeedCommand(),
                CommandConstants.COMMAND_SHORT_ADD));

        predicates.add(new CommandPredicate(
                new RemoveFeedCommand(),
                CommandConstants.COMMAND_SHORT_REMOVE));

        predicates.add(new CommandPredicate(
                new UpdateFeedCommand(),
                CommandConstants.COMMAND_SHORT_REFRESH));

        predicates.add(new CommandPredicate(
                new HelpCommand(),
                CommandConstants.COMMAND_SHORT_HELP));

        return predicates;
    }
}
