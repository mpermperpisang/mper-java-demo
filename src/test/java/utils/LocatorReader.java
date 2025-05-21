package utils;

import org.openqa.selenium.By;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LocatorReader {
    private Properties properties;

    /**
     * Dynamically loads a properties file based on the calling Page Object class name.
     * Expects properties file in "elements/" folder and named lowercase, e.g. "login.properties".
     */
    public LocatorReader(Class<?> pageClass) {
        String className = pageClass.getSimpleName(); // e.g. LoginPage
        String fileName = "elements/" + className.replace("Page", "").toLowerCase() + ".properties";

        properties = new Properties();

        try (InputStream input = getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                throw new RuntimeException("Unable to find properties file: " + fileName);
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file: " + fileName, e);
        }
    }

    /**
     * Get locator as By.cssSelector from the properties file by key.
     */
    public By getLocator(String key) {
        String selector = properties.getProperty(key);
        if (selector == null) {
            throw new RuntimeException("Locator not found in properties file: " + key);
        }
        return By.cssSelector(selector.trim());
    }
}
