package com.noveogroup.tulupov.commons.manager.impl.util;

import org.apache.commons.io.FilenameUtils;

import java.io.File;

/**
 * File utils.
 */
public final class FileUtils {
    private static final String DOT = ".";
    private static final String HTML_EXTENSION = "html";

    private FileUtils() {
        throw new UnsupportedOperationException();
    }

    public static File getOutputFile(final String path) {
        if (!FilenameUtils.isExtension(path, HTML_EXTENSION)) {
            return new File(FilenameUtils.normalize(FilenameUtils.removeExtension(path)
                    + FilenameUtils.EXTENSION_SEPARATOR_STR + HTML_EXTENSION));
        }

        return new File(FilenameUtils.normalize(path));
    }
}
