Spring Challenge
====================

Alejandro Cuesta
July 17, 2011

Overview
--------

Spring programming challenge for  Daily Mail Online.

Requisites
----------

* ant
* ivy
* tomcat (it should run on Jetty as well)
* h2 database


Usage
-----

Database
* Start h2 from command line first using: $H2_HOME/bin/h2.sh
* Enter the following URL as database:  jdbc:h2:tcp://localhost/tmp/pc

Tomcat
* Set Tomcat Home in paths.xml
* Start/Stop Tomcat using: ant tomcat-start / ant tomcat-stop
* Deploy/Undeploy app using: ant deploy / ant undeploy
* Run tests using: ant test



