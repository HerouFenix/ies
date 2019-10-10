# IES Lab02 

## Setup
1) Install Apache Tomcat - https://tecadmin.net/install-tomcat-9-on-ubuntu/ 
- Notes: 
- - Remember to run the server with **sudo**! 
- - Careful, one of the steps in the tutorial changes the JAVA_HOME environment path. Make sure you change it to your java's directory! Also remember to run ~/.bashrc 

## Exercises
## 2.1
#### a)
See Setup
#### b)
Following these instructions we'll end up on a page that contains a simple ___First Name___/___Last Name___ form. We can input some text and the page will display the parameters we included in the request. Woo!
#### c)
Just create a new Maven Project  using IntelliJ (#notsponsored), taking into account that you have to create a new Archetype!
#### d)
Yup, it's there :) However, due to a malformed POM (in the vain of the exercise), instead of a **.war**, $mvn install was generating a **.jar**. After changing the POM around a bit we fixed that.
#### e)
Over at http://localhost:8080/manager/ navigate down 'till you see **WAR file to deploy**. Then just import the .war file you've just created and bish bash bosh, its been deployed

#### f)
Using IntelliJ:
- https://www.youtube.com/watch?v=4Zp5suN1b1E
- In case you get an error (I got a Permission Denied on run), check this out https://stackoverflow.com/questions/3092049/intellij-says-cannot-run-program-path-to-tomcat-bin-catalina-sh-error-13-per


#### g)
(I think this is it, but I'm not sure?)
```
/usr/local/apache-tomcat9/bin/catalina.sh run
[2019-10-08 03:23:15,755] Artifact HelloWorld2.1:war: Waiting for server connection to start artifact deployment...
08-Oct-2019 15:23:16.281 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Server version name:   Apache Tomcat/9.0.26
08-Oct-2019 15:23:16.283 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Server built:          Sep 16 2019 15:51:39 UTC
08-Oct-2019 15:23:16.283 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Server version number: 9.0.26.0
08-Oct-2019 15:23:16.283 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log OS Name:               Linux
08-Oct-2019 15:23:16.283 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log OS Version:            5.0.0-23-generic
08-Oct-2019 15:23:16.283 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Architecture:          amd64
08-Oct-2019 15:23:16.283 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Java Home:             /usr/lib/jvm/java-8-openjdk-amd64/jre
08-Oct-2019 15:23:16.283 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log JVM Version:           1.8.0_222-8u222-b10-1ubuntu1~18.04.1-b10
08-Oct-2019 15:23:16.283 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log JVM Vendor:            Private Build
08-Oct-2019 15:23:16.284 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log CATALINA_BASE:         /home/ds/.IntelliJIdea2019.2/system/tomcat/Tomcat_9_0_26_HelloWorld2_1
08-Oct-2019 15:23:16.284 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log CATALINA_HOME:         /usr/local/apache-tomcat9
08-Oct-2019 15:23:16.284 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Djava.util.logging.config.file=/home/ds/.IntelliJIdea2019.2/system/tomcat/Tomcat_9_0_26_HelloWorld2_1/conf/logging.properties
08-Oct-2019 15:23:16.284 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager
08-Oct-2019 15:23:16.284 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Dcom.sun.management.jmxremote=
08-Oct-2019 15:23:16.284 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Dcom.sun.management.jmxremote.port=1099
08-Oct-2019 15:23:16.284 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Dcom.sun.management.jmxremote.ssl=false
08-Oct-2019 15:23:16.284 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Dcom.sun.management.jmxremote.password.file=/home/ds/.IntelliJIdea2019.2/system/tomcat/Tomcat_9_0_26_HelloWorld2_1/jmxremote.password
08-Oct-2019 15:23:16.284 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Dcom.sun.management.jmxremote.access.file=/home/ds/.IntelliJIdea2019.2/system/tomcat/Tomcat_9_0_26_HelloWorld2_1/jmxremote.access
08-Oct-2019 15:23:16.284 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Djava.rmi.server.hostname=127.0.0.1
08-Oct-2019 15:23:16.285 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Djdk.tls.ephemeralDHKeySize=2048
08-Oct-2019 15:23:16.285 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Djava.protocol.handler.pkgs=org.apache.catalina.webresources
08-Oct-2019 15:23:16.285 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Dorg.apache.catalina.security.SecurityListener.UMASK=0027
08-Oct-2019 15:23:16.285 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Dignore.endorsed.dirs=
08-Oct-2019 15:23:16.285 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Dcatalina.base=/home/ds/.IntelliJIdea2019.2/system/tomcat/Tomcat_9_0_26_HelloWorld2_1
08-Oct-2019 15:23:16.285 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Dcatalina.home=/usr/local/apache-tomcat9
08-Oct-2019 15:23:16.285 INFO [main] org.apache.catalina.startup.VersionLoggerListener.log Command line argument: -Djava.io.tmpdir=/usr/local/apache-tomcat9/temp
08-Oct-2019 15:23:16.285 INFO [main] org.apache.catalina.core.AprLifecycleListener.lifecycleEvent The APR based Apache Tomcat Native library which allows optimal performance in production environments was not found on the java.library.path: [/usr/java/packages/lib/amd64:/usr/lib/x86_64-linux-gnu/jni:/lib/x86_64-linux-gnu:/usr/lib/x86_64-linux-gnu:/usr/lib/jni:/lib:/usr/lib]
08-Oct-2019 15:23:16.471 INFO [main] org.apache.coyote.AbstractProtocol.init Initializing ProtocolHandler ["http-nio-8080"]
08-Oct-2019 15:23:16.490 INFO [main] org.apache.coyote.AbstractProtocol.init Initializing ProtocolHandler ["ajp-nio-8009"]
08-Oct-2019 15:23:16.494 INFO [main] org.apache.catalina.startup.Catalina.load Server initialization in [367] milliseconds
08-Oct-2019 15:23:16.526 INFO [main] org.apache.catalina.core.StandardService.startInternal Starting service [Catalina]
08-Oct-2019 15:23:16.526 INFO [main] org.apache.catalina.core.StandardEngine.startInternal Starting Servlet engine: [Apache Tomcat/9.0.26]
08-Oct-2019 15:23:16.535 INFO [main] org.apache.coyote.AbstractProtocol.start Starting ProtocolHandler ["http-nio-8080"]
08-Oct-2019 15:23:16.574 INFO [main] org.apache.coyote.AbstractProtocol.start Starting ProtocolHandler ["ajp-nio-8009"]
08-Oct-2019 15:23:16.587 INFO [main] org.apache.catalina.startup.Catalina.start Server startup in [93] milliseconds
Connected to server
[2019-10-08 03:23:16,932] Artifact HelloWorld2.1:war: Artifact is being deployed, please wait...
[2019-10-08 03:23:17,161] Artifact HelloWorld2.1:war: Artifact is deployed successfully
[2019-10-08 03:23:17,162] Artifact HelloWorld2.1:war: Deploy took 230 milliseconds
08-Oct-2019 15:23:26.540 INFO [Catalina-utility-2] org.apache.catalina.startup.HostConfig.deployDirectory Deploying web application directory [/usr/local/apache-tomcat9/webapps/manager]
08-Oct-2019 15:23:26.589 INFO [Catalina-utility-2] org.apache.catalina.startup.HostConfig.deployDirectory Deployment of web application directory [/usr/local/apache-tomcat9/webapps/manager] has finished in [48] ms
```


#### i)
I believe the error to which this exercise is refering to is the one that would happen if I didn't input in the url the tag username=(...) . However, I already dealt with this exception in the previous exercise (see the else)

#### What are the responsibilities/services of a “servlet container”?
So firstly we should answer the question, what is a Java Servlet? _The basic idea of Servlet container is using Java to dynamically generate the web page on the server side. So servlet container is essentially a part of a web server that interacts with the servlets._ - From https://dzone.com/articles/what-servlet-container

The Servlet Container's functions can be divided into 6 simple goals:
-   Web server receives HTTP request
-   Web server forwards the request to servlet container
-   The servlet is dynamically retrieved and loaded into the address space of the container, if it is not in the container.
-   The container invokes the init() method of the servlet for initialization(invoked once when the servlet is loaded first time)
-   The container invokes the service() method of the servlet to process the HTTP request, i.e., read data in the request and formulate a response. The servlet remains in the container’s address space and can process other HTTP requests.
-   Web server return the dynamically generated results to the correct location


## 2.2
Following the tutorial over at https://examples.javacodegeeks.com/enterprise-java/jetty/embedded-jetty-server-example/
Just follow the tutorial, it's pretty simple.. Idk what else to say my dude xD
I used port 8690 instead of the one specified in the tutorial btw! Also if you're using IntelliJ don't use the package com.(...) line at the beginning of the embedded server class!

## 2.3
#### m)
Go to https://start.spring.io/
Admire how beautiful and crisp that UI is
Add the Spring Web dependency down over at the dependencies tab

Following the instructions in the guide, this is the page that gets produced:
```
# Whitelabel Error Page

This application has no explicit mapping for /error, so you are seeing this as a fallback.

Tue Oct 08 17:30:39 WEST 2019

There was an unexpected error (type=Not Found, status=404).

No message available
```

#### n)
Follow the tutorial over at https://spring.io/guides/gs/serving-web-content/

Some notes:
- _The [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/maven-plugin) provides many convenient features:_

	-   It collects all the jars on the classpath and builds a single, runnable "über-jar", which makes it more convenient to execute and transport your service.
    
	-   It searches for the `public static void main()` method to flag as a runnable class.
    
	-   It provides a built-in dependency resolver that sets the version number to match [Spring Boot dependencies](https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot-dependencies/pom.xml). You can override any version you wish, but it will default to Boot’s chosen set of versions.

- _In Spring’s approach to building web sites, HTTP requests are handled by a controller. You can easily identify these requests by the [`@Controller`](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/stereotype/Controller.html) annotation._

-	_The `@GetMapping` annotation ensures that HTTP GET requests to `/greeting` are mapped to the `greeting()` method._
-	_[`@RequestParam`](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestParam.html) binds the value of the query String parameter `name` into the `name` parameter of the `greeting()` method. This query String parameter is not `required`; if it is absent in the request, the `defaultValue` of "World" is used. The value of the `name` parameter is added to a [`Model`](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/ui/Model.html) object, ultimately making it accessible to the view template._
-	_A common feature of developing web apps is coding a change, restarting your app, and refreshing the browser to view the change. This entire process can eat up a lot of time. To speed up the cycle of things, Spring Boot comes with a handy module known as [spring-boot-devtools](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-devtools)._

	-   Enable [hot swapping](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-hotswapping)
    
	-   Switches template engines to disable caching
    
	-   Enables LiveReload to refresh browser automatically
    
	-   Other reasonable defaults based on development instead of production

- _`@SpringBootApplication` is a convenience annotation that adds all of the following:_

	-   `@Configuration`: Tags the class as a source of bean definitions for the application context.
    
	-   `@EnableAutoConfiguration`: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. For example, if `spring-webmvc` is on the classpath, this annotation flags the application as a web application and activates key behaviors, such as setting up a `DispatcherServlet`.
    
	-   `@ComponentScan`: Tells Spring to look for other components, configurations, and services in the `hello` package, letting it find the controllers.

-	_If you use Maven, you can run the application by using `$mvn spring-boot:run`. Alternatively, you can build the JAR file with `$mvn clean package` and then run the JAR file, as follows:_
	
	-	```java -jar target/gs-serving-web-content-0.1.0.jar```

**Nota:** The way we built the web app using SpringBoot reminded me a lot of **Django**, both in the project's final structure, and the Model-View-Controller (MVC) architecture (i.e, html templates, and a java class that loads specific content into them)

**Changing the default port:** To do this, simply create an **applications.properties** file in the src>main>resources directory. Then add the line `server.port=8090` (or whatever other port you wish to change to)
More information at https://www.tutorialspoint.com/spring_boot/spring_boot_application_properties.htm

## Questions:
### Web applications in Java can be deployed to stand-alone applications servers or embedded servers. Elaborate on when to choose one over the other.
Info for this question was retrieved from https://stackoverflow.com/questions/20736356/embedded-vs-stand-alone-tomcat-http-server (info directly coppied will be in italic)

So firstly we should distinguish Standalone from Embedded servers

**Embedded application servers** prevent us from having to create some upfront setupp with a given app server. These sort of apps have the benefit of being able to be run by the end users without needing any extra installations or configurations of an app server. However

_Applications like Jenkins for example hugely benefit from such packaging. Another scenario is when deploying on cloud services like Heroku. You wrapping the app server within your jar eliminates the need to get the server installed on such cloud boxes._

_Here essentially a single web app runs on a given embedded server. However if you wish to install two web apps on lets say two contexts `${root}/app1` `${root}/app2` then embedded app server is not a good option for you._

In contrast, a **Standalone application server** is a server that runs alone and is not a part of a group.

**DISCLAIMER**: I COULDN'T FIND MUCH INFO TO ANSWER THIS QUESTION WITH ON THE WEB, SO IT'S BEEN LEFT VERY INCOMPLETE. FUTURE-SELF: REMEMBER TO ASK THE TEACHER ABOUT THIS

### Give specific examples of annotations in Spring Boot that implement the principle of convention-over-configuration.

As is said on the official Spring-Boot documentation page (https://docs.spring.io/spring/docs/3.0.0.M3/spring-framework-reference/html/ch16s10.html):

_For a lot of projects, **sticking to established conventions and having reasonable defaults is just what they (the projects) need**... this theme of convention-over-configuration now has explicit support in Spring Web MVC. What this means is that **if you establish a set of naming conventions and suchlike, you can _substantially_ cut down on the amount of configuration that is required to set up handler mappings, view resolvers, `ModelAndView` instances, etc.** This is a great boon with regards to rapid prototyping, and can also lend a degree of (always good-to-have) consistency across a codebase should you choose to move forward with it into production._
_This convention over configuration support address the three core areas of MVC - namely, the models, views, and controllers._

Knowing this, some Spring Boot annotations that implement this principle include, but are not limited to:
-   @Configuration - indicates that a class is a configuration class that may contain bean definitions.
-   @Controller - marks the class as web controller, capable of handling the requests.
-   @Autowired - marks a constructor, field, or setter method to be autowired by Spring dependency injection.
-   @SpringBootApplication - enables Spring Boot autoconfiguration and component scanning.

More info on annotations and project structure can be found here: http://zetcode.com/springboot/annotations/
