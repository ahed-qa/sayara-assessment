package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static void startReport() {
        if (extent == null) {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport_" + timestamp + ".html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
    }

    public static ExtentTest createTest(String name) {
        startReport(); // Safe to call multiple times
        ExtentTest extentTest = extent.createTest(name);
        test.set(extentTest);
        return extentTest;
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void logPass(String message) {
        if (getTest() != null) {
            getTest().pass(message);
        }
    }

    public static void logFail(String message) {
        if (getTest() != null) {
            getTest().fail(message);
        }
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }

    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "test-output/screenshots/" + screenshotName + ".png";

        try {
            Files.createDirectories(Paths.get("test-output/screenshots"));
            Files.copy(src.toPath(), Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}
