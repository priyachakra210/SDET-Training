package smoketests;

import base.DriverFactory;
import base.DriverType;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;


@CucumberOptions(features = "src/main/resources/features"
        , monochrome = true
        , plugin = { "pretty", "html:target/results" }
        , glue = { "stepDefinitions" }
        , tags= {"@datawithheader"}
        , strict = true)

public class CucumberRunner extends AbstractTestNGCucumberTests
{

}
