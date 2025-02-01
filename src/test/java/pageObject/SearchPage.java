package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{
    /**
     * Constructor to initialize the WebDriver and PageFactory elements.
     *
     * @param driver
     */
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='Products meeting the search criteria']")
    WebElement searchText;

    public boolean verifysearchText(){
        try{
            return searchText.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
