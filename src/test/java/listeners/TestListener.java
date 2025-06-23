package listeners;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.DriverFactory;
import utils.ExtentReportManager;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportManager.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.getTest().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportManager.getTest().log(Status.FAIL, "Test Failed: " + result.getThrowable());

        String path = ExtentReportManager.captureScreenshot(DriverFactory.getDriver(), result.getMethod().getMethodName());
        ExtentReportManager.getTest().addScreenCaptureFromPath(path);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.getTest().log(Status.SKIP, "Test Skipped: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.flushReport();
    }
}
