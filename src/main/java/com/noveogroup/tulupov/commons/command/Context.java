package com.noveogroup.tulupov.commons.command;

import com.noveogroup.tulupov.commons.manager.FeedManager;
import org.apache.commons.cli.CommandLine;

/**
 * Command context interface.
 */
public interface Context {
    FeedManager getFeedManager();

    CommandLine getCommandLine();
}
