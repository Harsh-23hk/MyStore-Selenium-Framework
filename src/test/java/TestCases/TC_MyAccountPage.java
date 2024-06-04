package TestCases;

import PageObject.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_MyAccountPage extends BaseClass {

    @Test(testName = "RegistrationTest", enabled = false)
    public void verifyRegistration() {
        logger.info("Entered RegistrationTest");
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.enterCreateEmail("namushsharma@gmail.com");
        logger.info("Entered email");

        myAccountPage.clickCreateAnAccount();
        logger.info("Clicked on create an account");

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.selectMr();
        registrationPage.enterFirstName("Anshul");
        registrationPage.enterLastName("Sharma");
        registrationPage.selectMr();
        registrationPage.enterPassword("ansh1234");
        registrationPage.clickRegister();
        logger.info("Entered registration details");
        logger.info("Clicked on register");

        UserAccountPage userAccountPage = new UserAccountPage(driver);
        Assert.assertEquals(userAccountPage.getUserAccount(), "Namush Sharma", "User account name is not matching");

        logger.info("Verified user account name");
        userAccountPage.clickSignOut();

    }

    @Test(testName = "VerifyLogin")
    public void verifyLogin() throws IOException {
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


    @Test(testName = "verifyLogout ")
    public void verifyLogout() throws IOException {
        logger.info("Entered LogoutTest");
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.enterEmail("namushsharma@gmail.com");
        logger.info("Entered email for LogoutTest");

        myAccountPage.enterPassword("123456");
        logger.info("Entered password for LogoutTest");

        myAccountPage.clickSignIn();
        logger.info("Clicked on login for LogoutTest");


        UserAccountPage userAccountPage = new UserAccountPage(driver);
        userAccountPage.clickSignOut();
        logger.info("Clicked on sign out");

        if (driver.getTitle().equals("Login - My Shop")) {
            logger.info("LogoutTest Passed");
            Assert.assertTrue(true);

        } else {
            captureScreenShot(driver, "LogoutTest");
            logger.info("Test FAILED");
            Assert.fail();

        }

    }

}
