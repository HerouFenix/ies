# IES Lab02 

## Setup
1) Install Apache Tomcat - https://tecadmin.net/install-tomcat-9-on-ubuntu/ 
- Notes: 
- - Remember to run the server with **sudo**! 
- - Careful, one of the steps in the tutorial changes the JAVA_HOME environment path. Make sure you change it to your java's directory! Also remember to run ~/.bashrc 

## Exercises
### 2.1
#### a)
See Setup
#### b)
Following these instructions we'll end up on a page that contains a simple ___First Name___/___Last Name___ form. We can input some text and the page will display the parameters we included in the request. Woo!
#### c)
Just create a new Maven Project  using IntelliJ (#notsponsored), taking into account that you have to create a new Archetype!
#### d)
Yup, it's there :) However, due to a malformed POM (in the vain of the exercise), instead of a **.war**, $mvn install was generating a **.jar**. After changing the POM around a bit we fixed that.
#### e)
