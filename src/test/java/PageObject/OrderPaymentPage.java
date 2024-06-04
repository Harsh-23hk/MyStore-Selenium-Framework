package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPaymentPage {

    WebDriver driver;
    public OrderPaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "cheque")
    WebElement PayByCheck;

    public void clickPayByCheck() {
        PayByCheck.click();
    }

    @FindBy(className = "bankwire")
    WebElement PayByBankWire;

    public void clickPayByBankWire() {
        PayByBankWire.click();
    }

}
