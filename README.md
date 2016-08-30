Norconex Language Detector
==========================

> This project is no longer maintained. 
> ---------------------
> __This project was created to provide language-detection features to the [Norconex Importer](https://www.norconex.com/collectors/importer/) project.  The Importer project now uses Apache Tika built-in language-detection capabilities instead.__

Detects languages out of any text (50+ languages supported).

At the moment, it is mainly a wrapper around the great "language-detection" library from Nakatani Shuyo, with some additions:

* It allows concurrent detectors with different language profiles initializations on the same JVM.  
* It offers different ways to initialize the language profiles (as input streams, from classpath, etc).

Original Shuyo language-detection project is hosted at: https://code.google.com/p/language-detection. 
You can find a fork of that project on github at: https://github.com/Norconex/language-detection
