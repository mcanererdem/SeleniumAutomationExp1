package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.ArrayList;

import static driver.DriverFactory.getDriver;

public class Contact_Us_Page {
    private final WebDriver driver = getDriver();

    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    @Given("User is on webdriver university contact us page")
    public void userIsOnWebdriverUniversityContactUsPage() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1) {
            for (int i = 0; i < tabs.size(); i++) {
                driver.switchTo().window(tabs.get(i));
                driver.close();
            }
            driver.switchTo().window(tabs.get(0));
        }
        driver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @When("User enter firstname")
    public void userEnterFirstname() {
        WebElement firstname = driver.findElement(By.xpath("//input[@name='first_name']"));
        firstname.sendKeys("Dummy Name" + generateRandomString(3));
    }

    @And("User enter lastname")
    public void userEnterLastname() {
        WebElement lastname = driver.findElement(By.xpath("//input[@name='last_name']"));
        lastname.sendKeys("Dummy Last Name" + generateRandomString(5));
    }

    @And("User enter email address")
    public void userEnterEmailAddress() {
        WebElement email = driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[3]"));
        email.sendKeys("mail" + generateRandomString(5) + "@mail.com");

    }

    @And("User enter comment")
    public void userEnterComment() {
        WebElement comment = driver.findElement(By.xpath("//*[@id=\"contact_form\"]/textarea"));
        comment.sendKeys("Greatest Comment | " + generateRandomString(20));
    }

    // Validate Successful Contact Us - Specific Data------------------------------------------------------------------

    @When("User enter a specific firstname as {word}")
    public void user_enter_a_specific_firstname_as(String firstname) {
        WebElement firstnameElement = driver.findElement(By.xpath("//input[@name='first_name']"));
        firstnameElement.sendKeys(firstname);
    }

    @When("User enter a specific lastname as {word}")
    public void user_enter_a_specific_lastname_as(String lastname) {
        WebElement lastnameElement = driver.findElement(By.xpath("//input[@name='last_name']"));
        lastnameElement.sendKeys(lastname);
    }

    @When("User enter a specific email address as {word}")
    public void user_enter_a_specific_email_address_as(String email) {
        WebElement emailElement = driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[3]"));
        emailElement.sendKeys(email);
    }

    @When("User enter a specific comment as {string}")
    public void user_enter_a_specific_comment_as(String comment) {
        WebElement commentElement = driver.findElement(By.xpath("//*[@id=\"contact_form\"]/textarea"));
        commentElement.sendKeys(comment);
    }

    //------------------------------------------------------------------------------------------------------------------
    @And("User click submit button")
    public void userClickSubmitButton() {
        WebElement submitBtn = driver.findElement(By.xpath("//*[@id=\"form_buttons\"]/input[@type='submit']"));
        submitBtn.click();
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
