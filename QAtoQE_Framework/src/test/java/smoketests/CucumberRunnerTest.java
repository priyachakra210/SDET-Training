package smoketests;

import base.DriverFactory;
import base.DriverType;
import base.FileReaderManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;


@CucumberOptions(features = "src/main/resources/features"
        , monochrome = true
//         plugin = { "pretty", "html:target/results" }
        ,plugin= {"pretty","html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json"}
        , glue = { "stepDefinitions" }
        , tags= {"@smokeapi"}
        , strict = true)

public class CucumberRunnerTest extends AbstractTestNGCucumberTests
{

}
