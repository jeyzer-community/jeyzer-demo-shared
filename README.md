# jeyzer-demo-shared

Content
------------------

Goal of this library is to demonstrate the automatic loading of the shared profiles.
The demo-shared is loaded by the demo features and demo labors applications.
The demo-shared library Manifest file contains the Jeyzer-Repository="demo" attribute.

The demo-shared project includes a Jeyzer shared profile with patterns, rules and stickers, 
deployed (at installation time for convenience) within a Jeyzer external repository called demo. 
The path to the Jeyzer external repository is set through the JEYZER_EXTERNAL_REPOSITORY_SETUP_DIRECTORY environment variable.

At Jeyzer recording time, the Jeyzer-Repository attribute (of the shared-demo library) is stored within the JZR recording.

At Jeyzer analysis time, the demo-shared profile is loaded based on the Jeyzer-Repository attribute.
Related patterns, stickers and rules are therefore applied automatically.


Build instructions
------------------

Jeyzer shared demo project can be built with Maven.

Under the current directory, execute :

> mvn clean package


     
License
-------

Copyright 2020 Jeyzer.

Licensed under the [Mozilla Public License, Version 2.0](https://www.mozilla.org/media/MPL/2.0/index.815ca599c9df.txt)

