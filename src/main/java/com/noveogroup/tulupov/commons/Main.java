package com.noveogroup.tulupov.commons;

import com.noveogroup.tulupov.commons.command.Command;
import com.noveogroup.tulupov.commons.command.Context;
import com.noveogroup.tulupov.commons.command.impl.ContextImpl;
import com.noveogroup.tulupov.commons.command.parser.Parser;
import com.noveogroup.tulupov.commons.command.parser.ParserFactory;
import com.noveogroup.tulupov.commons.command.parser.Result;
import com.noveogroup.tulupov.commons.manager.FeedManager;
import com.noveogroup.tulupov.commons.manager.FeedManagerFactory;

/**
 * RSS client application.
 */
public class Main {
    /**
     * Main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        final Parser parser = ParserFactory.createParser();
        final Result result = parser.parse(args);

        if (result != null) {
            final FeedManager feedManager = FeedManagerFactory.createFeedManager();
            final Context context = ContextImpl.builder()
                    .feedManager(feedManager)
                    .commandLine(result.getCommandLine())
                    .build();
            final Command command = result.getCommand();

            command.execute(context);
        }
    }
}
