package com.noveogroup.tulupov.commons.template;

import com.noveogroup.tulupov.commons.template.impl.*;
import lombok.Getter;

/**
 * Template engine type.
 */
@SuppressWarnings("UnusedDeclaration")
public enum TemplateEngineType {
    JEXL(JexlTemplateEngine.class),
    FREE_MARKER(FreeMakerTemplateEngine.class),
    VELOCITY(VelocityTemplateEngine.class),
    JELLY(JellyTemplateEngine.class),
    STR_SUBSTITUTOR(StrSubstitutorTemplateEngine.class);

    @Getter
    private final Class<? extends TemplateEngine> clazz;

    private TemplateEngineType(final Class<? extends TemplateEngine> clazz) {
        this.clazz = clazz;
    }

}
