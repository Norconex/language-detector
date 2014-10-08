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

import java.util.ArrayList;
import java.util.List;

import com.cybozu.labs.langdetect.Language;

/**
 * @author Pascal Essiembre
 *
 */
public class DetectedLanguages extends ArrayList<DetectedLanguage> {

    private static final long serialVersionUID = 2506831927979398855L;
    
    /**
     * Constructor.
     */
    /*default*/ DetectedLanguages(ArrayList<Language> shuyoLanguages) {
        super(toDetectedLanguageList(shuyoLanguages));
    }

    private static List<DetectedLanguage> toDetectedLanguageList(
            ArrayList<Language> shuyoLanguages) {
        List<DetectedLanguage> languages = new ArrayList<>();
        for (Language language : shuyoLanguages) {
            languages.add(new DetectedLanguage(language));
        }
        return languages;
    }

    public DetectedLanguage getBestLanguage() {
        if (!isEmpty()) {
            return get(0);
        }
        return null;
    }

    public DetectedLanguage getLanguage(String language) {
        for (DetectedLanguage lang : this) {
            if (lang.getTag().equals(language)) {
                return lang;
            }
        }
        return null;
    }
    
    public boolean containsLanguage(String language) {
        return getLanguage(language) != null;
    }
}
