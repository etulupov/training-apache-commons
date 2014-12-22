package com.noveogroup.tulupov.commons.template.impl;

import com.noveogroup.tulupov.commons.template.TemplateEngine;
import com.noveogroup.tulupov.commons.template.exception.TemplateEngineException;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;
import org.apache.commons.jexl2.Script;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Jexl template engine.
 */
public class JexlTemplateEngine implements TemplateEngine {
    private static final String TEMPLATE = "template/rss.jexl";

    public JexlTemplateEngine() {

    }

    @Override
    public void generate(final Map<String, Object> context, final Writer writer) throws TemplateEngineException {
        final PrintWriter printWriter = new PrintWriter(writer);
        final JexlEngine jexl = new JexlEngine();
        final Map<String, Object> functions = new HashMap<String, Object>();
        final JexlContext jexlContext = new MapContext(context);

        functions.put("writer", printWriter);
        jexl.setFunctions(functions);

        try {
            final Script script = jexl.createScript(getClass().getClassLoader().getResource(TEMPLATE));
            script.execute(jexlContext);
        } catch (Exception e) {
            throw new TemplateEngineException("Cannot generate page with Jexl", e);
        }
    }
}
