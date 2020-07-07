#!/bin/bash

echo ConfigServer Service: BUILDING
cd configserver-local
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