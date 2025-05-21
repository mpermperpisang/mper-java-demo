
# SauceDemo Automation Testing

This project automates login scenarios on [SauceDemo](https://www.saucedemo.com/v1/) using:

- Java
- Cucumber (BDD)
- Selenium WebDriver with ChromeDriver
- Page Object Model (POM)
- Gradle build system
- Allure for test reporting

---

## Prerequisites

- Java 11 or higher installed
- Chrome browser installed
- ChromeDriver executable downloaded and available locally

---

## Running Tests

- To run **all** tests:

  ```bash
  ./gradlew test
  ```

- To run tests filtered by tag, e.g. `@positive` or `@negative`:

  ```bash
  ./gradlew test -Dcucumber.filter.tags="@positive or @negative"
  ```

---

## Test Reports with Allure

1. After running tests, generate and open the report with:

   ```bash
   allure serve build/allure-results
   ```

2. If you don’t have Allure installed, follow the instructions at [Allure docs](https://docs.qameta.io/allure/).

---

## Locator Management

- Element locators are stored in `.properties` files under `src/test/resources/elements/`.
- Each Page Object class loads its corresponding `.properties` file dynamically by name.
- Example locator keys:

  ```
  USERNAME_INPUT = #user-name
  PASSWORD_INPUT = #password
  LOGIN_BUTTON = #login-button
  ERROR_MESSAGE = h3[data-test='error']
  ```

---

## Notes

- Old Allure results are deleted automatically before each test run for clean reporting.
- Dynamic tags allow flexible test execution without modifying code.
- Uses Page Object Model for better maintainability.

---

Happy testing! 🚀
