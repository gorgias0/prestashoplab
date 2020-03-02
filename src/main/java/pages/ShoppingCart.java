package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCart {

    private static WebDriver driver;
    private static WebDriverWait wait;

    public ShoppingCart(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement proceedButton() {
        return driver.findElement(By.cssSelector("#main > div > div.cart-grid-right.col-xs-12.col-lg-4 > div.card.cart-summary > div.checkout.cart-detailed-actions.card-block > div > a"));
    }

    public String itemCountMessage() {
        return driver.findElement(By.cssSelector("#cart-subtotal-products > span.label.js-subtotal")).getText();
    }

    public String emptyMessage() {
        return driver.findElement(By.cssSelector("#main > div > div.cart-grid-body.col-xs-12.col-lg-8 > div > div.cart-overview.js-cart > span")).getText();
    }

    public WebElement deleteButton() {
        return driver.findElement(By.cssSelector("#main > div > div.cart-grid-body.col-xs-12.col-lg-8 > div > div.cart-overview.js-cart > ul > li > div > div.product-line-grid-right.product-line-actions.col-md-5.col-xs-12 > div > div.col-md-2.col-xs-2.text-xs-right > div > a"));
    }
}
