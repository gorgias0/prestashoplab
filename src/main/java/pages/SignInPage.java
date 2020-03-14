package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testdata.TestPerson;

public class SignInPage extends PageObject {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="customer-form")
    public WebElement customerForm;

    @FindBy(css="#customer-form > section > div:nth-child(1) > div.col-md-6.form-control-valign > label:nth-child(1) > span > input[type=radio]")
    public WebElement mrInput;

    @FindBy(css="#customer-form > section > div:nth-child(1) > div.col-md-6.form-control-valign > label:nth-child(2) > span > input[type=radio]")
    public WebElement mrsInput;

    @FindBy(name="email")
    public WebElement emailInput;

    @FindBy(name="password")
    public WebElement passwordInput;

    @FindBy(id="submit-login")
    public WebElement signInButton;

    @FindBy(name="firstname")
    public WebElement firstnameInput;
    @FindBy(name="lastname")
    public WebElement lastnameInput;
    @FindBy(name="psgdpr")
    public WebElement gdpr;
    @FindBy(css="#customer-form > footer > button")
    private WebElement saveButton;
    public void save(){saveButton.click();}
    @FindBy(name="submitCreate")
    private WebElement createInput;
    public void submit(){createInput.click();}

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

    @FindBy(css="#content > div > a")
    public WebElement createAccountLink;


    public boolean signIn(TestPerson p) {
        passwordInput.click();
        passwordInput.sendKeys(p.getPassword());
        emailInput.sendKeys(p.getEmail());
        signInButton.click();
        if(!haveAccount())
            return false;
        return true;
    }

    public void createAcount(TestPerson p) {
        createAccountLink.click();
        if(p.getGender().equals("male"))
            mrInput.click();
        else
            mrsInput.click();
        firstnameInput.sendKeys(p.getFirstName());
        lastnameInput.sendKeys(p.getLastName());
        emailInput.clear();
        emailInput.sendKeys(p.getEmail());
        passwordInput.clear();
        passwordInput.sendKeys(p.getPassword());
        gdpr.click();
        save();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){}
        save(); // click again to go to profilepage (bug in prestashop?)
     }


}
