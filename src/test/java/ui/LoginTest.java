package ui;

import base.BaseTest;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private ProductsPage productsPage;

    @BeforeMethod(alwaysRun = true)
    public void start() {

        setup();

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void stop() {
        tearDown();
    }

    @Test(groups = "smoke")
    public void validLogin() {

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(
                productsPage.isProductsPageDisplayed()
        );
    }

    @Test(groups = "regression")
    public void invalidLogin() {

        loginPage.login("standard_user", "wrong_password");

        String error = loginPage.getErrorMessage();

        Assert.assertTrue(
                error.contains("Username and password do not match")
        );
    }

    @Test(groups = "regression")
    public void lockedUserLogin() {

        loginPage.login("locked_out_user", "secret_sauce");

        String error = loginPage.getErrorMessage();

        Assert.assertTrue(
                error.contains("locked out")
        );
    }
}