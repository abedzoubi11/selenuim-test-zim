selenium-testng-framework
---

---
A sample framework based on Page Object Model, Selenium, TestNG using Java.

This framework is based in **Page Object Model (POM).**

The framework uses:

1. Java
2. Selenium
3. TestNG
4. Allure report



Reproting
---
The framework uses Allure report framework

To get reports you need to install the Allure report and run the following commands:
The Allure report saves the results in the following directory:
"/allure-results"
`allure serve /allure-results`


---

Key Points:
---

1. The class `WebDriverContext` is responsible for maintaining the same WebDriver instance throughout the test. So whenever you require a webdriver instance which has been using for current test (In current thread) always call `WebDriverContext.getDriver()`.

---

