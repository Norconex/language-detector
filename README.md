Norconex Language Detector
==========================

Detects languages out of any text (50+ languages supported).

Mainly a wrapper around the great "language-detection" library from Nakatani Shuyo, with some additions:

* It allows concurrent detectors with different language profiles initializations on the same JVM.  
* It offers different ways to initialize the language profiles (as input streams, from classpath, etc).

Original Shuyo language-detection project is hosted at: https://code.google.com/p/language-detection. 
You can find a fork of that project on github at: https://github.com/Norconex/language-detection
