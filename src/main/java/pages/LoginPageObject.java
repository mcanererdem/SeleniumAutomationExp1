package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPageObject extends BasePage {
    private @FindBy(id = "text") WebElement usernameElement;
    private @FindBy(id = "password") WebElement passwordElement;
    private @FindBy(id = "login-button") WebElement loginBtn;



    public LoginPageObject() {
        super();
    }

    public void gotoWebDriverUniversityLoginPage() {
        getDriver().get("https://webdriveruniversity.com/Login-Portal/index.html");
    }

    public void sendUserName(String username) {
        findAndSendText(usernameElement, username);
    }

    public void clickAndSendUserName(String username) {
        findAndClick(usernameElement);
        findAndSendText(usernameElement, username);
    }

    public void clickAndSendPassword(String password) {
        findAndClick(passwordElement);
        findAndSendText(passwordElement, password);
    }

    public void clickLoginBtn() {
        findAndClick(loginBtn);
    }

    public void verifyAlertMessage(String message) {
        verifyAlertMessage(message);
    }
}
