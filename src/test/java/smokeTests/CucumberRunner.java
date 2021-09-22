package smokeTests;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src/main/resources/features",
        monochrome = true,
        plugin = {"pretty","html:target/results/site/cucumber-pretty", "json:target/cucumber/cucumber.json"},
        glue  ={"steps"},
        tags = {"@ApiTesting","@SmokeTest"},
        strict = true)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}