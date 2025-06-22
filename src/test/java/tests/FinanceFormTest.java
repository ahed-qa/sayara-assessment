package tests;

import base.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.FinanceFormPage;
import utils.ExtentReportManager;
import java.time.Duration;
import utils.ElementUtils;



public class FinanceFormTest extends BaseTest {
    @Test
    public void testFinanceFormTests() throws InterruptedException {
        ExtentTest test = ExtentReportManager.createTest("Finance Eligibility Form");
        driver.get("https://preprod.syarah.com/en/site/finance-eligibility");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        FinanceFormPage financeForm = new FinanceFormPage(driver);

        financeForm.firstRadioButton();
       waitForPageToLoad(driver, 10);
        financeForm.firstRadioButton();
        waitForPageToLoad(driver, 10);
        financeForm.fillTotalMonthlyIncomeField(1400);
        financeForm.continueButton();
        financeForm.firstRadioButton();
        financeForm.verifyButton();
        financeForm.fillTheAmountOfCommitmentField(3000);
        financeForm.verifyNowButton();
        financeForm.createAccountField(0511111111);
        financeForm.startNowButton();
        ElementUtils.enterOTP(driver, "123456");
        financeForm.verifyNavigatingToTheCorrectURL();

    }
}

