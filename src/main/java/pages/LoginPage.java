package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class LoginPage {

    private WebDriver driver;
    private WaitUtils wait;

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    private By errorMessage =
            By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void enterUsername(String username) {

        wait.waitForVisibility(usernameField)
                .sendKeys(username);
    }

    public void enterPassword(String password) {

        wait.waitForVisibility(passwordField)
                .sendKeys(password);
    }

    public void clickLogin() {

        wait.waitForClickable(loginButton)
                .click();
    }

    public void login(String username, String password) {

        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public String getErrorMessage() {

        return wait
                .waitForVisibility(errorMessage)
                .getText();
    }
}