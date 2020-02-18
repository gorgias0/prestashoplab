package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.util.concurrent.TimeUnit;

public class Lab2Tests {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20, 100);
    }

    @AfterClass
    public static void afterClass() {
        //driver.close();
    }

    /**
     * As a shopper I want to buy a product without having to sign in
     * so that I can save time
     */
    @Test
    public void testBuy() throws InterruptedException {
        FirstPage firstPage = new FirstPage(driver, wait);
        firstPage.tShirtButton().click();

        ProductPage productPage = new ProductPage(driver, wait);
        productPage.addToCartButton().click();

        ShoppingCartModal shoppingCartModal = new ShoppingCartModal(driver, wait);
        //shoppingCartModal.waitForLoad();
        Thread.sleep(2000); // här verkar det inte funka med något annat...
        shoppingCartModal.proceedToCheckoutButton().click();

        ShoppingCart shoppingCart = new ShoppingCart(driver, wait);
        shoppingCart.proceedButton().click();

        CheckoutPage checkoutPage = new CheckoutPage(driver, wait);
        checkoutPage.fillInPersonalInfo();
        checkoutPage.continueButton().click();

        checkoutPage.fillInAdresses();
        checkoutPage.confirmAdressesButton().click();

    }
}
