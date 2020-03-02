package tests;

import org.junit.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import testdata.TestPerson;

import java.util.concurrent.TimeUnit;

public class Lab2Tests {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20, 100);
    }

    @After
    public void after() {
        driver.close();
    }

    /**
     * As a shopper I want to buy a product without having to sign in
     * so that I can save time
     */
    @Test
    public void testBuy() throws InterruptedException {
        System.out.println("Running testBuy()");
        FirstPage firstPage = new FirstPage(driver, wait);
        firstPage.tShirtButton().click();

        ProductPage productPage = new ProductPage(driver, wait);
        productPage.addToCartButton().click();

        ShoppingCartModal shoppingCartModal = new ShoppingCartModal(driver, wait);
        shoppingCartModal.proceedToCheckoutButton().click();

        ShoppingCart shoppingCart = new ShoppingCart(driver, wait);
        shoppingCart.proceedButton().click();

        CheckoutPage checkoutPage = new CheckoutPage(driver, wait);
        TestPerson p = new TestPerson();
        checkoutPage.fillInPersonalInfo(p);
        checkoutPage.continueButton().click();

        checkoutPage.fillInAdresses(p);
        checkoutPage.confirmAdressesButton().click();

        // shipping
        //checkoutPage.shippingByPrestashopRadio().click();
        checkoutPage.confirmDeliveryButton().click();
        // payment
        checkoutPage.payByCheckOption().click();
        checkoutPage.approveOption().click();
        checkoutPage.sendOrderButton().click();

        Assert.assertEquals("Payment method: Payments by check",checkoutPage.paymentConfirmMessage());
        System.out.println(checkoutPage.paymentConfirmMessage());
    }

    @Test
    public void testSearch() {
        System.out.println("Running testSearch()");
        FirstPage firstPage = new FirstPage(driver, wait);
        firstPage.searchInput().sendKeys("hum"+ Keys.ENTER);
        SearchResults searchResults = new SearchResults(driver, wait);
        Assert.assertEquals("Showing 1-5 of 5 item(s)", searchResults.resultText());
        System.out.println(searchResults.resultText());
        firstPage.searchInput().sendKeys("zxcvb"+ Keys.ENTER);
        Assert.assertEquals("Sorry for the inconvenience.", searchResults.resultZeroText());
        System.out.println(searchResults.resultZeroText());
    }

    @Test
    public void testContactUs() {
        System.out.println("Running testContactUs()");
        FirstPage firstPage = new FirstPage(driver, wait);
        firstPage.contactLink().click();
        TestPerson p = new TestPerson();
        ContactPage contactPage = new ContactPage(driver,wait);
        contactPage.emailInput().sendKeys(p.email);
        contactPage.messsageInput().sendKeys("My testmessage");
        contactPage.sendButton().click();
        System.out.println(contactPage.confirmText());
        Assert.assertEquals("Your message has been successfully sent to our team.", contactPage.confirmText());
    }
}
