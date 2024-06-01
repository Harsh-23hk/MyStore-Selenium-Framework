package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    WebDriver driver;

   public RegistrationPage(WebDriver rDriver) {
        this.driver = rDriver;
        PageFactory.initElements(rDriver, this);
    }

    @FindBy(id = "id_gender1")
    WebElement Mr;
    @FindBy(id = "id_gender2")
    WebElement Mrs;

    @FindBy(id = "customer_firstname")
    WebElement FirstName;

    @FindBy(id = "customer_lastname")
    WebElement LastName;

    @FindBy(id = "email")
    WebElement EMAIL;

    @FindBy(id = "passwd")
    WebElement Password;

    @FindBy(id="submitAccount")
    WebElement REGISTER;


    public void enterFirstName(String firstName) {
        FirstName.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        LastName.sendKeys(lastName);
    }

    public void selectMr() {
        Mr.click();
    }

    public void selectMrs() {
        Mrs.click();
    }


    public void enterEmail(String email) {
        EMAIL.clear();
        EMAIL.sendKeys(email);
    }

    public void enterPassword(String password) {
        Password.sendKeys(password);

    }

    public void clickRegister() {
        REGISTER.click();
    }
}
