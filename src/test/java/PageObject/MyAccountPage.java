package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    WebDriver ldriver;

    public MyAccountPage(WebDriver rdriver) {
        this.ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    //registration
    @FindBy(id = "email_create")
    WebElement create_email;

    @FindBy(id = "SubmitCreate")
    WebElement create_an_account;

    @FindBy(xpath = "//div[@id='create_account_error']/ol/li")
    WebElement CREATE_ALERT;

    //Sign in
    @FindBy(id = "email")
    WebElement login_email;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "SubmitLogin")
    WebElement sign_in;

    @FindBy(xpath = "//div[@class='alert alert-danger']/p")
    WebElement ALERT;




    public void enterCreateEmail(String email) {
        create_email.sendKeys(email);

    }

    public void clickCreateAnAccount() {
        create_an_account.click();
    }

    public void enterEmail(String email) {
        login_email.sendKeys(email);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clickSignIn() {
        sign_in.click();
    }





}
