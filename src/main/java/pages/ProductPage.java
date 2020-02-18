package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    private static WebDriver driver;
    private static WebDriverWait wait;

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement addToCartButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#add-to-cart-or-refresh > div.product-add-to-cart > div > div.add > button")));
    }
}
