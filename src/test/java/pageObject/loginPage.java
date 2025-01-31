package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * loginPage class that represents the login page of the application.
 * It extends the BasePage class and provides methods to interact with the login page elements.
 */
public class loginPage extends BasePage {

    /**
     * Constructor to initialize the WebDriver and PageFactory elements.
     */
    public loginPage(WebDriver driver) {
        super(driver);
    }

    // WebElement for login email input field
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement loginEmail;

    // WebElement for login password input field
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement loginPassword;

    // WebElement for login button
    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    /**
     * Sets the login email in the email input field.
     */
    public void setLoginEmail(String loginUsername) {
        loginEmail.sendKeys(loginUsername);
    }

    /**
     * Sets the login password in the password input field.
     */
    public void setLoginPassword(String loginPass) {
        loginPassword.sendKeys(loginPass);
    }

    /**
     * Clicks the login button.
     */
    public void clickLoginButton() {
        loginButton.click();
    }
}
