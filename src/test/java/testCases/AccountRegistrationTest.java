package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.homePage;
import pageObject.registrationPage;
import testBase.BaseClass;

public class AccountRegistrationTest extends BaseClass {
    @Test(groups = {"Regression","Master"})
    public void AccountRegistration(){
        try {

            logger.info("***** Starting TC001_AccountRegistrationTest  ****");
            logger.debug("This is a debug log message");

            homePage hp = new homePage(driver);

            hp.setLnkMyaccount();
            logger.info("Clicked on MyAccount Link.. ");

            hp.setLnkRegister();
            logger.info("Clicked on Register Link.. ");

            registrationPage rp = new registrationPage(driver);

            logger.info("Providing customer details...");
            rp.setFirstName(randomString());
            rp.setLastName(randomString());
            rp.setEmail(randomString() + "@gmail.com");
            rp.setTelephone(randomNumber());

            // store the password to use the same in confirmed password
            String password = randomAlphaNumberic();
            rp.setPassword(password);
            rp.setConfirmPassword(password);
            rp.setPrivacyPolicy();
            rp.clickContinue();
            logger.info("Validating expected message..");

            String confmsg = "Your Account Has Been Created!";
            Assert.assertEquals(rp.getConfirmationMsg(), confmsg);
        } catch (Exception e) {
            logger.error("Test Failed: " +e.getMessage());
            Assert.fail("Test Failed: " +e.getMessage());
        }
        finally {
            logger.info("***** Finished TC001_AccountRegistrationTest *****");
        }


    }
}
