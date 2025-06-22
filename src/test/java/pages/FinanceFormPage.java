package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;

public class FinanceFormPage {
    WebDriver driver;

    public FinanceFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ("//input[contains(@type,'text')]"))
    WebElement totalMonthlyIncomeField;

    @FindBy(xpath = ("(//button[contains(@type,'button') and contains(text(),'Continue')])[1]"))
    WebElement continueButton;

    @FindBy(xpath = ("(//button[contains(@type,'button') and contains(text(),'Verify')])[1]"))
    WebElement verifyButton;

    @FindBy(xpath = ("//input[contains(@type,'text')]"))
    WebElement fillTheAmountOfCommitmentField;

    @FindBy(xpath = ("(//button[contains(@type,'button') and contains(text(),'Verify Now')])[1]"))
    WebElement verifyNowButton;

    @FindBy(xpath = ("(//input[contains(@class,'InputPhoneNumber')])"))
    WebElement createAccountField;

    @FindBy(xpath = ("(//button[contains(@type,'submit')])"))
    WebElement startNowButton;

    @FindBy(xpath = ("//h2[contains(text(),'You may not be eligible for financing')]"))
    WebElement youMayNotBeEligibleForFinancingText;


    public void firstRadioButton() {
        WebElement radio = driver.findElement(By.xpath("(//input[contains(@type,'radio')])[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radio); //i had to try to click using javaScript because normal click didn't work out

    }// this method to clcik on the first radio button

    public void fillTotalMonthlyIncomeField(int income) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(totalMonthlyIncomeField));
        totalMonthlyIncomeField.clear();
        totalMonthlyIncomeField.sendKeys(String.valueOf(income));
    } //this method to fill the total monthly income field

    public void continueButton() {
        continueButton.click();
    }

    public void verifyButton() {
        verifyButton.click();
    }

    public void fillTheAmountOfCommitmentField(int income) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(fillTheAmountOfCommitmentField));
        fillTheAmountOfCommitmentField.clear();
        fillTheAmountOfCommitmentField.sendKeys(String.valueOf(income));
    }
    public void verifyNowButton() {
        verifyNowButton.click();
    }

    public void createAccountField(String income) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(createAccountField));
        createAccountField.clear();
        createAccountField.sendKeys(String.valueOf(income));
    }

    public void startNowButton() {
        startNowButton.click();
    }

public void verifyNavigatingToTheCorrectURL(){
    Assert.assertEquals(driver.getCurrentUrl(), "https://preprod.syarah.com/en/site/finance-eligibility/disqualified");

}

    public void assertIneligibleForFinancingText() {
        String expectedText = "You may not be eligible for financing";
        String actualText = youMayNotBeEligibleForFinancingText.getText().trim();
        Assert.assertEquals(actualText, expectedText, "The financing eligibility message does not match.");
    }

}


