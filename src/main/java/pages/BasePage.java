package pages;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }

    protected WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    protected void navigateToURL(String url) {
        getDriver().get(url);
    }

    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    protected void switchToNewTab() {
        ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        if (tabs.size() > 1) {
            for (int i = 0; i < tabs.size(); i++) {
                getDriver().switchTo().window(tabs.get(i));
                getDriver().close();
            }
            getDriver().switchTo().window(tabs.get(0));
        }
    }

    protected void findAndClick(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    protected void findAndClick(WebElement by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    protected void findAndSendText(By by, String textToSend) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToSend);
    }

    protected void findAndSendText(WebElement by, String textToSend) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToSend);
    }

    protected void verifyAlertMessage(String message) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = getDriver().switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(alertText, message);
        alert.accept();
    }
}
