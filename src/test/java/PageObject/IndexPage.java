package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

    WebDriver lDriver;

    public IndexPage(WebDriver rDriver) {
        lDriver = rDriver;
        PageFactory.initElements(rDriver, this);
    }


    @FindBy(xpath = "//a[@class='login'] ")
    WebElement signIn;


    public void clickSignIn() {
        signIn.click();
    }
}
