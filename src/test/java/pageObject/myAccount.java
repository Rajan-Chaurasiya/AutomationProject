package pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myAccount extends BasePage {
    public myAccount(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement msgMyaccount;
    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement lnkLogOut;

    public boolean verifyLoginMessage(){
        try{
            return msgMyaccount.isDisplayed();
        }
        catch (Exception e){
            return false;
        }

    }

    public void clickLogOut(){
        lnkLogOut.click();
    }
}
