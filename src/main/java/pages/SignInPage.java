package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testdata.TestPerson;

public class SignInPage {

    private static WebDriver driver;
    private static WebDriverWait wait;

    public SignInPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement customerForm() {
        return driver.findElement(By.id("customer-form"));
    }
    public WebElement mrInput() {
        return driver.findElement(By.cssSelector("#customer-form > section > div:nth-child(1) > div.col-md-6.form-control-valign > label:nth-child(1) > span > input[type=radio]"));
    }
    public WebElement mrsInput() {
        return driver.findElement(By.cssSelector("#customer-form > section > div:nth-child(1) > div.col-md-6.form-control-valign > label:nth-child(2) > span > input[type=radio]"));
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
    public WebElement firstnameInput() {return driver.findElement(By.name("firstname"));}
    public WebElement lastnameInput() {return driver.findElement(By.name("lastname"));}
    public WebElement gdpr() {return driver.findElement(By.name("psgdpr"));}
    public WebElement saveButton() {return driver.findElement(By.cssSelector("#customer-form > footer > button"));}
    public WebElement createInput() {return driver.findElement(By.name("submitCreate"));}

    public boolean haveAccount() {
        try {
            driver.findElement(By.cssSelector("#content > section > div > ul > li")).getText();
        } catch (NoSuchElementException e) {
            System.out.println("Have an account");
            return true;
        }
        System.out.println("Don't have an account");
        return false;
    }

    public WebElement createAccountLink() {
        return driver.findElement(By.cssSelector("#content > div > a"));
    }

    public boolean signIn(TestPerson p) {
        passwordInput().click();
        passwordInput().sendKeys(p.getPassword());
        emailInput().sendKeys(p.getEmail());
        //passwordInput().sendKeys(Keys.ENTER);
        signInButton().click();
        if(!haveAccount())
            return false;
        return true;
    }

    public void createAcount(TestPerson p) {
        createAccountLink().click();
        if(p.getGender().equals("male"))
            mrInput().click();
        else
            mrsInput().click();
        firstnameInput().sendKeys(p.getFirstName());
        lastnameInput().sendKeys(p.getLastName());
        emailInput().clear();
        emailInput().sendKeys(p.getEmail());
        passwordInput().clear();
        passwordInput().sendKeys(p.getPassword());
        gdpr().click();
        saveButton().click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){}
        saveButton().click(); // click again to go to profilepage (bug in prestashop?)
     }


}
