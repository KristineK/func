package helpers;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static helpers.Driver.getDriver;

public class TestListener implements ITestListener {
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return (byte[]) ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String savetextLog(String message) {
        return message;
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        saveScreenshot(getDriver());
        savetextLog(getTestMethodName(iTestResult) + " failed.");
        getDriver().manage().deleteAllCookies();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        getDriver().manage().deleteAllCookies();

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        getDriver().manage().deleteAllCookies();

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        getDriver().manage().deleteAllCookies();
    }
}
