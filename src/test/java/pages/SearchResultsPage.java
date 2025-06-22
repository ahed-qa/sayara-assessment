package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage {

    WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }


    @FindBy(xpath = "//span[contains(@title, 'تويوتا')]")
    WebElement toyotaTextInTheResult;

    @FindBy(xpath = "(//span[contains(@title, '2022 - 2025 ')])[1]")
    WebElement yearOfManufactureTextInTheResult;


    public void verifyFilterToyotaUrl(WebDriver driver) {
        String expectedUrl = "https://preprod.syarah.com/filters?make_id=4&year_from=2022&year_to=2025&page=3";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            System.out.println("URL is correct: " + actualUrl);
        } else {
            System.out.println("URL mismatch!\nExpected: " + expectedUrl + "\nActual:   " + actualUrl);
            throw new AssertionError("URL verification failed.");
        }
    }

    public String toyotaTextInTheResult() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(toyotaTextInTheResult));
        return toyotaTextInTheResult.getText();

    }

    public String yearOfManufactureTextInTheResult() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(yearOfManufactureTextInTheResult));
        return toyotaTextInTheResult.getText();
    }
}
