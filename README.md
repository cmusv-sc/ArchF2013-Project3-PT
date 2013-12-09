======================
SenWeb
======================

Introduction
======================
The SenWeb application is designed to provide an intuitive, easy to use interface for managing the 
Sensor Service Platform. It provides data from the devices that the Sensor Service Platform supports 
as well as providing a way for users to manage those devices. Additionally, it makes use of the 
Sensor Service Platform API, a REST API for interacting with the platform.

Pre-Requisites
======================
- Java 1.6+ (http://www.oracle.com/technetwork/java/javase/downloads)
- Play 2.2.x (http://www.playframework.com/download)
- Any text editor / IDE (e.g. IntelliJ, Eclipse)

Building the code
=====================
- Install Play Framework. Instruction can be found at http://www.playframework.com/documentation/2.2.x/Installing
- Downlaod the source code from https://github.com/robwblack/mercury
- From the parent folder, run the command: 'play run'
- App will available at localhost:9000

Project Layout
=====================
SenWeb is written using the Play Framework, so in order to compile and run, the project follows Play Framework conventions. Also, for deployment to Heroku to work correctly, the project needs to be in the root of the repo.
So, to follow Play conventions, instead of having a “src” directory we have an “app” directory with “models”, “controllers”, and “views” subdirectories. All source code required to run the project resides in these directories.
The “conf” directory contains the configuration options for the Play Framework.
The “documents” directory contains project documentation.
The “project” directory contains Play build definitions.
The “public” directory contains assets to be used for rendering web pages.
The “test” directory contains the JUnit tests for the project.

For more information, see http://www.playframework.com/documentation/2.0/Anatomy
