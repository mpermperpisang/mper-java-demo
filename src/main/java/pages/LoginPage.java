package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import utils.PropertyLoader;

import java.util.Properties;

public class LoginPage {
    private WebDriver driver;
    private Properties locators;

    private By usernameField;
    private By passwordField;
    private By loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

        // Dynamically determine properties filename: "Login.properties"
        String propertiesFileName = this.getClass().getSimpleName().replace("Page", "") + ".properties";

        // Load properties file (e.g. Login.properties)
        locators = PropertyLoader.loadProperties(propertiesFileName);

        // Initialize locators from properties
        usernameField = By.cssSelector(locators.getProperty("USERNAME_FIELD"));
        passwordField = By.cssSelector(locators.getProperty("PASSWORD_FIELD"));
        loginButton = By.cssSelector(locators.getProperty("LOGIN_BUTTON"));
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}
