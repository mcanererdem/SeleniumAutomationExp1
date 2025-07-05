package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:features"},
        glue = {"stepDefinitions"},
        tags = "@regression",// @contact-us, @login, @regression
        monochrome = true, // Format logs to more readable
        dryRun = false, // True => Will not execute mapped step but will execute only unmapped steps
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"})
public class MainRunner extends AbstractTestNGCucumberTests {
}