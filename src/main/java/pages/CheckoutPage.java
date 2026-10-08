package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class CheckoutPage {

    private WebDriver driver;
    private WaitUtils wait;

    private By firstName =
            By.id("first-name");

    private By lastName =
            By.id("last-name");

    private By postalCode =
            By.id("postal-code");

    private By continueButton =
            By.id("continue");

    private By finishButton =
            By.id("finish");

    private By confirmationMessage =
            By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void enterFirstName(String value) {

        wait.waitForVisibility(firstName)
                .sendKeys(value);
    }

    public void enterLastName(String value) {

        wait.waitForVisibility(lastName)
                .sendKeys(value);
    }

    public void enterPostalCode(String value) {

        wait.waitForVisibility(postalCode)
                .sendKeys(value);
    }

    public void clickContinue() {

        wait.waitForClickable(continueButton)
                .click();
    }

    public void clickFinish() {

        wait.waitForClickable(finishButton)
                .click();
    }

    public void enterCustomerDetails(
            String firstNameValue,
            String lastNameValue,
            String postalCodeValue) {

        enterFirstName(firstNameValue);
        enterLastName(lastNameValue);
        enterPostalCode(postalCodeValue);
    }

    public String getConfirmationMessage() {

        return wait
                .waitForVisibility(confirmationMessage)
                .getText();
    }
}