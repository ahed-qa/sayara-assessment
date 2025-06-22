package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementUtils {

    public static void enterOTP(WebDriver driver, String otp) {
        // Wait for all 6 OTP input fields to be visible
        List<WebElement> otpInputs = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("input[type='tel']"), 5));

        // Validate length
        if (otp.length() != otpInputs.size()) {
            throw new IllegalArgumentException("OTP length doesn't match number of input fields.");
        }

        // Send each digit to each input
        for (int i = 0; i < otpInputs.size(); i++) {
            otpInputs.get(i).clear();         // Clear if needed
            otpInputs.get(i).sendKeys(Character.toString(otp.charAt(i)));
        }
    }


}
