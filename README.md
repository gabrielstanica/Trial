# Page Object model Test automation framework using Selenium with Java, TestNG and Maven

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

### Improvements
* Improve and create a single html file for all reports in ExtentReport and perform changes on view side
* Add fluent wait instead of using Thread.sleep
* Update selectors/xpath to relative insted of absolute
* Create core jar for common methods to search/isEnabled/isDisplayed elements
* Catch exceptions on possible driver quite and include in reporting

### TestReport example

<img width="1792" alt="image" src="https://user-images.githubusercontent.com/5984880/200077382-75e49ec9-f3cd-424c-8c2f-6ae9ac2c50d3.png">

### DEMO E2E

https://user-images.githubusercontent.com/5984880/199847224-0e619983-2627-4a15-abe0-ceab76a506dc.mp4

### DEMO IDE



https://user-images.githubusercontent.com/5984880/199847724-24382341-859f-4722-a4a4-68ff12f60e9e.mp4



