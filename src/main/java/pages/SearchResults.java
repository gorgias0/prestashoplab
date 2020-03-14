package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResults extends PageObject {

    public SearchResults(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#js-product-list-top > div.col-sm-12.hidden-md-up.text-sm-center.showing")
    private WebElement result;

    public String getResultText() {
        return result.getAttribute("innerHTML").trim();
    }

    @FindBy(css="#content > h4")
    private WebElement zero;

    public String getZeroText() {
        return zero.getText().trim();
    }

}
