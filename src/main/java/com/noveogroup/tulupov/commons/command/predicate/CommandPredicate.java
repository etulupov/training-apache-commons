package com.noveogroup.tulupov.commons.command.predicate;

import com.noveogroup.tulupov.commons.command.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.collections.Predicate;

/**
 * Command predicate.
 */
@AllArgsConstructor
public class CommandPredicate implements Predicate {
    @Getter
    private Command command;
    private final String option;

    @Override
    public boolean evaluate(final Object object) {
        if (object instanceof CommandLine) {
            final CommandLine cmd = (CommandLine) object;
            if (cmd.hasOption(option)) {
                return true;
            }
        }
        return false;
    }
}
