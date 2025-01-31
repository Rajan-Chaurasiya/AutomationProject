package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * myAccount class that represents the My Account page of the application.
 * It extends the BasePage class and provides methods to interact with the My Account page elements.
 */
public class myAccount extends BasePage {

    /**
     * Constructor to initialize the WebDriver and PageFactory elements.
     */
    public myAccount(WebDriver driver) {
        super(driver);
    }

    // WebElement for 'My Account' message
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement msgMyaccount;

    // WebElement for 'Logout' link
    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement lnkLogOut;

    /**
     * Verifies if the 'My Account' message is displayed.
     * 
     * @return true if the 'My Account' message is displayed, false otherwise
     */
    public boolean verifyLoginMessage() {
        try {
            return msgMyaccount.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Clicks the 'Logout' link.
     */
    public void clickLogOut() {
        lnkLogOut.click();
    }
}
