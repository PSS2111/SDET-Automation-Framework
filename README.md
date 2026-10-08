# SDET Automation Framework

A Java-based automation testing framework built using Selenium WebDriver,
TestNG, and Rest Assured. The framework supports both UI and API automation
and is integrated with GitHub Actions for CI execution.

## Tech Stack

- Java 25
- Selenium WebDriver
- TestNG
- Rest Assured
- Maven
- Git & GitHub
- GitHub Actions
- Page Object Model (POM)

## Framework Features

- UI automation using Selenium WebDriver
- API automation using Rest Assured
- Page Object Model
- TestNG test execution
- Smoke and Regression test groups
- Configurable browser and base URL
- Explicit waits
- Screenshot capture on test failure
- API request and response specifications
- POJO serialization/deserialization
- JSONPath validation
- GitHub Actions CI pipeline
- Headless Chrome execution in CI

## Project Structure

```text
SDET-Automation-Framework/
│
├── .github/
│   └── workflows/
│       └── tests.yml
│
├── src/
│   ├── main/java/
│   │   ├── api/
│   │   │   ├── ApiBase.java
│   │   │   └── models/
│   │   │       └── User.java
│   │   │
│   │   ├── base/
│   │   │   ├── BaseTest.java
│   │   │   └── DriverFactory.java
│   │   │
│   │   ├── config/
│   │   │   └── ConfigReader.java
│   │   │
│   │   ├── pages/
│   │   │   ├── LoginPage.java
│   │   │   ├── ProductsPage.java
│   │   │   ├── CartPage.java
│   │   │   └── CheckoutPage.java
│   │   │
│   │   └── utils/
│   │       ├── WaitUtils.java
│   │       └── ScreenshotUtils.java
│   │
│   └── test/java/
│       ├── api/
│       │   └── UserApiTest.java
│       │
│       ├── listeners/
│       │   └── TestListener.java
│       │
│       └── ui/
│           ├── LoginTest.java
│           ├── CartTest.java
│           ├── CheckoutTest.java
│           └── TestDataProvider.java
│
├── pom.xml
├── testng.xml
├── .gitignore
└── README.md