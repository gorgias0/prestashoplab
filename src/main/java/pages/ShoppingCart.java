package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCart extends PageObject {

    public ShoppingCart(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#main > div > div.cart-grid-right.col-xs-12.col-lg-4 > div.card.cart-summary > div.checkout.cart-detailed-actions.card-block > div > a")
    public WebElement proceedButton;

    public CheckoutPage proceed() {
        proceedButton.click();
        return new CheckoutPage(driver);
    }
    @FindBy(css="#cart-subtotal-products > span.label.js-subtotal")
    private WebElement itemCountMessage;

    public String getItemCountMessage() {
        return itemCountMessage.getText();
    }

    @FindBy(css="#main > div > div.cart-grid-body.col-xs-12.col-lg-8 > div > div.cart-overview.js-cart > span")
    public WebElement emptyMessage;

    public String getEmptyMessage() {
        return emptyMessage.getText();
    }


    @FindBy(css="#main > div > div.cart-grid-body.col-xs-12.col-lg-8 > div > div.cart-overview.js-cart > ul > li > div > div.product-line-grid-right.product-line-actions.col-md-5.col-xs-12 > div > div.col-md-2.col-xs-2.text-xs-right > div > a")
    private WebElement deleteButton;

    public void delete() {
        deleteButton.click();
    }

}
