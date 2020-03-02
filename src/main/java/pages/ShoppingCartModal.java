package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartModal {

    private static WebDriver driver;
    private static WebDriverWait wait;

    public ShoppingCartModal(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
                "#blockcart-modal > div > div > div.modal-body > div > div.col-md-7 > div > p:nth-child(2) > span.label")));
    }

    public WebElement proceedToCheckoutButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#blockcart-modal > div > div > div.modal-body > div > div.col-md-7 > div > div > a")));
    }

    public WebElement continueShoppingButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#blockcart-modal > div > div > div.modal-body > div > div.col-md-7 > div > div > button")));
    }
}
