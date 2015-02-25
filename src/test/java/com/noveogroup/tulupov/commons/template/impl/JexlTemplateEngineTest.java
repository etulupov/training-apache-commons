package com.noveogroup.tulupov.commons.template.impl;

/**
 * Jexl template engine test.
 */
public class JexlTemplateEngineTest extends AbstractTemplateEngineTest {
    public JexlTemplateEngineTest() {
        super(JexlTemplateEngine.class, "/result/jexl.txt");
    }
}
