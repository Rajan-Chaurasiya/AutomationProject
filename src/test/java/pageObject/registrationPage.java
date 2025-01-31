package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * registrationPage class that represents the registration page of the application.
 * It extends the BasePage class and provides methods to interact with the registration page elements.
 */
public class registrationPage extends BasePage {

    /**
     * Constructor to initialize the WebDriver and PageFactory elements.
     * 
     * @param driver the WebDriver instance to be used by the page objects
     */
    public registrationPage(WebDriver driver) {
        super(driver);
    }

    // WebElement for first name input field
    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement txtFirstname;

    // WebElement for last name input field
    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement txtLastname;

    // WebElement for email input field
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmail;

    // WebElement for telephone input field
    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement txtTelephone;

    // WebElement for password input field
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPassword;

    // WebElement for confirm password input field
    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement txtConfirmPassword;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement chkdPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btnContinue;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;

    public void setFirstName(String fname) {
        txtFirstname.sendKeys(fname);

    }

    public void setLastName(String lname) {
        txtLastname.sendKeys(lname);

    }

    public void setEmail(String email) {
        txtEmail.sendKeys(email);

    }

    public void setTelephone(String tel) {
        txtTelephone.sendKeys(tel);

    }

    public void setPassword(String pwd) {
        txtPassword.sendKeys(pwd);

    }

    public void setConfirmPassword(String pwd) {
        txtConfirmPassword.sendKeys(pwd);

    }

    public void setPrivacyPolicy() {
        chkdPolicy.click();

    }

    public void clickContinue() {
        //sol1
        btnContinue.click();

        //sol2
        //btnContinue.submit();

        //sol3
        //Actions act=new Actions(driver);
        //act.moveToElement(btnContinue).click().perform();



    }

    public String getConfirmationMsg() {
        try {
            return (msgConfirmation.getText());
        } catch (Exception e) {
            return (e.getMessage());

        }
    }
}
