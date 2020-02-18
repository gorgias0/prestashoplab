package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import testdata.TestPerson;

public class CheckoutPage {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement genderRadio() {
        return driver.findElement(By.cssSelector("#customer-form > section > div:nth-child(2) > div.col-md-6.form-control-valign > label:nth-child(1) > span > input[type=radio]"));
    }
    public WebElement firstnameInput() {
        return driver.findElement(By.name("firstname"));
    }
    public WebElement lastnameInput() {
        return driver.findElement(By.name("lastname"));
    }
    public WebElement emailInput() {
        return driver.findElement(By.name("email"));
    }
    public WebElement passwordInput() {
        return driver.findElement(By.name("password"));
    }
    public WebElement birthdayInput() {
        return driver.findElement(By.name("birthday"));
    }
    public WebElement agreeRadio() {
        return driver.findElement(By.name("psgdpr"));
    }
    public WebElement address1Input() {
        return driver.findElement(By.name("address1"));
    }
    public WebElement postCodeInput() {
        return driver.findElement(By.name("postcode"));
    }
    public WebElement cityInput() {
        return driver.findElement(By.name("city"));
    }
    public Select countrySelect() {
        return new Select(driver.findElement(By.name("id_country")));
    }
    public WebElement confirmAdressesButton() {
        return driver.findElement(By.name("confirm-addresses"));
    }
    public WebElement continueButton() {
        return driver.findElement(By.name("continue"));
    }

    public void fillInPersonalInfo() {
        genderRadio().click();
        firstnameInput().sendKeys(TestPerson.firstName);
        lastnameInput().sendKeys(TestPerson.lastName);
        emailInput().sendKeys(TestPerson.email);
        agreeRadio().click();
    }

    public void fillInAdresses() {
        address1Input().sendKeys(TestPerson.address);
        postCodeInput().sendKeys(TestPerson.zipcode);
        cityInput().sendKeys(TestPerson.city);
        countrySelect().selectByVisibleText(TestPerson.country);
        confirmAdressesButton().click();

    }

}


