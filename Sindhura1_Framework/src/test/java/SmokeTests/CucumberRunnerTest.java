package SmokeTests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        strict = true,
        features = "src/main/resources/Features/Swagger.feature",
        glue = {"stepDefinitions"},
        plugin = {"pretty", "html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json"},
        tags = {"@sanitytest"}

)


public class CucumberRunnerTest extends AbstractTestNGCucumberTests
{
}

