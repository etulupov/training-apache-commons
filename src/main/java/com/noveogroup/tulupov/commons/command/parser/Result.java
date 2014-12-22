package com.noveogroup.tulupov.commons.command.parser;

import com.noveogroup.tulupov.commons.command.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.cli.CommandLine;

/**
 * Represents the parsing result.
 */
@AllArgsConstructor
public class Result {
    @Getter
    private Command command;

    @Getter
    private CommandLine commandLine;

}

