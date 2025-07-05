package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static driver.DriverFactory.getDriver;

public class Login_Page {
    private final WebDriver driver = getDriver();

    // Validate Successful Login ---------------------------------------------------------------------------------------
    @Given("User is on webdriver university login page")
    public void user_is_on_webdriver_university_login_page() {
        driver.get("https://webdriveruniversity.com/Login-Portal/index.html");
    }

    @When("User enter valid username {word}")
    public void user_enter_valid_username(String username) {
        WebElement usernameElement = driver.findElement(By.xpath("//input[@id=\"text\"]"));
        usernameElement.click();
        usernameElement.sendKeys(username);
    }

    @When("User enter valid password {word}")
    public void user_enter_valid_password(String password) {
        WebElement passwordElement = driver.findElement(By.xpath("//input[@id=\"password\"]"));
        passwordElement.click();
        passwordElement.sendKeys(password);
    }

    @When("User click login button")
    public void user_click_login_button() {
        WebElement loginBtnElement = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        loginBtnElement.click();
    }

    @Then("User will be represented with successful login message")
    public void user_will_be_represented_with_successful_login_message() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(alertText, "validation succeeded");
        alert.accept();
    }

    // Validate Unsuccessful Login - Invalid Username ------------------------------------------------------------------
    @When("User enter invalid username {word}")
    public void user_enter_invalid_username(String username) {
        WebElement usernameElement = driver.findElement(By.xpath("//input[@id=\"text\"]"));
        usernameElement.click();
        usernameElement.sendKeys(username);
    }

    @Then("User will be represented with unsuccessful login username")
    public void user_will_be_represented_with_unsuccessful_login_username() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(alertText, "validation failed");
        alert.accept();
    }

    // Validate Unsuccessful Login - Invalid Password ------------------------------------------------------------------
    @When("User enter invalid password {word}")
    public void user_enter_invalid_password(String password) {
        WebElement passwordElement = driver.findElement(By.xpath("//input[@id=\"password\"]"));
        passwordElement.click();
        passwordElement.sendKeys(password);
    }

    @Then("User will be represented with unsuccessful login username password")
    public void user_will_be_represented_with_unsuccessful_login_password() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(alertText, "validation failed");
        alert.accept();
    }

    // Validate Successful/Unsuccessful Login --------------------------------------------------------------------------
    @When("User enter username {word}")
    public void user_enter_username(String username) {
        WebElement usernameElement = driver.findElement(By.xpath("//input[@id=\"text\"]"));
        usernameElement.click();
        usernameElement.sendKeys(username);
    }

    @When("User enter password {word}")
    public void user_enter_password(String password) {
        WebElement passwordElement = driver.findElement(By.xpath("//input[@id=\"password\"]"));
        passwordElement.click();
        passwordElement.sendKeys(password);
    }

    @Then("User will be represented with {}")
    public void user_will_be_represented_with_validation(String message) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText();
            Assert.assertEquals(alertText, message);
            alert.accept();
        } catch (Exception e) {
            System.err.println("Alert not found or driver issue: " + e.getMessage());
        }
    }
}
