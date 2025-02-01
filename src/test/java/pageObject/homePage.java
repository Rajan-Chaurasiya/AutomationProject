package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * homePage class that represents the home page of the application.
 * It extends the BasePage class and provides methods to interact with the home page elements.
 */
public class homePage extends BasePage {

    // Constructor to initialize the WebDriver and PageFactory elements
    public homePage(WebDriver driver) {
        super(driver);
    }

    // WebElement for 'My Account' link
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement lnkMyaccount;

    // WebElement for 'Register' link
    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement lnkRegister;

    // WebElement for 'Login' link
    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement lnkLogin;

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement txtProduct;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    WebElement searchButton;

    /**
     * Clicks on the 'My Account' link.
     */
    public void clickMyAccount() {
        lnkMyaccount.click();
    }

    /**
     * Clicks on the 'Register' link.
     */
    public void clickRegister() {
        lnkRegister.click();
    }

    /**
     * Clicks on the 'Login' link.
     */
    public void clickLogin() {
        lnkLogin.click();
    }

    public void setTxtProduct(String productName) {
        txtProduct.sendKeys(productName);

    }

    public void ButtonSearch(){
        searchButton.click();
    }


}
