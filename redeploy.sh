#!/bin/bash

echo "Step 1. Start pulling source code changes from www.github.com"

git pull

echo "Step 2. Using Maven to clean old artifacts"

mvn clean

echo "Step 3. Using Maven to package WAR"

mvn package

echo "Step 4. Using Maven to redeploy application on Tomcat 7"

mvn tomcat7:redeploy

echo "Step 5. Patching uncompiled classes"

. patch.sh



