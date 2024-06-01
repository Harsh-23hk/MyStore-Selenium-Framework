package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAccountPage {

    WebDriver lDriver;

    public UserAccountPage(WebDriver rDriver) {
        lDriver = rDriver;
        PageFactory.initElements(rDriver, this);
    }

    @FindBy(xpath = "//a[@title='View my customer account']")
    WebElement userAccount;

    @FindBy(className = "logout")
    WebElement SIGN_OUT;

    @FindBy(xpath = "//a[@title='Add my first address']")
    WebElement ADD_ADDRESS;




    public String getUserAccount() {
        return userAccount.getText();
    }

    public void addFirstAddress() {
        ADD_ADDRESS.click();
    }

    public void clickSignOut() {
        SIGN_OUT.click();
    }
}
