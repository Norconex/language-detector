/* Copyright 2014 Norconex Inc.
 * 
 * This file is part of Norconex Language Detector.
 * 
 * Norconex Language Detector is free software: you can redistribute it and/or 
 * modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Norconex Language Detector is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Norconex Language Detector. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package com.norconex.language.detector;

/**
 * @author Pascal Essiembre
 *
 */
public class LanguageDetectorException extends RuntimeException {

    private static final long serialVersionUID = -8753683145084939801L;

    /**
     * Constructor.
     */
    public LanguageDetectorException() {
        super();
    }

    /**
     * Constructor.
     * @param message
     */
    public LanguageDetectorException(String message) {
        super(message);
    }

    /**
     * Constructor.
     * @param cause
     */
    public LanguageDetectorException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor.
     * @param message
     * @param cause
     */
    public LanguageDetectorException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor.
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public LanguageDetectorException(
            String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
