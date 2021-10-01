# Selenium Automation Test Framework using (Java,Cucumber,JUnit,POM)
Basic automation test framework following action and page object models, using Selenium to interact with the web browser, Cucumber to frame the tests, and JUnit to provide a standard report on the tests.

# Framework Architecture

*	src/test/resources/features - all the cucumber features files (files .feature ext) goes here.
* src/test/java/userStepDefinition - you can define step defintion under this package for the feature steps.
* src/test/java/testrunners - test runner is defined here
* src/test/resources/config - browser configuration
* src/test/java/com.pages - All locators & thier actions goes here
* src/test output/PdfReport - Extent PDF report 
* src/test output/SparkReport - Spark Report 


# Supporting Browsers

  Chrome, Firefox,Safari
  
# Writing a test
The cucumber features goes in the features library and should have the ".feature" extension.

You can start out by looking at **features/TestScript.feature**.   
# Running the tests

JUnit - used as the main entry point for running the Cucumber tests and its assertion test methods.
Simply execute the test as Junit test.


# Reports Used 

Extent Report

Spark Report

Cucumber Report

