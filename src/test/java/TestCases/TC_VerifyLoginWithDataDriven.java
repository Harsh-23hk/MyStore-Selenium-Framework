package TestCases;

import PageObject.MyAccountPage;
import PageObject.UserAccountPage;
import Utilities.ReaderDDT;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_VerifyLoginWithDataDriven extends BaseClass {



    @DataProvider(name = "LoginTestData")
    public String[][] LoginTestData() throws Exception {
        String fileName = System.getProperty("user.dir") + "\\TestData\\MyStoreTestData.xlsx";
        String sheetName = "LoginTestData";
        int row = ReaderDDT.getRowCount(fileName, sheetName);
        int cell = ReaderDDT.getColCount(fileName, sheetName);
        String[][] data ;
        data = new String[row - 1][cell];
        for (int current_row = 1; current_row < row; current_row++) {
            for (int current_cell = 0; current_cell < cell; current_cell++) {
                data[current_row - 1][current_cell] = ReaderDDT.getCellValue(fileName, sheetName, current_row, current_cell);
            }
        }

        return data;

    }

    @Test(dataProvider = "LoginTestData")
    public void verifyLogin(String userEmail, String userPwd, String expectedUsername) throws Exception {
        logger.info("***************TestCase Verify Login starts*****************");
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.enterEmail(userEmail);
        myAccountPage.enterPassword(userPwd);
        myAccountPage.clickSignIn();

        UserAccountPage userAccountPage = new UserAccountPage(driver);
        String userName=userAccountPage.getUserAccount();
        logger.info(("login into account "));

        if(userName.equals(expectedUsername)){
            logger.info("verifyLogin - passed");
            Assert.assertTrue(true, "verifyLogin - passed");
            userAccountPage.clickSignOut();
        }
        else{
            logger.info("verifyLogin - failed");
            captureScreenShot(driver, "verifyLogin");
            Assert.fail("verifyLogin - failed");
            userAccountPage.clickSignOut();
        }
        logger.info("***************TestCase Verify Login ends*****************");

    }




}
