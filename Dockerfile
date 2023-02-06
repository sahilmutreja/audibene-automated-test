FROM openjdk:8u212-jre-alpine3.9

# Add utilities to the container which will be used in the healthcheck shell script
RUN apk add curl jq

# Set the Working Directory
WORKDIR /usr/share/audibene-test

# COPY JAR Files & Dependencies in /libs folder to the container
ADD target/audibene-test-1.0.jar audibene-test-1.0.jar
ADD target/audibene-test-1.0-tests.jar audibene-test-1.0-tests.jar

# COPY Dependencies to the container including any other resouce file like .csv .json or .xls
ADD target/libs libs

# Copy test suite files to the container
ADD src/test/resources/audibene-test.xml audibene-test.xml
ADD src/test/resources/api-test.xml api-test.xml
ADD src/test/resources/chrome-web-test.xml chrome-web-test.xml
ADD src/test/resources/firefox-web-test.xml firefox-web-test.xml

# Add the healthcheck to wait the test from starting before the nodes have registered with the hub
ADD healthcheck.sh healthcheck.sh

ENTRYPOINT sh healthcheck.sh