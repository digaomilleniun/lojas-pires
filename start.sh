#!/bin/bash

echo Installing openjdk-8 and Maven
apt-get update
apt-get install openjdk-8-jdk
apt-get install maven

echo ConfigServer Service: BUILDING
cd configserverlocal
mvn clean install -U
cd ..
clear

echo ConfigServer Service: BUILD DONE
echo Discovery Service: BUILDING
cd lojas-pires-eureka-server
mvn clean install -U
cd ..
clear

echo ConfigServer Service: BUILD DONE
echo Discovery Service: BUILD DONE
echo API Gateway: BUILDING
cd lojas-pires-zull
mvn clean install -U
cd ..
clear

echo ---
echo Starting Application...
docker-compose up --build