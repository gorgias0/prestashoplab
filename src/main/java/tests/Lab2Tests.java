package tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import testdata.TestPerson;

import java.util.concurrent.TimeUnit;

public class Lab2Tests {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void before() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10, 300);
    }

    @AfterClass
    public static void after() {
       driver.close();
    }

    /**
     * 1. As a one time customer I want to buy a product without having to sign in
     * so that I can save time
     **/
    @Test
    public void testBuyAsGuest() {
        System.out.println("Running testBuyAsGuest()");
        FrontPage frontPage = new FrontPage(driver);
        ProductPage productPage = frontPage.buyTshirt();
        ShoppingCartModal shoppingCartModal = productPage.addToShoppingCart();
        ShoppingCart shoppingCart = shoppingCartModal.checkout();
        CheckoutPage checkoutPage = shoppingCart.proceed();

        TestPerson p = new TestPerson();
        checkoutPage.enterPersonalInfo(p);
        checkoutPage.enterAdress(p);
        // shipping with default options
        checkoutPage.confirmDeliveryButton.click();
        // pay by check
        checkoutPage.payByCheck();

        // assert that we have made a purchase
        Assert.assertEquals("Payment method: Payments by check",checkoutPage.getPaymentConfirmation());
        System.out.println(checkoutPage.getPaymentConfirmation());
        System.out.println("end buy as guest");
    }

    /**
    * 2. As a customer I want to search for products by name to quickly find what I'm looking for
     **/
    @Test
    public void testSearch() {
        System.out.println("Running testSearch");
        FrontPage frontPage = new FrontPage(driver);
        SearchResults searchResults = frontPage.search("hum");
        // asssert that we have some hits
        Assert.assertTrue(searchResults.getResultText().startsWith("Showing"));
        System.out.println(searchResults.getResultText());
        searchResults = frontPage.search("zxcvb83645");
        // assert that we didn't find anything
        Assert.assertTrue(searchResults.getZeroText().startsWith("Sorry"));
        System.out.println(searchResults.getZeroText());
        System.out.println("end testSearch");
    }

    /**
     * 3. As a user I want to be able to contact support to get help with my questions
     **/
    @Test
    public void testContactUs() {
        System.out.println("Running testContactUs");
        FrontPage frontPage = new FrontPage(driver);
        TestPerson p = new TestPerson();
        ContactPage contactPage = frontPage.goContact();
        String result = contactPage.sendMessage(p.getEmail(), "My message");
        System.out.println(result);
        Assert.assertEquals("Your message has been successfully sent to our team.", result);
        System.out.println("end testContactUs");
    }

    /* *
    * 4. As a customer I want to be able to add and remove products from the shopping cart to customize my order
    * */
    @Test
    public void testShoppingCart() {
        System.out.println("Running testShoppingCart");
        FrontPage frontPage = new FrontPage(driver);
        ProductPage productPage = frontPage.buyMug();
        ShoppingCartModal shoppingCartModal = productPage.addToShoppingCart();
        ShoppingCart shoppingCart = shoppingCartModal.checkout();
        // assert one item in shoppingcart
        Assert.assertEquals("1 item", shoppingCart.getItemCountMessage());
        shoppingCart.delete();
        // assert no item in shoppingcart
        Assert.assertNotNull(shoppingCart.getEmptyMessage());
        System.out.println("end testShoppingCart");
    }

    /**
     * 5. As a repeat customer I want to be able to sign in to see my order history
     **/
    @Test
    public void testSignIn() {
        System.out.println("Testsignin");
        FrontPage frontPage = new FrontPage(driver);
        SignInPage signInPage = frontPage.goSignIn();
        ProfilePage profilePage = new ProfilePage(driver);

        TestPerson p = new TestPerson();
        if (!signInPage.signIn(p)) {
            signInPage.createAcount(p);
            profilePage.signOut(); // we must first sign out again after creating a new account
            signInPage.signIn(p); // now we know that we have an account so this should always work
        }
        // check that we arrived at profilepage
        Assert.assertTrue(profilePage.informationButton.isDisplayed());
        profilePage.signOut();
        // check that we are signed out
        Assert.assertTrue(signInPage.signInButton.isDisplayed());
        System.out.println("end testsignin");
    }

    /**
     * 6. As a customer I want to be able create an account to keep track of my orders
     **/
    @Test
    public void testCreateAccount() {
        System.out.println("testcreateaccount");
        FrontPage frontPage = new FrontPage(driver);
        SignInPage signInPage = frontPage.goSignIn();
        TestPerson p = new TestPerson(true); // random email för att alltid kunna skapa ett nytt konto
        signInPage.createAcount(p);
        ProfilePage profilePage = new ProfilePage(driver);
        // check that we arrived at profilepage
        Assert.assertTrue(profilePage.informationButton.isDisplayed());
        profilePage.signOut();
        // check that we are signed out
        Assert.assertTrue(signInPage.signInButton.isDisplayed());
        System.out.println("end testcreateaccount");
    }


}

