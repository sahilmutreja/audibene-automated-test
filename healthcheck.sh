#!/usr/bin/env bash
# Environment Variables
# HUB_HOST
# TEST_SUITE_FILE

echo "Checking if hub is ready - $HUB_HOST"

while [ "$(curl -s http://$HUB_HOST:4444/wd/hub/status | jq -r .value.ready)" != "true" ]; do
  sleep 1
done

# start the java command
java -cp audibene-test-1.0.jar:audibene-test-1.0-tests.jar:libs/* \
  -DHUB_HOST=$HUB_HOST \
  org.testng.TestNG $TEST_SUITE_FILE
