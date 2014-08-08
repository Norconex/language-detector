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

import com.cybozu.labs.langdetect.Language;

/**
 * @author Pascal Essiembre
 *
 */
public class DetectedLanguage {

    private final Language language;
    
    /**
     * Constructor.
     */
    public DetectedLanguage(Language language) {
        this.language = language;
    }

    /**
     * @return the language
     */
    public String getTag() {
        return language.lang;
    }
    public double getProbability() {
        return language.prob;
    }

    @Override
    public String toString() {
        return language.toString();
    }
}
