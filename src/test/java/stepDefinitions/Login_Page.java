package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.LoginPageObject;

public class Login_Page extends BasePage {
    private final WebDriver driver = getDriver();

    public LoginPageObject loginPageObject;// Injecting Page Object With PicoContainer

    public Login_Page(LoginPageObject lpo) {
        this.loginPageObject = lpo;
    }

    // Validate Successful Login ---------------------------------------------------------------------------------------
    @Given("User is on webdriver university login page")
    public void user_is_on_webdriver_university_login_page() {
        switchToNewTab();
        loginPageObject.gotoWebDriverUniversityLoginPage();
    }

    @When("User enter valid username {word}")
    public void user_enter_valid_username(String username) {
        loginPageObject.clickAndSendUserName(username);
    }

    @When("User enter valid password {word}")
    public void user_enter_valid_password(String password) {
        loginPageObject.clickAndSendPassword(password);
    }

    @When("User click login button")
    public void user_click_login_button() {
        By loginBtnElement = By.xpath("//*[@id=\"login-button\"]");
        findAndClick(loginBtnElement);
    }

    @Then("User will be represented with successful login message")
    public void user_will_be_represented_with_successful_login_message() {
        loginPageObject.verifyAlertMessage("validation succeeded");
    }

    // Validate Unsuccessful Login - Invalid Username ------------------------------------------------------------------
    @When("User enter invalid username {word}")
    public void user_enter_invalid_username(String username) {
        loginPageObject.clickAndSendUserName(username);
    }

    @Then("User will be represented with unsuccessful login username")
    public void user_will_be_represented_with_unsuccessful_login_username() {
        loginPageObject.verifyAlertMessage("validation failed");
    }

    // Validate Unsuccessful Login - Invalid Password ------------------------------------------------------------------
    @When("User enter invalid password {word}")
    public void user_enter_invalid_password(String password) {
        loginPageObject.clickAndSendPassword(password);
    }

    @Then("User will be represented with unsuccessful login username password")
    public void user_will_be_represented_with_unsuccessful_login_password() {
        loginPageObject.verifyAlertMessage("validation failed");
    }

    // Validate Successful/Unsuccessful Login --------------------------------------------------------------------------
    @When("User enter username {word}")
    public void user_enter_username(String username) {
        loginPageObject.clickAndSendUserName(username);
    }

    @When("User enter password {word}")
    public void user_enter_password(String password) {
        loginPageObject.clickAndSendPassword(password);
    }

    @Then("User will be represented with {}")
    public void user_will_be_represented_with_validation(String message) {
        loginPageObject.verifyAlertMessage(message);
    }
}
