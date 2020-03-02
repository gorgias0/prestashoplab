package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import testdata.TestPerson;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

public class CheckoutPage {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement mrRadio() {
        return driver.findElement(By.cssSelector("#customer-form > section > div:nth-child(2) > div.col-md-6.form-control-valign > label:nth-child(1) > span > input[type=radio]"));
    }
    public WebElement mrsRadio() {
        return driver.findElement(By.cssSelector("#customer-form > section > div:nth-child(2) > div.col-md-6.form-control-valign > label:nth-child(2) > span > input[type=radio]"));
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

    // shippment
    public WebElement shippingByPrestashopRadio() {return driver.findElement(By.id("delivery_option_1"));}
    //public WebElement shippingByPrestashopRadio() {return wait.until(ExpectedConditions.presenceOfElementLocated(By.id("delivery_option_1")));}
    public WebElement shippingByOtherRadio() {return driver.findElement(By.id("delivery_option_2 > span"));}
    public WebElement confirmDeliveryButton() {return driver.findElement(By.cssSelector("#js-delivery > button"));}

    // payment
    public WebElement payByCheckOption() {return driver.findElement(By.id("payment-option-1"));}
    public WebElement payBankWireOption() {return driver.findElement(By.id("payment-option-2"));}

    public WebElement approveOption() {return driver.findElement(By.name("conditions_to_approve\\[terms-and-conditions\\]"));}
    public WebElement sendOrderButton() {return driver.findElement(By.cssSelector("#payment-confirmation > div.ps-shown-by-js > button"));}

    public String paymentConfirmMessage() {
        return driver.findElement(By.cssSelector("#order-details > ul > li:nth-child(2)")).getText();
    }



    public void fillInPersonalInfo(TestPerson p) {
        if(p.gender.equals("male"))
            mrRadio().click();
        else
            mrsRadio().click();
        firstnameInput().sendKeys(p.firstName);
        lastnameInput().sendKeys(p.lastName);
        emailInput().sendKeys(p.guestEmail);
        agreeRadio().click();
    }

    public void fillInAdresses(TestPerson p) {
        address1Input().sendKeys(p.address);
        postCodeInput().sendKeys(p.zipcode);
        cityInput().sendKeys(p.city);
        countrySelect().selectByVisibleText(p.country);
        confirmAdressesButton().click();

    }

}


