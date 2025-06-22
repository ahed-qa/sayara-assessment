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

    @FindBy(xpath = "//button[contains(@class, 'SubMenuContainer-module__DoneBtn')]")
    WebElement doneOfFilterationButton;

    @FindBy(xpath = "//input[contains(@type, 'text') and contains(@name, 'min')]")
    WebElement minManufacturerYear;

    @FindBy(xpath = "//input[contains(@type, 'text') and contains(@name, 'max')]")
    WebElement maxManufacturerYear;



    public void clickOnYearOfManufacture(WebDriver driver) {
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(YearOfManufactureButton));
        YearOfManufactureButton.click(); //this method wailts till year of manufacture button appears then click
    }

    public void fillManufactorMinYear(int year) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(minManufacturerYear));
        minManufacturerYear.clear();
        minManufacturerYear.sendKeys(String.valueOf(year));
    }

    public void fillManufactorMaxYear(int year) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(maxManufacturerYear));
        maxManufacturerYear.clear();
        maxManufacturerYear.sendKeys(String.valueOf(year));
    }


    public void clickOnDoneOfFilteration() {
        doneOfFilterationButton.click();
    } //click on تم



    public void waitForPageLoad(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));

    }


}



