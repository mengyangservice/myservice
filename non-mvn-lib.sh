#!/bin/bash
mvn install:install-file -Dfile=lib/aclibico-2.1.jar -DgroupId=com.ctreber -DartifactId=aclib -Dversion=2.1 -Dpackaging=jar
mvn install:install-file -Dfile=lib/json-lib-2.1-jdk15.jar -DgroupId=net.sf.json-lib -DartifactId=json-lib -Dversion=2.1 -Dpackaging=jar
