package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
    WebDriver driver;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='I confirm my order']")
    WebElement ConfirmOrder;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    WebElement SuccessMessage;
    @FindBy(xpath = "//a[@title='Log me out']")
    WebElement signOut;

    public void clickConfirmOrder() {
        ConfirmOrder.click();
    }

    public String getSuccessMessage() {
        return SuccessMessage.getText();
    }

    public void clickSignOut() {
        signOut.click();
    }
}
