package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.homePage;
import pageObject.loginPage;
import pageObject.myAccount;
import testBase.BaseClass;
import utilities.DataProviders;

public class LoginDDT extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups = "DataDriven")
    public void verify_loginDDT(String username, String password, String exp) {
            logger.info("LoginDDT test case started");
        try {
            //home page
            homePage hp = new homePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            //login page
            loginPage lp = new loginPage(driver);
            lp.setLoginEmail(username);
            lp.setLoginPassword(password);
            lp.clickLoginButton();

            // myaccount page
            myAccount myAcc = new myAccount(driver);
            boolean targetpage = myAcc.verifyLoginMessage();

            if (exp.equalsIgnoreCase("valid")) {
                if (targetpage) {
                    myAcc.clickLogOut();
                    Assert.assertTrue(true);

                } else {
                    Assert.assertTrue(false);
                }
            }
            if (exp.equalsIgnoreCase("invalid")) {
                if (targetpage) {
                    myAcc.clickLogOut();
                    Assert.fail();
                } else {
                    Assert.assertTrue(true);
                }
            }

        }catch (Exception e){
            Assert.fail();
        }
        finally {
            logger.info("Test Case Finished");
        }

    }
}

