package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.BasePage;

public class Contact_Us_Page extends BasePage {
    private final WebDriver driver = getDriver();

    @Given("User is on webdriver university contact us page")
    public void userIsOnWebdriverUniversityContactUsPage() {
        switchToNewTab();
        navigateToURL("https://webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @When("User enter firstname")
    public void userEnterFirstname() {
        By firstname = By.xpath("//input[@name='first_name']");
        String textToSend = "Dummy Name" + generateRandomString(3);
        findAndSendText(firstname, textToSend);
    }

    @And("User enter lastname")
    public void userEnterLastname() {
        By lastname = By.xpath("//input[@name='last_name']");
        String textToSend = "Dummy Last Name" + generateRandomString(5);
        findAndSendText(lastname, textToSend);
    }

    @And("User enter email address")
    public void userEnterEmailAddress() {
        By email = By.xpath("//*[@id=\"contact_form\"]/input[3]");
        String textToSend = "mail" + generateRandomString(5) + "@mail.com";
        findAndSendText(email, textToSend);

    }

    @And("User enter comment")
    public void userEnterComment() {
        By comment = By.xpath("//*[@id=\"contact_form\"]/textarea");
        String textToSend = "Greatest Comment | " + generateRandomString(20);
        findAndSendText(comment, textToSend);
    }

    // Validate Successful Contact Us - Specific Data------------------------------------------------------------------
    @When("User enter a specific firstname as {word}")
    public void user_enter_a_specific_firstname_as(String firstname) {
        By firstnameElement = By.xpath("//input[@name='first_name']");
        findAndSendText(firstnameElement, firstname);
    }

    @When("User enter a specific lastname as {word}")
    public void user_enter_a_specific_lastname_as(String lastname) {
        By lastnameElement = By.xpath("//input[@name='last_name']");
        findAndSendText(lastnameElement, lastname);
    }

    @When("User enter a specific email address as {word}")
    public void user_enter_a_specific_email_address_as(String email) {
        By emailElement = By.xpath("//*[@id=\"contact_form\"]/input[3]");
        findAndSendText(emailElement, email);
    }

    @When("User enter a specific comment as {string}")
    public void user_enter_a_specific_comment_as(String comment) {
        By commentElement = By.xpath("//*[@id=\"contact_form\"]/textarea");
        findAndSendText(commentElement, comment);
    }

    //------------------------------------------------------------------------------------------------------------------
    @And("User click submit button")
    public void userClickSubmitButton() {
        By submitBtn = By.xpath("//*[@id=\"form_buttons\"]/input[@type='submit']");
        findAndClick(submitBtn);
    }

    @Then("User will be navigated and represented with successful submission message")
    public void userWillBeRepresentedWithSuccessfulSubmissionMessage() {
        try {
            WebElement messageElement = driver.findElement(By.xpath("//*[@id=\"contact_reply\"]/h1"));
            String message = messageElement.getText();
            assert message.equals("Thank You for your Message!");
            Assert.assertEquals(message, "Thank You for your Message!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
