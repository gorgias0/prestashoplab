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
        wait = new WebDriverWait(driver, 20, 300);
    }

    @After
    public void after() {
       driver.close();
    }

    /**
     * 1. As a one time customer I want to buy a product without having to sign in
     * so that I can save time
     **/
    @Test
    public void testBuyAsGuest() {
        System.out.println("Running testBuyAsGuest()");
        FrontPage frontPage = new FrontPage(driver, wait);
        frontPage.tShirtButton().click();

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

        // assert that we have made a purchase
        Assert.assertEquals("Payment method: Payments by check",checkoutPage.paymentConfirmMessage());
        System.out.println(checkoutPage.paymentConfirmMessage());
    }

    /**
    * 2. As a customer I want to search for products by name to quickly find what I'm looking for
     **/
    @Test
    public void testSearch() {
        System.out.println("Running testSearch()");
        FrontPage frontPage = new FrontPage(driver, wait);
        frontPage.searchInput().sendKeys("hum"+ Keys.ENTER);
        SearchResults searchResults = new SearchResults(driver, wait);
        // asssert that we have some hits
        Assert.assertTrue(searchResults.resultText().startsWith("Showing"));
        System.out.println(searchResults.resultText());
        frontPage.searchInput().sendKeys("zxcvb83645"+ Keys.ENTER);
        // assert that we didn't find anything
        Assert.assertTrue(searchResults.resultZeroText().startsWith("Sorry"));
        System.out.println(searchResults.resultZeroText());
    }

    /**
     * 3. As a user I want to be able to contact support to get help with my questions
     **/
    @Test
    public void testContactUs() {
        System.out.println("Running testContactUs()");
        FrontPage frontPage = new FrontPage(driver, wait);
        frontPage.contactLink().click();
        TestPerson p = new TestPerson();
        ContactPage contactPage = new ContactPage(driver, wait);
        contactPage.emailInput().sendKeys(p.getEmail());
        contactPage.messsageInput().sendKeys("My testmessage");
        contactPage.sendButton().click();
        System.out.println(contactPage.confirmText());
        Assert.assertEquals("Your message has been successfully sent to our team.", contactPage.confirmText());
    }

    /* *
    * 4. As a customer I want to be able to add and remove products from the shopping cart to customize my order
    * */
    @Test
    public void testShoppingCart() {
        System.out.println("Running testShoppingCart()");
        FrontPage frontPage = new FrontPage(driver, wait);
        frontPage.mugButton().click();
        ProductPage productPage = new ProductPage(driver, wait);
        productPage.addToCartButton().click();
        ShoppingCartModal shoppingCartModal = new ShoppingCartModal(driver, wait);
        shoppingCartModal.continueShoppingButton().click();
        frontPage.shoppingCartButton().click();
        ShoppingCart shoppingCart = new ShoppingCart(driver, wait);
        // assert one item in shoppingcart
        Assert.assertEquals("1 item", shoppingCart.itemCountMessage());
        shoppingCart.deleteButton().click();
        // assert no item in shoppingcart
        Assert.assertNotNull(shoppingCart.emptyMessage());
    }

    /**
     * 5. As a repeat customer I want to be able to sign in to see my order history
     **/
    @Test
    public void testSignIn() {
        FrontPage frontPage = new FrontPage(driver, wait);
        frontPage.signinButton().click();
        SignInPage signInPage = new SignInPage(driver, wait);
        ProfilePage profilePage = new ProfilePage(driver, wait);

        TestPerson p = new TestPerson();
        if (!signInPage.signIn(p)) {
            signInPage.createAcount(p);
            profilePage.signOutLink().click(); // we must first sign out again after creating a new account
            signInPage.signIn(p); // now we know that we have an account so this should always work
        }
        // check that we arrived at profilepage
        Assert.assertTrue(profilePage.informationButton().isDisplayed());
        profilePage.signOutLink().click();
        // check that we are signed out
        Assert.assertTrue(signInPage.signInButton().isDisplayed());
    }

    /**
     * 6. As a customer I want to be able create an account to keep track of my orders
     **/
    @Test
    public void testCreateAccount() {
        FrontPage frontPage = new FrontPage(driver, wait);
        frontPage.signinButton().click();
        SignInPage signInPage = new SignInPage(driver, wait);
        TestPerson p = new TestPerson(true); // random email för att alltid kunna skapa ett nytt konto
        signInPage.createAcount(p);
        ProfilePage profilePage = new ProfilePage(driver, wait);
        // check that we arrived at profilepage
        Assert.assertTrue(profilePage.informationButton().isDisplayed());
        profilePage.signOutLink().click();
        // check that we are signed out
        Assert.assertTrue(signInPage.signInButton().isDisplayed());
    }


}

