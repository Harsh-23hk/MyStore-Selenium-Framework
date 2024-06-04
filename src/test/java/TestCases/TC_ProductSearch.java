package TestCases;

import PageObject.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class TC_ProductSearch extends BaseClass {

     @Test
    public void verifySearchProduct() throws IOException{
        String searchProduct = "Dress";
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.enterEmail(emailAddress);
        myAccountPage.enterPassword(password);
        myAccountPage.clickSignIn();
        UserAccountPage userAccountPage = new UserAccountPage(driver);

        userAccountPage.enterDataInSearchBox(searchProduct);
        logger.info("SearchTest started");
        userAccountPage.clickSearchButton();
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        String productName = searchResultPage.getSearchResultProductName();


        if (productName.contains(searchProduct)) {
            logger.info("SearchTest passed");
            Assert.assertTrue(true);
            userAccountPage.clickSignOut();

        } else {
            logger.info("SearchTest failed");
            captureScreenShot(driver, "SearchTest");
            Assert.fail();
        }

    }

    @Test
    public void verifyOrder() throws IOException, InterruptedException {
        String searchProduct = "Blouse";
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.enterEmail(emailAddress);
        myAccountPage.enterPassword(password);
        myAccountPage.clickSignIn();
        UserAccountPage userAccountPage = new UserAccountPage(driver);

        userAccountPage.enterDataInSearchBox(searchProduct);
        logger.info("SearchTest started");
        userAccountPage.clickSearchButton();
        logger.info("Clicked on search button");
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.clickMore();
        logger.info("Clicked on more");

        ProductPage productPage = new ProductPage(driver);
        productPage.selectSize("M");
        logger.info("Selected size");
        productPage.selectColorWhite();
        logger.info("Selected color");
        productPage.selectQuantity("2");
        logger.info("Selected quantity");
        productPage.clickAddToCart();
        logger.info("Clicked on add to cart");
        productPage.clickProceedToCheckout();
        logger.info("Clicked on proceed to checkout");

        OrderSummaryPage orderSummaryPage = new OrderSummaryPage(driver);
        orderSummaryPage.clickProceedToCheckout();
        logger.info("Clicked on proceed to checkout");

        OrderAddressPage orderAddressPage = new OrderAddressPage(driver);
        orderAddressPage.clickProceedToCheckout();
        logger.info("Clicked on proceed to checkout");

        OrderShippingPage orderShippingPage = new OrderShippingPage(driver);
        orderShippingPage.clickTermOfServices();
        logger.info("Clicked on term of services");
        orderShippingPage.clickProceedToCheckout();
        logger.info("Clicked on proceed to checkout");

        OrderPaymentPage orderPaymentPage = new OrderPaymentPage(driver);
       orderPaymentPage.clickPayByCheck();
        logger.info("Clicked on pay by check");

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        orderConfirmationPage.clickConfirmOrder();
        logger.info("Clicked on confirm order");

        String successMessage = orderConfirmationPage.getSuccessMessage();
        if (successMessage.contains("Your order on My Shop is complete.")) {
            logger.info("OrderTest passed");
            Assert.assertTrue(true);
            orderConfirmationPage.clickSignOut();
        } else {
            logger.info("OrderTest failed");
            captureScreenShot(driver, "OrderTest");
            Assert.fail("OrderTest failed: success message does not contain expected message");
        }





    }


}

