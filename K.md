# Page Object model Test automation framework using Selenium with Java, TestNG and Maven-
This is a DEMO project to demonstrate what is page object model framework and how it can used in selenium to automate any application.
TestNG is used as test framework.

Dependency
Java
Maven

###libraries used
Selenium
TestNG
log4j
Extent Reports

### Improvements
* Improve and create a single html file for all reports in ExtentReport and perform changes on view side
* Add fluent wait instead of using Thread.sleep
* Update selectors/xpath to relative insted of absolute
* Create core jar for common methods to search/isEnabled/isDisplayed elements
* Catch exceptions on possible driver quite and include in reporting
* 


### Steps to clone execute the tests
```
git clone https://github.com/gabrielstanica/Trial.git
cd KatalonDEMO
mvn clean test
```
OR
```
git clone https://github.com/gabrielstanica/Trial.git
mvn test -Dtestset=testng.xm
```