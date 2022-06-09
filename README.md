Prereq
======

1. Maven 3.9.0
2. Java
3. git


Steps To Build and Execute
=========

1. add mvn to class path
   1. `export PATH=$PATH:<path to mvn>`
2. set JAVA_HOME
   1. `export JAVA_HOME=<path to JDK>`

3. `git clone https://github.com/hemshankar/cronExpression.git` 
4. `cd cronExpression/`
5. `mvn clean install`
6. `java -jar target/Deliveroo-1.0-SNAPSHOT.jar "*/15 0 1,15 * 1-5 /usr/bin/find"`