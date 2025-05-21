package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.LocatorReader;

public class LoginPage {
    private WebDriver driver;
    private LocatorReader locatorReader;

    private By usernameInput;
    private By passwordInput;
    private By loginButton;
    private By errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        // Pass this class to LocatorReader to load 'elements/login.properties'
        locatorReader = new LocatorReader(this.getClass());

        usernameInput = locatorReader.getLocator("USERNAME_INPUT");
        passwordInput = locatorReader.getLocator("PASSWORD_INPUT");
        loginButton = locatorReader.getLocator("LOGIN_BUTTON");
        errorMessage = locatorReader.getLocator("ERROR_MESSAGE");
    }

    public void open() {
        driver.get("https://www.saucedemo.com/v1/");
    }

    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
