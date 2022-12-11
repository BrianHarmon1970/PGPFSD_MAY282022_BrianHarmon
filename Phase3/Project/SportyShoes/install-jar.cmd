#set sourceDir=./src/lib/apache-tomcat-9.0.70/lib
set sourceDir=./

set groupId=com.harmonengineering.apache.tomcat
set version=9.0.70
set packaging=jar

        mvn install:install-file ^
            -Dfile=%sourceDir%/%1.jar ^
            -DgroupId=%groupId% ^
            -DartifactId=%1 ^
            -Dversion=%version% ^
            -Dpackaging=%packaging% ^
