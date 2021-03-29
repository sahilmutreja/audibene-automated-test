# Full Stack Test Automation With Docker

This project is a sample application that encompasses automation test
for API and Web combined.  
It leverages the latest technologies of containerization to optimize
parallelism of test execution.  
Total execution time for all the tests combined is around **~01:08
min**

## Documentation

* Web Automation Test 
  * There are total 6 test cases as follows - 
    * Test login success and login error
    * Test logout scenario
    * Test if Exit Intent is present
    * Test data table can be sorted
    * Test if new window/tab is opened
    * Test dynamic controls
  * All the test cases are executed on both browsers chrome as well as firefox.
  * There are 2 separate test suite files for chrome and firefox executions as follows - 
    * [chrome-web-test.xml](https://github.com/sahilmutreja/audibene-automated-test/blob/master/src/test/resources/chrome-web-test.xml)
    * [firefox-web-test.xml](https://github.com/sahilmutreja/audibene-automated-test/blob/master/src/test/resources/firefox-web-test.xml)

* API Automation Test
  * There are total 2 test cases as follows - 
    * Test to get all the categories
    * Test to search a specific category
  * Both of the test cases are configured to execute in following test suite file
    * [api-test.xml](https://github.com/sahilmutreja/audibene-automated-test/blob/master/src/test/resources/api-test.xml)

* Steps to execute tests on docker 
  1. Execute following command from project root directory to spin up docker containers: <br/>
      `docker-compose -f src/main/resources/docker-compose.yml up -d`
  2. Above command will spin 3 docker containers namely - 
      * selenium/hub
      * selenium/node-chrome-debug
      * selenium/node-firefox-debug
  3. Check the status of grid if it is ready by navigating to [Grid Link](http://localhost:4444/status)     
      ![image](https://user-images.githubusercontent.com/10580286/112861784-68671b00-90b5-11eb-9827-4130be39f3b0.png)
  4. Execute maven command from project root directory to execute all the test cases - <br/>
     `mvn clean test` </br>
      This will execute the [parent test suite file](https://github.com/sahilmutreja/audibene-automated-test/blob/master/src/test/resources/audibene-test.xml) containing all 3 test suites which is configured in [POM.xml](https://github.com/sahilmutreja/audibene-automated-test/blob/master/pom.xml#L35)
  5. Check test execution HTML report in the target directory which is created in the project root directory after the test execution if finished. <br/>
     `target/surefire-reports/index.html`
      ![image](https://user-images.githubusercontent.com/10580286/112863798-846bbc00-90b7-11eb-9691-e3a7ed33f5ec.png)
  7. Stop and remove all the containers after the test execution with following command - <br/>
    `docker-compose -f src/main/resources/docker-compose.yml down`


* Additional Feature 😊
  * You can toggle the environement to execute test on local. 
  * Execute following maven command from project root directory with local profile <br/>
   `mvn clean test -Plocal`
  * This way the test will execute on local and you can access the TestNG report similarly as mentioned earlier.
