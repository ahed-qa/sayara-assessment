package base;

import com.aventstack.extentreports.MediaEntityBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ExtentReportManager;

import java.time.Duration;


    public class BaseTest {
        protected WebDriver driver; //protected to be used by child classes

        @BeforeSuite
        public void setUpSuite() {
            ExtentReportManager.startReport(); // initializes the extentReports system
        }


        @BeforeMethod
        public void setup() {
            WebDriverManager.chromedriver().setup(); //to set up the chrome driver
            driver = new ChromeDriver(); //opens new browser window before test means before each test case in the project since we have 2 different tests carSearchTest and FinancialFormTest
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }

        @AfterMethod
        public void tearDown(ITestResult result) {
            if (result.getStatus() == ITestResult.FAILURE) {
                // Take screenshot and attach to ExtentReport if the test result failed
                String screenshotPath = ExtentReportManager.captureScreenshot(driver, result.getName());
                ExtentReportManager.getTest().fail("Test Failed",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            }
            driver.quit();
        }
        public static void waitForPageToLoad(WebDriver driver, int timeoutInSeconds) {
            new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(
                    webDriver -> ((JavascriptExecutor) webDriver)
                            .executeScript("return document.readyState").equals("complete")
            ); //the wait in the baseTest to have the ability to call it in the testcase itself
        }

        @AfterSuite
        public void tearDownSuite() {
            ExtentReportManager.flushReport(); //writes the extentReport
        }


    }


