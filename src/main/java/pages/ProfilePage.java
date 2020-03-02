package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement informationButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#identity-link")));
    }

    public String headerText() {
        return driver.findElement(By.cssSelector("#main > header > h1")).getText();
    }

    public WebElement signOutLink() {
        return driver.findElement(By.cssSelector("#_desktop_user_info > div > a.logout.hidden-sm-down"));
    }
}
