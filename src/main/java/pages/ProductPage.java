package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends PageObject {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#add-to-cart-or-refresh > div.product-add-to-cart > div > div.add > button")
    private WebElement addToCartButton;

    public ShoppingCartModal addToShoppingCart() {
        addToCartButton.click();
        return new ShoppingCartModal(driver);
    }
}
