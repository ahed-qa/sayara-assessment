package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features", // path to feature file
        glue = "steps.cucumber", // package where your CarSearchSteps is located
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class CucumberCarSearchRunner extends AbstractTestNGCucumberTests {
}
