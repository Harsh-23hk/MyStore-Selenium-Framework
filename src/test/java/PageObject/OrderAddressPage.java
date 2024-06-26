package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderAddressPage {
    WebDriver driver;

    public OrderAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name="processAddress")
    WebElement ProceedToCheckout;

    public void clickProceedToCheckout() {
        ProceedToCheckout.click();
    }
}
