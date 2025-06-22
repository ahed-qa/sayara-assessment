package tests;

import base.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import pages.FinanceFormPage;
import utils.ExtentReportManager;
import utils.ElementUtils;



public class FinanceFormTest extends BaseTest {
    @Test
    public void testFinanceFormTests()  {
        ExtentTest test = ExtentReportManager.createTest("Finance Eligibility Form");
        driver.get("https://preprod.syarah.com/en/site/finance-eligibility");

        FinanceFormPage financeForm = new FinanceFormPage(driver);

        financeForm.firstRadioButton();
       waitForPageToLoad(driver, 10);
        financeForm.firstRadioButton();
        String path = ExtentReportManager.captureScreenshot(driver, "firstRadioButton");
        test.addScreenCaptureFromPath(path);
        financeForm.fillTotalMonthlyIncomeField(1400);
        financeForm.continueButton();
        financeForm.firstRadioButton();
        financeForm.verifyButton();
        financeForm.fillTheAmountOfCommitmentField(3000);
        financeForm.verifyNowButton();
        financeForm.createAccountField("0511111111");
        financeForm.startNowButton();
        ElementUtils.enterOTP(driver, "123456");
        financeForm.verifyNavigatingToTheCorrectURL();
        financeForm.assertIneligibleForFinancingText();

    }
}

