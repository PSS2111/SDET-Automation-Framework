package ui;

import base.BaseTest;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

@Listeners(TestListener.class)
public class CheckoutTest extends BaseTest {

    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @BeforeMethod(alwaysRun = true)
    public void start() {

        setup();

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

        loginPage.login("standard_user", "secret_sauce");
    }

    @AfterMethod(alwaysRun = true)
    public void stop() {
        tearDown();
    }

    @Test(groups = "smoke")
    public void completeCheckout() {

        productsPage.addBackpackToCart();
        productsPage.addBikeLightToCart();

        productsPage.clickCart();

        Assert.assertTrue(
                cartPage.isBackpackDisplayed()
        );

        Assert.assertTrue(
                cartPage.isBikeLightDisplayed()
        );

        cartPage.clickCheckout();

        checkoutPage.enterCustomerDetails(
                "RAM",
                "Test",
                "147001"
        );

        checkoutPage.clickContinue();
        checkoutPage.clickFinish();

        Assert.assertEquals(
                checkoutPage.getConfirmationMessage(),
                "Thank you for your order!"
        );
    }
}