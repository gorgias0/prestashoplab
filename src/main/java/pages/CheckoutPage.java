package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import testdata.TestPerson;

public class CheckoutPage extends PageObject{

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#customer-form > section > div:nth-child(1) > div.col-md-6.form-control-valign > label:nth-child(1) > span > input[type=radio]")
    public WebElement mrRadio;

    @FindBy(css = "#customer-form > section > div:nth-child(1) > div.col-md-6.form-control-valign > label:nth-child(2) > span > input[type=radio]" )
    public WebElement mrsRadio;

    @FindBy(name = "firstname")
    public WebElement firstnameInput;
    @FindBy(name = "lastname")
    public WebElement lastnameInput;
    @FindBy(name = "email")
    public WebElement emailInput;
    @FindBy(name = "password")
    public WebElement passwordInput;
    @FindBy(name = "birthday")
    public WebElement birthdayInput;
    @FindBy(name = "psgdpr")
    public WebElement agreeRadio;
    @FindBy(name = "address1")
    public WebElement address1Input;
    @FindBy(name = "postcode")
    public WebElement postCodeInput;
    @FindBy(name = "city")
    public WebElement cityInput;
    @FindBy(name = "id_country")
    private WebElement countrySelect;
    @FindBy(name = "confirm-addresses")
    public WebElement confirmAdressesButton;
    @FindBy(name = "continue")
    public WebElement continueButton;

    // shippment
    @FindBy(id="delivery_option_1")
    public WebElement shippingByPrestashopRadio;
    @FindBy(id="delivery_option_2 > span")
    public WebElement shippingByOtherRadio;
    @FindBy(css="#js-delivery > button")
    public WebElement confirmDeliveryButton;

    // payment
    @FindBy(id="payment-option-1")
    public WebElement payByCheckOption;
    @FindBy(id = "payment-option-2")
    public WebElement payBankWireOption;
    @FindBy(name = "conditions_to_approve\\[terms-and-conditions\\]")
    public WebElement approveOption;
    @FindBy(css = "#payment-confirmation > div.ps-shown-by-js > button")
    public WebElement sendOrderButton;

    @FindBy(css="#order-details > ul > li:nth-child(2)")
    private WebElement confMsg;
    public String getPaymentConfirmation() {
        return confMsg.getText();
    }



    public void enterPersonalInfo(TestPerson p) {
        if(p.getGender().equals("male"))
            mrRadio.click();
        else
            mrsRadio.click();
        firstnameInput.sendKeys(p.getFirstName());
        lastnameInput.sendKeys(p.getLastName());
        emailInput.sendKeys(p.getGuestEmail());
        agreeRadio.click();
        continueButton.click();
    }

    public void enterAdress(TestPerson p) {
        address1Input.sendKeys(p.getAddress());
        postCodeInput.sendKeys(p.getZipcode());
        cityInput.sendKeys(p.getCity());
        Select country = new Select(countrySelect);
        country.selectByVisibleText(p.getCountry());
        confirmAdressesButton.click();
    }

    // last step
    public void payByCheck() {
        payByCheckOption.click();
        approveOption.click();
        sendOrderButton.click();
    }

}


