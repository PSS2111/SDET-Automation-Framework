package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class CartPage {

    private WebDriver driver;
    private WaitUtils wait;

    private By backpack =
            By.id("item_4_title_link");

    private By bikeLight =
            By.id("item_0_title_link");

    private By checkoutButton =
            By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public boolean isBackpackDisplayed() {

        return wait
                .waitForVisibility(backpack)
                .isDisplayed();
    }

    public boolean isBikeLightDisplayed() {

        return wait
                .waitForVisibility(bikeLight)
                .isDisplayed();
    }

    public void clickCheckout() {

        wait.waitForClickable(checkoutButton).click();
    }
}