package hooks;

import io.cucumber.java.BeforeAll;

public class TestSetup {

    @BeforeAll
    public static void globalSetup() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    }

}
