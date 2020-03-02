package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static String url = "https://closed-canvas.demo.prestashop.com/en/contact-us";

    public ContactPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement emailInput() {
        return driver.findElement(By.name("from"));
    }
    public WebElement messsageInput() {
        return driver.findElement(By.name("message"));
    }
    public WebElement sendButton() {
        return driver.findElement(By.cssSelector("#content > section > form > footer > input.btn.btn-primary"));
    }

    public String confirmText() {
        return driver.findElement(By.cssSelector("#content > section > form > div > ul > li")).getText();
    }




}
