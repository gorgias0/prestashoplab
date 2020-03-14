package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends PageObject{

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name="from")
    private WebElement emailInput;
    @FindBy(name="message")
    private WebElement messsageInput;
    @FindBy(css="#content > section > form > footer > input.btn.btn-primary")
    private WebElement sendButton;

    public String sendMessage(String email, String message) {
        emailInput.sendKeys(email);
        messsageInput.sendKeys(message);
        sendButton.click();
        return getConfirmText();
    }

    @FindBy(css="#content > section > form > div > ul > li")
    private WebElement confirmText;
    public String getConfirmText() {return confirmText.getText();}

}
