package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import utils.WebDriverManager;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        driver = WebDriverManager.getDriver();
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown() {
        WebDriverManager.quitDriver();
    }

    @Given("I am on the Sauce Demo login page")
    public void i_am_on_the_sauce_demo_login_page() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");
        loginPage = new LoginPage(driver);
    }

    @When("I login with username {string} and password {string}")
    public void i_login_with_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("I should see the products page")
    public void i_should_see_the_products_page() {
        if (!driver.getCurrentUrl().contains("inventory.html")) {
            throw new AssertionError("Login failed or products page not reached.");
        }

        driver.quit();
    }
}
