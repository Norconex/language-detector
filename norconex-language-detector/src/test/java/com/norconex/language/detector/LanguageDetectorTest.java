/* Copyright 2014 Norconex Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.norconex.language.detector;

import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.norconex.language.detector.DetectedLanguages;
import com.norconex.language.detector.LanguageDetector;
import com.norconex.language.detector.LanguageDetectorException;

/**
 * @author Pascal Essiembre
 *
 */
public class LanguageDetectorTest {

    private static String[] testedLanguages;
    private static LanguageDetector shortDetector;
    private static LanguageDetector longDetector;

    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Logger logger = Logger.getRootLogger();
        logger.setLevel(Level.DEBUG);
        logger.setAdditivity(false);
        logger.addAppender(new ConsoleAppender(
                new PatternLayout("%-5p [%C{1}] %m%n"), 
                ConsoleAppender.SYSTEM_OUT));
        testedLanguages = new String[] {"en", "fr", "it", "es"};
        shortDetector = new LanguageDetector(true);
        longDetector = new LanguageDetector(false);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        shortDetector = null;
        longDetector = null;
        testedLanguages = null;
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testDetectLongText() 
            throws LanguageDetectorException, IOException {
        doTestDetect(false);
    }
    
    @Test
    public void testDetectShortText() 
            throws LanguageDetectorException, IOException {
        doTestDetect(true);
    }

    public void doTestDetect(boolean shortText) 
            throws LanguageDetectorException, IOException {
        LanguageDetector detector = longDetector;
        String prefix = "/long-";
        if (shortText) {
            detector = shortDetector;
            prefix = "/short-";
        }
        for (String lang : testedLanguages) {
            String testFile = prefix + lang + ".txt";
            InputStreamReader reader = new InputStreamReader(
                    getClass().getResourceAsStream(testFile));
            DetectedLanguages detectedLangs;
            try {
                detectedLangs = detector.detect(reader);
            } finally {
                reader.close();
            }
            Assert.assertEquals(
                    lang, detectedLangs.getBestLanguage().getTag());
        }
    }
}
