package TestCases;

import PageObject.IndexPage;
import Utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseClass {

    ReadConfig readConfig = new ReadConfig();

    public String baseURL = readConfig.getBaseUrl();
    public String browser = readConfig.getBrowser();

    public static WebDriver driver;
    public static Logger logger;

    @BeforeClass
    public void selectBrowser() {

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:
                driver = null;
                break;
        }


        assert driver != null;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger = LogManager.getLogger("MyStore");

        driver.get(baseURL);
        logger.info("URL is opened");


    }//browser
    @BeforeMethod
    public void clickSignIn() {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickSignIn();
        logger.info("clicked on sign in");
    }

    public void captureScreenShot(WebDriver driver, String testName) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(System.getProperty("user.dir") + "\\Screenshots\\" + testName + ".png");
        FileUtils.copyFile(srcFile, destFile);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}



