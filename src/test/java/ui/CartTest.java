package ui;

import base.BaseTest;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

@Listeners(TestListener.class)
public class CartTest extends BaseTest {

    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;

    @BeforeMethod(alwaysRun = true)
    public void start() {

        setup();

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);

        loginPage.login("standard_user", "secret_sauce");
    }

    @AfterMethod(alwaysRun = true)
    public void stop() {
        tearDown();
    }

    @Test(groups = "smoke")
    public void addBackpackToCart() {

        productsPage.addBackpackToCart();
        productsPage.clickCart();

        Assert.assertTrue(
                cartPage.isBackpackDisplayed()
        );
    }

    @Test(groups = "regression")
    public void addMultipleProductsToCart() {

        productsPage.addBackpackToCart();
        productsPage.addBikeLightToCart();
        productsPage.clickCart();

        Assert.assertTrue(
                cartPage.isBackpackDisplayed()
        );

        Assert.assertTrue(
                cartPage.isBikeLightDisplayed()
        );
    }
}