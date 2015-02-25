package com.noveogroup.tulupov.commons.template;

import com.noveogroup.tulupov.commons.template.impl.FreeMakerTemplateEngine;
import com.noveogroup.tulupov.commons.template.impl.JellyTemplateEngine;
import com.noveogroup.tulupov.commons.template.impl.JexlTemplateEngine;
import com.noveogroup.tulupov.commons.template.impl.VelocityTemplateEngine;
import lombok.Getter;

/**
 * Template engine type.
 */
@SuppressWarnings("UnusedDeclaration")
public enum TemplateEngineType {
    JEXL(JexlTemplateEngine.class),
    FREE_MARKER(FreeMakerTemplateEngine.class),
    VELOCITY(VelocityTemplateEngine.class),
    JELLY(JellyTemplateEngine.class);

    @Getter
    private final Class<? extends TemplateEngine> clazz;

    private TemplateEngineType(final Class<? extends TemplateEngine> clazz) {
        this.clazz = clazz;
    }

}
