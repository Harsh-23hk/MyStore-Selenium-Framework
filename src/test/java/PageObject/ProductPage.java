package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "quantity_wanted")
    WebElement Quantity;

    @FindBy(id = "group_1")
    WebElement size;

    @FindBy(id = "color_11")
    WebElement Color;

    @FindBy(id = "color_8")
    WebElement ColorWhite;

    @FindBy(xpath ="//h5[@itemprop='name']")
    WebElement ProductName;

    @FindBy(name="Submit")
    WebElement AddToCart;

    @FindBy(linkText = "Proceed to checkout")
    WebElement ProceedToCheckout;

    @FindBy(xpath="//a[@class='addToWishlist wishlistProd_1']")
    WebElement addToWishList;


    @FindBy(xpath="//p[@class='fancybox-error']")
    WebElement alertForAddToWishList;


    public void clickAddToCart() {
        AddToCart.click();
    }

    public void selectQuantity(String quantity) {
        Quantity.clear();
        Quantity.sendKeys(quantity);
    }

    public void selectSize(String sizeType) {
        Select select = new Select(size);
        select.selectByVisibleText(sizeType);
        this.size.click();
    }


    public void selectColor(String color) {
        this.Color.click();
    }

    public void selectColorWhite() {
        this.ColorWhite.click();
    }

    public void clickProceedToCheckout() {
        ProceedToCheckout.click();
    }


    public String getProductName() {
        return ProductName.getText();
    }

    public void moveOverOneProduct() {
        Actions actions = new Actions(driver);
        actions.moveToElement(ProductName).build().perform();
    }

    public void clickOnWishList() {
        addToWishList.click();
    }

    public String getAlertForAddToWishList() {
        return alertForAddToWishList.getText();
    }

}
