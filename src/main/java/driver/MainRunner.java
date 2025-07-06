package driver;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"classpath:features"},
        glue = {"stepDefinitions"},
        tags = "@login",// @contact-us, @login, @regression
        monochrome = true, // Format logs to more readable
        dryRun = false, // True => Will not execute mapped step but will execute only unmapped steps
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"})
public class MainRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}