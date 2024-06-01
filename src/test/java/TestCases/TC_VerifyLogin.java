package TestCases;

import PageObject.MyAccountPage;
import PageObject.UserAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_VerifyLogin extends BaseClass {

    @Test(testName = "VerifyLoginWithValidCredentials",description = "Login with valid email and password")
    public void VerifyLoginWithValidCredentials() throws IOException {
        logger.info("***************TestCase Verify Login starts*****************");
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.enterEmail("namushsharma@gmail.com");
        logger.info("Entered email for LoginTest");

        myAccountPage.enterPassword("123456");
        logger.info("Entered password for LoginTest");

        myAccountPage.clickSignIn();
        logger.info("Clicked on login for LoginTest");

        UserAccountPage userAccountPage = new UserAccountPage(driver);
        String Username = userAccountPage.getUserAccount();
        logger.info("Verified user account name for LoginTest");


        if (Username.equals("Namush Sharma")) {
            userAccountPage.clickSignOut();
            logger.info("Clicked on sign out and verifyLogin - passed");
            Assert.assertTrue(true, " verifyLogin - passed");
        } else {
            logger.info("verifyLogin - failed");

            captureScreenShot(driver, "verifyLogin");
            Assert.fail("verifyLogin - failed");
        }

        logger.info("***************TestCase Verify Login ends*****************");

    }


    @Test(testName = "VerifyLogin With Invalid Credentials"
            ,description = "Login with valid email and invalid password")
    public void verifyLoginWithInvalidCredentials() throws IOException {
        logger.info("***************TestCase Verify Login with invalid starts*****************");
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.enterEmail("namushsharma@gmail.com");
        logger.info("Entered valid email for invalid LoginTest");

        myAccountPage.enterPassword("16");
        logger.info("Entered invalid password for invalid LoginTest");

        myAccountPage.clickSignIn();
        logger.info("Clicked on sign in ");

        if (driver.getPageSource().contains("There is 1 error")) {
            logger.info("verifyLogin with Invalid Credentials - passed");
            Assert.assertTrue(true, "verifyLogin with Invalid Credentials - passed");
        } else {
            logger.info("verifyLogin with Invalid Credentials - failed");
            captureScreenShot(driver, "verifyLogin with Invalid Credentials");
            Assert.fail("verifyLogin with Invalid Credentials - failed");
        }


        logger.info("**************TestCase Verify Login ends***************");

    }

}
