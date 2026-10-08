package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class ProductsPage {

    private WebDriver driver;
    private WaitUtils wait;

    private By productsTitle =
            By.className("title");

    private By backpack =
            By.id("add-to-cart-sauce-labs-backpack");

    private By bikeLight =
            By.id("add-to-cart-sauce-labs-bike-light");

    private By cartIcon =
            By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public boolean isProductsPageDisplayed() {

        return wait
                .waitForVisibility(productsTitle)
                .isDisplayed();
    }

    public String getPageTitle() {

        return wait
                .waitForVisibility(productsTitle)
                .getText();
    }

    public void addBackpackToCart() {

        wait.waitForClickable(backpack).click();
    }

    public void addBikeLightToCart() {

        wait.waitForClickable(bikeLight).click();
    }

    public void clickCart() {

        wait.waitForClickable(cartIcon).click();
    }
}