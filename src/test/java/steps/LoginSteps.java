package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {
    private WebDriver driver = TestHooks.driver;
    private LoginPage loginPage;

    @Given("I am on the SauceDemo login page")
    public void i_am_on_login_page() {
        loginPage = new LoginPage(driver);
        loginPage.open();
    }

    @When("I login with username {string} and password {string}")
    public void i_login_with_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("I should see the inventory page")
    public void i_should_see_inventory_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }

    @Then("I should see an error message")
    public void i_should_see_error_message() {
        String errorText = loginPage.getErrorMessage();
        Assert.assertTrue(errorText.contains("Epic sadface"));
    }
}
