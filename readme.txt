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
  java -jar target/Atomic-1.0-SNAPSHOT.war


From STS IDE,

Run as a Spring Boot App, Right Click the project folder Choose , Run As... Spring Boot App...

Spring Boot will automatically start a embedded tomcat server to run the app.


To Access the app, use any REST Client .

The application would be dynamically registered with Service Registry at Startup.

More than one instance of the application can be started and each instance would register with Service Registry.


Dependencies
============

The details of Eureka Service Registry are in below path,
		 src/main/resources/application.properties

The port details of the service can be obtained using the EurekaServer console apps page URL,
		http://localhost:8761/eureka/apps


Eureka Server should be up and running for a service to be successfully registered in it.