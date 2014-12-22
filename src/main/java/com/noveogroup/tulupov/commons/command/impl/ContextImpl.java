package com.noveogroup.tulupov.commons.command.impl;

import com.noveogroup.tulupov.commons.command.Context;
import com.noveogroup.tulupov.commons.manager.FeedManager;
import lombok.Getter;
import lombok.experimental.Builder;
import org.apache.commons.cli.CommandLine;

/**
 * Command context implementation.
 */
@Builder
public class ContextImpl implements Context {
    @Getter
    private FeedManager feedManager;

    @Getter
    private CommandLine commandLine;
}
