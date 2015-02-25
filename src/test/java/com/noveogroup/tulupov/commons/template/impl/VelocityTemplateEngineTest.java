package com.noveogroup.tulupov.commons.template.impl;

/**
 * Velocity template engine test.
 */
public class VelocityTemplateEngineTest extends AbstractTemplateEngineTest {
    public VelocityTemplateEngineTest() {
        super(VelocityTemplateEngine.class, "/result/velocity.html");
    }
}
