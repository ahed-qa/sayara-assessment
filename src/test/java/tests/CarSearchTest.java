package tests;
import org.openqa.selenium.WebDriver;
import base.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FilterPage;
import pages.HomePage;
import pages.SearchResultsPage;
import utils.ExtentReportManager;

import java.time.Duration;

public class CarSearchTest extends BaseTest {

    @Test
    public void testCarSearchWithFilters() throws InterruptedException {
        ExtentTest test = ExtentReportManager.createTest("Car Search - Toyota 2022 to 2025");
        driver.get("https://preprod.syarah.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        HomePage home = new HomePage(driver);

        home.verifyToyotaBrand();
        home.clickToyotaBrand(); // to navigate to toyota page // still there's an issue on this method

        FilterPage filter = new FilterPage(driver);
        filter.waitForPageLoad(driver);

        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        filter.clickOnYearOfManufacture(driver);
        filter.moveSliderToYear(2022);
        filter.clickOnDoneOfFilteration();
        resultsPage.verifyFilterToyotaUrl(driver);
        Assert.assertTrue(resultsPage.toyotaTextInTheResult().contains("Toyota"));
        Assert.assertTrue(resultsPage.yearOfManufactureTextInTheResult().contains("2022"));






//        Assert.assertTrue(home.areResultsFiltered(), "Filtered results not shown!");
//        ExtentReportManager.logPass("Search filters applied and results displayed.");
    }
}
