package steps.cucumber;

import io.cucumber.java.en.*;

public class FinanceFormSteps {

    @Given("I open the finance form")
    public void openFinanceForm() {
        System.out.println("Opened finance form (Cucumber)");
    }

    @When("I enter income {string}")
    public void enterIncome(String income) {
        System.out.println("Entered income: " + income + " (Cucumber)");
    }

    @When("I enter commitment {string}")
    public void enterCommitment(String commitment) {
        System.out.println("Entered commitment: " + commitment + " (Cucumber)");
    }

    @When("I enter phone {string}")
    public void enterPhone(String phone) {
        System.out.println("Entered phone: " + phone + " (Cucumber)");
    }

    @When("I enter OTP {string}")
    public void enterOtp(String otp) {
        System.out.println("Entered OTP: " + otp + " (Cucumber)");
    }

    @Then("I should see the ineligible page")
    public void seeIneligiblePage() {
        System.out.println("Ineligible page is displayed (Cucumber)");
    }
}
