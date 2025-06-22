package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // constructor

    @FindBy(xpath = "//a[contains(@href, '/autos/toyota#referral_location=Home&browse_variant=make&variant_value=toyota')]")
    WebElement ToyotaBrandButton;  //selectToyotaBrand

    public void waitTillToyotaBrandVisible() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(ToyotaBrandButton));

    }

    public void clickToyotaBrand() {
            driver.findElement(By.xpath("//a[contains(@href, '/autos/toyota#referral_location=Home&browse_variant=make&variant_value=toyota')]")).click();
        }
//        By toyotaLinkLocator = By.xpath("//a[contains(@href, '/autos/toyota')]");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Increased timeout
//
//        for (int attempt = 0; attempt < 3; attempt++) {
//            try {
//                // Refetch the element fresh in each attempt to avoid staleness
//                WebElement toyotaLink = wait.until(ExpectedConditions.presenceOfElementLocated(toyotaLinkLocator));
//                wait.until(ExpectedConditions.visibilityOf(toyotaLink));
//                wait.until(ExpectedConditions.elementToBeClickable(toyotaLink));
//
//                // Scroll into view using JS
//                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'})", toyotaLink);
//                Thread.sleep(300); // Let DOM settle
//
//                try {
//                    // First attempt: native click using Actions
//                    new Actions(driver)
//                            .moveToElement(toyotaLink)
//                            .pause(Duration.ofMillis(200))
//                            .click()
//                            .perform();
//                } catch (ElementClickInterceptedException e) {
//                    System.out.println("Click intercepted — trying JS click.");
//                    // JS fallback
//                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", toyotaLink);
//                }
//
//                // Confirm successful navigation
//                wait.until(ExpectedConditions.urlContains("/autos/toyota"));
//                return;
//
//            } catch (StaleElementReferenceException e) {
//                System.out.println("Stale element — retrying...");
//            } catch (TimeoutException e) {
//                System.out.println("Timeout — element not clickable or URL did not change.");
//            } catch (InterruptedException ignored) {
//                Thread.currentThread().interrupt(); // good practice
//            } catch (Exception e) {
//                System.out.println("Unexpected error: " + e.getMessage());
//            }
//        }
//
//        throw new RuntimeException("Failed to click on Toyota brand after 3 attempts.");
    }
 //the problem of stale elements making the click not working and i'm keeping this method to think about it
