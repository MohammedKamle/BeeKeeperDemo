# BeeKeeperDemo
This repository demonstrate how we can integrate both iOS and android test with the same script using PageFactory on BrowserStack. 
## System Requirements
```
Windows or Mac
Java JDK 1.8+
```
## Libraries used
```
Appium
JUnit 4
Cucumber-JUnit
jackson-databind
json-simple
```
## Build Management Tool
Gradle


## How to run the test ?
  - Clone the project 
  - Build the project using:
```
gradle build
```
  - Give your BrowserStack specific username name and access key in [`config.yml`](https://github.com/MohammedKamle/BeeKeeperDemo/blob/master/src/test/resources/config.yml) 
  - Run the cucumber test runner class [DemoTest1](https://github.com/MohammedKamle/BeeKeeperDemo/blob/master/src/test/java/com/browserstack/tests/DemoTest1.java)
  - You can also run the test using the gradle task as shown below:
```
gradle demo
```
### Tes Results 
You can view the executed tests on your [`app-automate`](https://app-automate.browserstack.com/dashboard) dashboard on BrowserStack 
