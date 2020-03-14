package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartModal extends PageObject {

    public ShoppingCartModal(WebDriver driver) {
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
                "#blockcart-modal > div > div > div.modal-body > div > div.col-md-7 > div > p:nth-child(2) > span.label")));
    }

    @FindBy(css="#blockcart-modal > div > div > div.modal-body > div > div.col-md-7 > div > div > a")
    private WebElement proceedToCheckoutButton;

    public ShoppingCart checkout() {
        proceedToCheckoutButton.click();
        return new ShoppingCart(driver);
    }

    @FindBy(css="#blockcart-modal > div > div > div.modal-body > div > div.col-md-7 > div > div > button")
    private WebElement continueShoppingButton;

    public void continueShopping() {
        continueShoppingButton.click();
    }
}
