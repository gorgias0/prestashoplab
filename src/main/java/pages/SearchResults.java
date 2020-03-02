package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResults {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public SearchResults(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String resultText() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("#js-product-list-top > div.col-sm-12.hidden-md-up.text-sm-center.showing"))).getAttribute("innerHTML").trim();
    }

    public String resultZeroText() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("#content > h4"))).getText().trim();
    }


}
