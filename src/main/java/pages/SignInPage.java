package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import testdata.TestPerson;

public class SignInPage {

    private static WebDriver driver;
    private static WebDriverWait wait;

    public SignInPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement emailInput() {
        return driver.findElement(By.name("email"));
    }

    public WebElement passwordInput() {
        return driver.findElement(By.name("password"));
    }

    public WebElement signInButton() {
        return driver.findElement(By.cssSelector("#submit-login"));
    }

    public void signIn(TestPerson p) {
        passwordInput().sendKeys(p.password);
        emailInput().sendKeys(p.email);
        signInButton().click();
    }
}
