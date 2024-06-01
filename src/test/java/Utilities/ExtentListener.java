package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentListener implements ITestListener {

    ExtentSparkReporter extentSparkReporter;
    ExtentTest extentTest;
    ExtentReports extentReports;


    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));

        String screenShotPath = System.getProperty("user.dir") + "\\ScreenShots\\" + result.getName() + ".png";

        File screenShotFile = new File(screenShotPath);

        if(screenShotFile.exists())
        {
            extentTest.fail("Captured Screenshot is below:" + extentTest.addScreenCaptureFromPath(screenShotPath));

        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.AMBER));
        extentTest.skip(result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
    }

    @Override
    public void onStart(ITestContext context) {
        configReport();
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
        ITestListener.super.onFinish(context);
    }

    public void configReport() {
        ReadConfig readConfig = new ReadConfig();
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String reportName = "MyStoreReport" + timestamp + ".html";
        extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\"+reportName);
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        // system config
        extentReports.setSystemInfo("OS", "Windows");
        extentReports.setSystemInfo("Browser", readConfig.getBrowser());
        extentReports.setSystemInfo("Tester", "Harsh");
        extentReports.setSystemInfo("Environment", "QA");

        //report config
        extentSparkReporter.config().setReportName("MyStore Automation Report");
        extentSparkReporter.config().setDocumentTitle("Test Results");
        extentSparkReporter.config().setEncoding("UTF-8");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setTimeStampFormat(" EEEE, MMMM d, yyyy, hh:mm a '('zzz')'");


    }
}
