# ToDoRESTAPITest

Pre-requisites
-JDK 8
-Maven 3.5.x
-Eclipse/IntelliJ IDE


#Instructions to run tests:
- Download/clone the source of the example from GitHub.
- Compile it with Maven: mvn clean install.
- To run tests use command : mvn clean test -DtagName=@TodosRESTAPITest

# Framework
Cucumber- supports Behavior Driven Development (BDD). It offers a way to write tests that anybody can understand, regardless of their technical knowledge

Junit : Junit is an open source unit testing framework for the Java programming language.

REST Assured
- REST Assured is a Java library for validation of REST web services.
- It supports for BDD (Behavior-Driven Development) by using test notation, Given, When and Then.
- Since REST Assured is a Java library, integrating it into a continuous integration / continuous delivery setup is an easy when combined with a testing framework such as JUnit or TestNG.
 
 
 Files:
 
 - Feature file : Refer \src\test\java\todo\api\test\featureFiles\ToDoRestAPITest.feature
 - Step Defination:Refer src\test\java\todo\api\test\stepdefinations\TodoAPIStepDef.java
 - Properties (for endpoint) : Refer src\test\resources\properties\ToDo-REST-API.properties
 - TestRunner class: Refer src\test\java\todo\api\test\TestRunner.java
 - Functions/Actions: Refer \src\test\java\todo\api\test\actions\ToDoActions.java 
                    & \src\test\java\todo\api\test\actions\VerifyAPIData.java
              
 Report:
 
- Surefire report : 
    -- generated in target\surefire-reports\todo.api.test.TestRunner.txt
    -- Gives status details like: Tests run: 6, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 5.73 sec along with failures
 - Cucumber report :
    -- generated in \target\cucumber-report -- cucumber.json, cucumber-preety & cucumber-reports 
    -- this can be used to get cucumber html report
  
 - It is possible to add allure/ extent reports with above information.
  
# Flow of execution
	- Tests in the feature file using Gherkins syntax. 
	- Step definition file created as per gherkins syntax. 
	- the JUnit testrunner class to run the series of test cases.
	- Once we run the JUnit runner class. 
    - It will parse the Gherkin feature file.
    - It will execute the functions written in the step definition file according to feature file statements. 
    - JUnit combines the test case result.
    - It builds the test report in the specified format (which can be html/JSON).


# Note: 
This is a fake API designed for testing purposes and returns fake responses. 




