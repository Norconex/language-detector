/**
 * 
 */
package com.norconex.language.detector;

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
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import net.arnx.jsonic.JSON;
import net.arnx.jsonic.JSONException;

import com.cybozu.labs.langdetect.ErrorCode;
import com.cybozu.labs.langdetect.LangDetectException;
import com.cybozu.labs.langdetect.util.LangProfile;


/**
 * @author Pascal Essiembre
 *
 */
public class LanguageProfileLoader {

    
    /**
     * @param file file containing language profile.
     */
    public static LanguageProfile loadFromFile(File file)
            throws LanguageDetectorException {
        
        if (!file.isFile()) {
            throw new LanguageDetectorException(
                    "Profile file does not exist: " + file);
        }
        try (InputStream is = new BufferedInputStream(
                new FileInputStream(file))) {
            return loadFromStream(is);
        } catch (IOException e) {
            throw new LanguageDetectorException(
                    "Cannot load language from file: " + file, e);
        }
    }    

    
    /**
     * @param clazz Class from which to obtain the {@link ClassLoader}.
     * @param qualifiedFileName classpath location of profile file, using the 
     *             {@link ClassLoader} from the given class.
     */
    public static LanguageProfile loadFromClasspath(
            Class<?> clazz, String qualifiedFileName)
            throws LanguageDetectorException {
        
        InputStream input = clazz.getResourceAsStream(qualifiedFileName);
        if (input == null) {
            throw new LanguageDetectorException(
                    "Unsupported language candidate ("
                  + "qualifiedName=" + qualifiedFileName + "; classloaderOf="
                  + clazz.getName() + ").");
        }
        try (InputStream is = new BufferedInputStream(input)) {
            return loadFromStream(is);
        } catch (IOException e) {
            throw new LanguageDetectorException(
                    "Cannot load language from classpath ("
                  + "qualifiedName=" + qualifiedFileName + "; classloaderOf="
                  + clazz.getName() + ").", e);
        }
    }    
    
    /**
     * @param is profile input stream
     */
    public static LanguageProfile loadFromStream(InputStream is)
            throws LanguageDetectorException {
        try {
            LangProfile shuyoLangProfile = JSON.decode(is, LangProfile.class);
            return new LanguageProfile(shuyoLangProfile);
        } catch (JSONException e) {
            throw new LanguageDetectorException("Cannot load language profile.",
                    new LangDetectException(
                            ErrorCode.FormatError, "profile format error."));
        } catch (IOException e) {
            throw new LanguageDetectorException("Cannot load language profile.",
                    new LangDetectException(
                            ErrorCode.FileLoadError, "can't read profile."));
        }
    }

}
