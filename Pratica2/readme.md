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

#### h)
Follow this tutorial https://medium.com/@backslash112/create-maven-project-with-servlet-in-intellij-idea-2018-be0d673bd9af to know how to setup the Servlet!
And this one https://www.ntu.edu.sg/home/ehchua/programming/java/JavaServlets.html to know how to access the request

A classe Servlet ficou assim:
```
package com.CustomMsg;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import java.io.IOException;  
import java.io.PrintWriter;  
  
@WebServlet(name="CustomMsg", urlPatterns = {"/custom"})  
public class Servlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
  
    }  
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        response.setContentType("text/html");  
  PrintWriter out = response.getWriter();  
  out.println("<h3>Hello World!</h3>");  
  
 if (request.getParameter("username") != null) {  
            out.println("<p>Boas meu puto " + request.getParameter("username") + "!</p>");  
  }else {  
            out.println("<p>Por favor especifica o teu nome no url, para que te possa cumprimentar ;)</p>");  
  out.println("<p> URL: http://localhost:8080/custom?username=<NOME> </p>");  
  }  
  
    }  
}
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
