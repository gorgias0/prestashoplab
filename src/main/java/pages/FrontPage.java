package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrontPage extends PageObject {

    private static String url = "https://demo.prestashop.com/";
    private static WebDriverWait wait;

    public FrontPage(WebDriver driver) {
        super(driver);
        driver.get(url);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("framelive"));
    }

    public SignInPage goSignIn() {
        signinButton.click();
        return new SignInPage(driver);
    }
    @FindBy(css="#_desktop_user_info > div > a > span")
    private WebElement signinButton;

    @FindBy(css="#content > section > div > article:nth-child(1) > div > a")
    private WebElement tShirtButton;

    public ProductPage buyTshirt() {
        tShirtButton.click();
        return new ProductPage(driver);
    }

    @FindBy(css="#content > section > div > article:nth-child(8) > div > a")
    private WebElement mugButton;

    public ProductPage buyMug() {
        mugButton.click();
        return new ProductPage(driver);
    }

    @FindBy(name="s")
    private WebElement searchInput;

    public SearchResults search(String s) {
        searchInput.sendKeys(s);
        searchInput.submit();
        return new SearchResults(driver);
    }

    @FindBy(css="#contact-link > a")
    private WebElement contactLink;

    public ContactPage goContact() {
        contactLink.click();
        return new ContactPage(driver);
    }
    @FindBy(css="#_desktop_cart > div > div > a")
    private WebElement shoppingCartButton;

    public ShoppingCart goShoppingCart() {
        shoppingCartButton.click();
        return new ShoppingCart(driver);
    }
    @FindBy(css="#_desktop_user_info > div > a")
    private WebElement signInLink;

    @FindBy(css="#_desktop_user_info > div > a")
    private WebElement signOutLink;

}
