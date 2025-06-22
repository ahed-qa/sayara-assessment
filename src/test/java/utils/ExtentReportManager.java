package utils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static void startReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    public static ExtentTest createTest(String name) {
        if (extent == null) {
            startReport(); // Initialize if not already done
        }
        test = extent.createTest(name);
        return test;
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static void logPass(String message) {
        if (test != null) {
            test.pass(message);
        }
    }

    public static void logFail(String message) {
        if (test != null) {
            test.fail(message);
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
            File dest = new File(path);
            Files.copy(src.toPath(), dest.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }

}
