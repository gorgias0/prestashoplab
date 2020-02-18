package pages;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstPage {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static String url = "https://demo.prestashop.com/";

    public FirstPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        driver.get(url);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("framelive"));
    }

    public WebElement signinButton() {
        return driver.findElement(By.cssSelector("#_desktop_user_info > div > a > span"));
    }

    public WebElement tShirtButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#content > section > div > article:nth-child(1) > div > a")));
    }

    public WebElement newProductsButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("link-product-page-new-products-1")));
    }
}
