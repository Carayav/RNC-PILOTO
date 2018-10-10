#!/bin/bash
if [ "$1" == local ]
then
  cp pom-local.xml pom.xml
  mvn clean install -Dmaven.test.skip=true -U
  java -jar target/*.war
elif [ "$1" == websphere ]
  cp pom-websphere.xml pom.xml
then
  mvn clean install -Dmaven.test.skip=true -U
fi

