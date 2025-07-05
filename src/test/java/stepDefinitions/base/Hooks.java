package stepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import static driver.DriverFactory.cleanUpDriver;
import static driver.DriverFactory.getDriver;

public class Hooks {
    public WebDriver driver;

    @Before
    public void setup() {
        getDriver();
    }

    @After
    public void tearDown() {
        cleanUpDriver();
    }
}
