package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.homePage;
import pageObject.loginPage;
import pageObject.myAccount;
import testBase.BaseClass;

public class LoginTest extends BaseClass {

   @Test(groups = {"Sanity","Master"})
   public void logintest(){
    try {
        logger.info("***** Starting TC001_AccountRegistrationTest  ****");
        logger.debug("This is a debug log message");

        homePage hp = new homePage(driver);
        logger.info("Clicked on MyAccount Link.. ");
        hp.setLnkMyaccount();
        logger.info("Clicked on Register Link.. ");
        hp.setLnkLogin();

        loginPage lp = new loginPage(driver);
        logger.info("Providing Login details...");
        lp.setLoginEmail(p.getProperty("USERNAME"));
        lp.setLoginPassword(p.getProperty("PASSWORD"));
        lp.clickLoginButton();

        myAccount myAcc = new myAccount(driver);
        logger.info("Validating expected message..");
        Assert.assertTrue(myAcc.verifyLoginMessage());


    } catch (Exception e) {
        logger.error("Test Failed: "+e.getMessage());
        Assert.fail("Test Failed: "+e.getMessage());
    }
    finally {
        logger.info("Finished LoginTest");
    }



   }
}
