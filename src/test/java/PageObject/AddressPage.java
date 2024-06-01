package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressPage {

    WebDriver lDriver;

    public AddressPage(WebDriver rDriver) {
        lDriver = rDriver;
        PageFactory.initElements(rDriver, this);
    }

    @FindBy(id = "firstname")
    WebElement FIRSTNAME;

    @FindBy(id = "firstname")
    WebElement LASTNAME;

    @FindBy(id = "address1")
    WebElement ADDRESS;

    @FindBy(id = "city")
    WebElement CITY;

    @FindBy(id = "id_state")
    WebElement STATE;

    @FindBy(id = "postcode")
    WebElement ZIPECODE;

    @FindBy(id = "id_country")
    WebElement COUNTRY;

    @FindBy(id = "phone")
    WebElement PHONE;

    @FindBy(id = "phone_mobile")
    WebElement MOBILE;

    @FindBy(id = "alias")
    WebElement ADDRESSALIAS;


    @FindBy(id = "submitAddress")
    WebElement SaveAddress;


    public void enterFirstName(String firstName) {
        FIRSTNAME.clear();
        FIRSTNAME.sendKeys(firstName);
    }

    public void enterLastName(String lastname) {
        LASTNAME.clear();
        LASTNAME.sendKeys(lastname);
    }

    public void enterAddress(String address) {
        ADDRESS.sendKeys(address);
    }

    public void enterCity(String city) {
        CITY.sendKeys(city);
    }

    public void enterZipCode(String zipcode) {
        ZIPECODE.sendKeys(zipcode);
    }

    public void enterPhone(String phone) {
        PHONE.sendKeys(phone);
    }

    public void enterMobile(String mobile) {
        MOBILE.sendKeys(mobile);
    }

    public void enterAddressAlias(String addressAlias) {
        ADDRESSALIAS.sendKeys(addressAlias);
    }

    public void enterState(String state) {
        Select select = new Select(STATE);
        select.selectByVisibleText(state);
    }

    public void enterCountry(String country) {
        Select select = new Select(COUNTRY);
        select.selectByVisibleText(country);
    }

    public void clickSaveAddress() {
        SaveAddress.click();

    }


}


