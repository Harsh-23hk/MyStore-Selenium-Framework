package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderShippingPage {

    WebDriver driver;

    public OrderShippingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="cgv")
    WebElement termOfServices;

    @FindBy(name="processCarrier")
    WebElement ProceedToCheckout;

    public void clickTermOfServices() {
        termOfServices.click();
    }
    public void clickProceedToCheckout() {
        ProceedToCheckout.click();
    }
}
