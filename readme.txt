Setup the app in IDE
====================

Import the project into IDE (STS or eclipse).



Build the Application
=====================

To build the application use mvn clean package. A jar file would be created in target folder.

To execute the jar we can use STS and run as Spring Boot Application.

Once build, we can also run from command line mode as below.

Command line Execution
=======================
Navigate to project folder.

From command line type , 
  java -jar target/atomic-1.0-snapshot.war


From STS IDE,

Run as a Spring Boot App, Right Click the project folder Choose , Run As... Spring Boot App...

Spring Boot will automatically start a embedded tomcat server to run the app.


To Access the app, use any REST Client .
