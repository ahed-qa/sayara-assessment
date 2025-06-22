package steps.jbehave;

import org.jbehave.core.annotations.*;

public class CarSearchSteps {

    @Given("I open the home page of sayara website")
    public void openHomePage() {
        System.out.println("Opened home page (JBehave)");
    }

    @When("I click on toyota button")
    public void clickToyotaButton() {
        System.out.println("Clicked Toyota button (JBehave)");
    }

    @When("I click on year of manufacture")
    public void clickYearOfManufacture() {
        System.out.println("Clicked Year of Manufacture (JBehave)");
    }

    @When("I fill on starting from 2022")
    public void fillStartingFrom() {
        System.out.println("Selected starting year 2022 (JBehave)");
    }

    @Then("I click on done")
    public void clickDone() {
        System.out.println("Clicked Done (JBehave)");
    }
}
