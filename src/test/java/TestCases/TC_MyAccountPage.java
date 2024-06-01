package TestCases;

import PageObject.*;
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
        registrationPage.enterFirstName("Namush");
        registrationPage.enterLastName("Sharma");
        registrationPage.selectMr();
        registrationPage.enterPassword("123456");
        registrationPage.clickRegister();
        logger.info("Entered registration details");
        logger.info("Clicked on register");

        UserAccountPage userAccountPage = new UserAccountPage(driver);
        Assert.assertEquals(userAccountPage.getUserAccount(), "Namush Sharma", "User account name is not matching");

        logger.info("Verified user account name");

    }

    @Test(testName = "VerifyLogin" ,enabled = false )
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

    @Test(testName = "AddFirstAddressTest", enabled = false, dependsOnMethods = "verifyLogin")
    public void verifyAddFirstAddress() throws IOException {
        logger.info("Entered AddFirstAddressTest");
        UserAccountPage userAccountPage = new UserAccountPage(driver);
        userAccountPage.addFirstAddress();
        logger.info("Clicked on add first address");
        AddressPage addressPage = new AddressPage(driver);
        addressPage.enterFirstName("Namish");
        addressPage.enterLastName("Sharma");
        addressPage.enterAddress("123 Main St");
        addressPage.enterCity("Delhi");
        addressPage.enterState("Delhi");
        addressPage.enterCountry("Alabama");
        addressPage.enterZipCode("12345");
        addressPage.enterPhone("1234567890");
        addressPage.enterMobile("1234567890");
        addressPage.enterAddressAlias("Home");
        addressPage.clickSaveAddress();
        logger.info("Entered address details and Clicked on save address");

        if (driver.getTitle().equals("Addresses")) {
            logger.info("AddFirstAddressTest passed");
            Assert.assertTrue(true);
        } else {
            logger.info("AddFirstAddressTest failed");
            captureScreenShot(driver, "AddFirstAddressTest");
            Assert.fail();
        }

    }


}
