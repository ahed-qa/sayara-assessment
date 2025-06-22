package steps.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class CarSearchSteps {

    @Given("I open the home page of sayara website")
    public void openHomePage() {
        System.out.println("Opened home page of Sayara website");
    }

    @When("I click on toyota button")
    public void clickToyotaButton() {
        System.out.println("Clicked on Toyota button");
    }

    @When("I click on year of manufacture")
    public void clickYearOfManufacture() {
        System.out.println("Clicked on Year of Manufacture");
    }

    @When("I fill on starting from 2022")
    public void fillStartYear2022() {
        System.out.println("Selected year starting from 2022");
    }

    @Then("I click on done")
    public void clickDone() {
        System.out.println("Clicked Done");
    }
}

