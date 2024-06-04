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

    @FindBy(xpath = "//a[@class='logout']")
    WebElement SIGN_OUT;

    @FindBy(xpath = "//span[@xpath='1']")
    WebElement ADD_ADDRESS;



    @FindBy(xpath = "//button[@class='btn btn-default button-search']")
    WebElement SearchButton;

    @FindBy(xpath = "//input[@id='search_query_top']")
    WebElement SearchBox;


    public String getUserAccount() {
        return userAccount.getText();
    }

    public void addFirstAddress() {
        ADD_ADDRESS.click();
    }

    public void clickSignOut() {
        SIGN_OUT.click();
    }

    public void clickSearchButton(){
        SearchButton.submit();
    }
    public void enterDataInSearchBox(String search){
        SearchBox.sendKeys(search);
    }
}
