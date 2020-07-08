# Alpine because it's lighter
FROM openjdk:8-jdk-alpine
MAINTAINER Rodrigo Pires <digaomilleniun@gmail.com>

# Set ENV variables
ENV PORT=9091
ENV CONFIGSERVER_URL="http://configserver:8888"

# Add JAR file and run it as entrypoint
ADD target/lojas-pires-eureka-server-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

# Expose the port
EXPOSE 9091