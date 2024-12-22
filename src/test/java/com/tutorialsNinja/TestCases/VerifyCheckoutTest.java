package com.tutorialsNinja.TestCases;

import com.tutorialsNinja.Pages.*;
import com.tutorialsNinja.TestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class VerifyCheckoutTest extends TestBase {

    public VerifyCheckoutTest() throws Exception {
        super();
    }

    public WebDriver driver;
    public LandingPage landingpage;
    public LoginPage loginpage;
    public AccountPage accountpage;
    public ProductPage productpage;
    public AddToCartDetailsPage addToCartDetailsPage;
    public CheckoutPage checkoutPage;
    public SuccessfullyPlacedOrderPage successfullyPlacedOrderPage;

    @BeforeClass
    public void setup() {

        driver = initializeBrowser();
        landingpage = new LandingPage(driver);
        loginpage = landingpage.clickOnMyAccountAndClickOnLogin();
    }

    @Test(priority = 1)
    public void loginWithValidCredentials() {

        accountpage = loginpage.directlyGoToAccountPage(prop.getProperty("email"), prop.getProperty("password"));
        Assert.assertTrue(accountpage.validateDisplayStatusOfLogoutLink());
    }

    @Test(priority = 2)
    public void searchProduct() {

        productpage = accountpage.navigateToProductPage(prop.getProperty("product"));
        Assert.assertTrue(productpage.displayStatusOfHPLaptop());
    }

    @Test(priority = 3, dependsOnMethods = "searchProduct")
    public void addProductToCart() throws InterruptedException {

        addToCartDetailsPage = productpage.navigateDetailsPage();
        checkoutPage = addToCartDetailsPage.navigateCheckoutPage();
    }

    @Test(priority = 4, dependsOnMethods = "addProductToCart")
    public void checkoutAnConfirmOrder() throws InterruptedException {

        successfullyPlacedOrderPage = checkoutPage.checkoutSuccessfully();
        Assert.assertTrue(successfullyPlacedOrderPage.successfullyCheckedOut());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
