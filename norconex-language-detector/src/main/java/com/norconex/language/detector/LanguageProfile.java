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

import com.cybozu.labs.langdetect.util.LangProfile;

/**
 * @author Pascal Essiembre
 *
 */
public class LanguageProfile {

    private final String language;
    private final LangProfile shuyoLangProfile;

    /*default*/ LanguageProfile(LangProfile shuyoLangProfile) {
        super();
        this.language = shuyoLangProfile.name;
        this.shuyoLangProfile = shuyoLangProfile;
    }

    public String getLanguage() {
        return language;
    }

    /*default*/ LangProfile getShuyoLangProfile() {
        return shuyoLangProfile;
    }
}
