# Test Case

## UI TESTS:
Characteristic tests for https://the-internet.herokuapp.com/ 

Create Testcases for the following pages
1. https://the-internet.herokuapp.com/login - Create testcase for a login success and login error
2. https://the-internet.herokuapp.com/exit_intent - Test if exit intent is shown
3. https://the-internet.herokuapp.com/tables  
    * Example table 1: Test sorting of last names by alphabetic order (A..Z, Z..A)    
    * Example table 2: Test sorting of first names by alphabetic order (A..Z, Z..A)
4. https://the-internet.herokuapp.com/windows - Test that the click opens a new browser-tab or new window
5. https://the-internet.herokuapp.com/dynamic_controls - Test dynamic controls
    * Test should show that input field is enabled after async process is finished when Enable button was clicked.
    * After the input field is enabled, submit a string of your choice and click on disable button, wait for async process. 
    * Check that the field is disabled again but still contains the string of your choice from the step before.

## API TESTS:
RestAPI tests for https://api.chucknorris.io 

Create testcases for:
1. https://api.chucknorris.io/jokes/categories - Show that the successful request returns a list of fixed categories containing n-amount of items
2. https://api.chucknorris.io/jokes/search?query={} - Pick one of the categories from the step before und use it in the freetext search request and make sure that each of the returned items contains the query string in the returned JSON.
