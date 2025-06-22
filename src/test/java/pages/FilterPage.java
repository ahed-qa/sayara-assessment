package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FilterPage {

    WebDriver driver;

    public FilterPage(WebDriver driver) {
        this.driver = driver;
    } // constructor to initialize the page with the webDriver instance

    // in this page will put all filter page locators and logic
    @FindBy(xpath = "//div[contains(@class, 'SubFilterOpenButton-module__container')]//strong[contains(text(), 'سنة الصنع')]")
    WebElement YearOfManufactureButton;

    @FindBy(xpath = "//div[contains(@class, 'rc-slider-handle')][1]")
    WebElement sliderHandle;

    @FindBy(xpath = "//button[contains(@class, 'SubMenuContainer-module__DoneBtn')]")
    WebElement doneOfFilterationButton;


    public void clickOnYearOfManufacture(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(YearOfManufactureButton));
        YearOfManufactureButton.click(); //this method wailts till year of manufacture button appears then click
    }
/// //////////////
    public void moveSliderToYear(int targetYear) {
        int currentYear = 2025; // Update based on UI default
        int yearRange = 2025 - 2022; // Range is 3 years
        int sliderWidth = sliderHandle.getSize().getWidth(); // or estimate from total width

        // Estimate pixels per year (assumes full width of bar represents full range)
        int pixelsPerYear = 66; // You may need to tune this based on testing

        int offset = (targetYear - currentYear) * pixelsPerYear;

        Actions actions = new Actions(driver);
        actions.clickAndHold(sliderHandle)
                .moveByOffset(offset, 0)
                .release()
                .perform();
    }
    /// //////////////////////

    public void clickOnDoneOfFilteration() {
        doneOfFilterationButton.click();
    } //click on تم


/// ///////////////
    public void waitForPageLoad(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));

    }
    /// /////////////////

}



