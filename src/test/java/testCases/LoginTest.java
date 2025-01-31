package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.homePage;
import pageObject.loginPage;
import pageObject.myAccount;
import testBase.BaseClass;

/**
 * LoginTest class that contains test cases for login functionality.
 */
public class LoginTest extends BaseClass {

    /**
     * Test method to verify the login functionality.
     */
    @Test(groups = {"Sanity", "Master"})
    public void logintest() {
        try {
            logger.info("***** Starting TC001_AccountRegistrationTest *****");
            logger.debug("This is a debug log message");

            homePage hp = new homePage(driver);
            logger.info("Navigating to My Account...");
            hp.clickMyAccount();
            logger.info("Navigating to Login...");
            hp.clickLogin();

            loginPage lp = new loginPage(driver);
            logger.info("Providing login details...");
            lp.setLoginEmail(p.getProperty("USERNAME"));
            lp.setLoginPassword(p.getProperty("PASSWORD"));
            lp.clickLoginButton();

            myAccount ma = new myAccount(driver);
            boolean isLoggedIn = ma.verifyLogin();
            Assert.assertTrue(isLoggedIn, "Login failed!");

            logger.info("Login test passed.");
        } catch (Exception e) {
            logger.error("Login test failed.", e);
            Assert.fail("Login test failed due to an exception.");
        }
    }
}
