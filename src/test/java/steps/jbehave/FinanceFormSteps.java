package steps.jbehave;

import org.jbehave.core.annotations.*;

public class FinanceFormSteps {

    @Given("I open the finance form")
    public void openFinanceForm() {
        System.out.println("Opened finance form (JBehave)");
    }

    @When("I enter income \"$income\"")
    public void enterIncome(String income) {
        System.out.println("Entered income: " + income + " (JBehave)");
    }

    @When("I enter commitment \"$commitment\"")
    public void enterCommitment(String commitment) {
        System.out.println("Entered commitment: " + commitment + " (JBehave)");
    }

    @When("I enter phone \"$phone\"")
    public void enterPhone(String phone) {
        System.out.println("Entered phone: " + phone + " (JBehave)");
    }

    @When("I enter OTP \"$otp\"")
    public void enterOtp(String otp) {
        System.out.println("Entered OTP: " + otp + " (JBehave)");
    }

    @Then("I should see the ineligible page")
    public void seeIneligiblePage() {
        System.out.println("Ineligible page is displayed (JBehave)");
    }
}
