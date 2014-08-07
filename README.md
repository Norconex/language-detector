Norconex Language Detector
==========================

Detects languages out of any text (50+ languages supported).

Mainly a wrapper around the great "language-detection" library from Nakatani Shuyo, with some additions.  For instance:

* It allows concurrent detectors with different language profiles initializations on the same JVM.  
* It also offers different ways to initialize the language profiles (as input streams, from classpath, etc).

