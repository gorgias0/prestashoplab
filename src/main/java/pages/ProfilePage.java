package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageObject {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="identity-link")
    public WebElement informationButton;

    @FindBy(css="#main > header > h1")
    private WebElement htxt;

    public String headerText() {
        return htxt.getText();
    }
    @FindBy(css="#_desktop_user_info > div > a.logout.hidden-sm-down")
    private WebElement signOutLink;

    public void signOut() {
        signOutLink.click();
    }
}
