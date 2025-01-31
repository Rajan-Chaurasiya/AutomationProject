package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage{

    public loginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement loginEmail;
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement loginPassword;
    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    public void setLoginEmail(String loginUsername){
        loginEmail.sendKeys(loginUsername);
    }
    public void setLoginPassword(String loginPass){
        loginPassword.sendKeys(loginPass);
    }
    public void clickLoginButton(){
        loginButton.click();
    }

}
