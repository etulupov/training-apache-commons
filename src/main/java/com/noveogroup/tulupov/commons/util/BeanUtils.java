package com.noveogroup.tulupov.commons.util;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.validator.GenericValidator;

import java.beans.PropertyDescriptor;
import java.util.List;

/**
 * BeanUtils class.
 */
@SuppressWarnings("unchecked")
public final class BeanUtils {
    private BeanUtils() {
        throw new UnsupportedOperationException();
    }

    public static <T> T escapeStringProperties(final T object) throws Exception {
        return (T) process(object);
    }

    private static Object process(final Object object) throws Exception {
        if (object instanceof String) {
            final String string = object.toString();

            return GenericValidator.isUrl(string) ? string : StringEscapeUtils.escapeHtml(object.toString());
        }

        if (object instanceof List) {
            final List list = (List) object;

            for (int i = 0; i < list.size(); i++) {
                list.set(i, process(list.get(i)));
            }

            return object;
        }

        final PropertyDescriptor[] descriptors = PropertyUtils.getPropertyDescriptors(object);

        for (final PropertyDescriptor descriptor : descriptors) {
            if (descriptor.getPropertyType() != Class.class) {
                PropertyUtils.setProperty(object,
                        descriptor.getName(),
                        process(PropertyUtils.getProperty(object, descriptor.getName())));
            }
        }

        return object;
    }
}
