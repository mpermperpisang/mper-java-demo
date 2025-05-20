package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PropertyLoader;

import java.util.Properties;

public class LoginPage {
    private WebDriver driver;
    private Properties locators;

    private By usernameField;
    private By passwordField;
    private By loginButton;
    private By errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

        // Dynamically load properties file e.g. "Login.properties"
        String propertiesFileName = this.getClass().getSimpleName().replace("Page", "") + ".properties";
        locators = PropertyLoader.loadProperties(propertiesFileName);

        // Initialize locators from properties file
        usernameField = By.cssSelector(locators.getProperty("USERNAME_FIELD"));
        passwordField = By.cssSelector(locators.getProperty("PASSWORD_FIELD"));
        loginButton = By.cssSelector(locators.getProperty("LOGIN_BUTTON"));
        errorMessage = By.cssSelector(locators.getProperty("ERROR_MESSAGE"));
    }

    public void enterUsername(String username) {
        WebElement element = driver.findElement(usernameField);
        element.clear();
        element.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement element = driver.findElement(passwordField);
        element.clear();
        element.sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
