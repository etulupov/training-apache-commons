package com.noveogroup.tulupov.commons.command.parser;

import com.noveogroup.tulupov.commons.command.parser.impl.CommandLineParserImpl;
import com.noveogroup.tulupov.commons.command.parser.impl.OptionsFactory;
import com.noveogroup.tulupov.commons.command.predicate.PredicateFactory;

/**
 * Parser factory.
 */
public final class ParserFactory {
    private ParserFactory() {
        throw new UnsupportedOperationException();
    }

    public static Parser createParser() {
        return new CommandLineParserImpl(OptionsFactory.createOptions(), PredicateFactory.createPredicates());
    }
}
