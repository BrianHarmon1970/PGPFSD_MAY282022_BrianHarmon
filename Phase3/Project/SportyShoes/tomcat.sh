#! /bin/sh
# tomcat.sh -- setup for SportyShoes Dockerfile tomcat dependencies
# - assumes: apache tomcat 9.0.70 tar gzip file in /tmp,
# - unpacks to /opt/tomcat and sets $CATALINA_HOME variable

echo ============================================================
echo Tomcat 9.0.70
echo ============================================================
 cd /opt
 mkdir tomcat
 cd tomcat
 tar -xf /tmp/apache-tomcat-9.0.70.tar.gz
 tar -xf /tmp/apahce-tomcat-8.5.9.tar.gz
 set CATALINA_HOME="/opt/tomcat/apache-tomcat-8.5.9" ; export CATALINA_HOME
 cd /
