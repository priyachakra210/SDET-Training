package stepDefinitions;

import base.DriverFactory;
import base.DriverType;
import base.baseMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.ButtonPage;
import pageObjects.TextBoxPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Steps
{
    //Calling WebDriver
    private WebDriver driver;

    //Creating TextPage object
    TextBoxPage textBoxPage;

    ButtonPage buttonPage;


    @Given("^I have open the browser$")
    public void iOpenBrowser()
    {
        driver = DriverFactory.getDriver(DriverType.CHROME);
    }


    @Given("^I am navigating to the site$")
    public void iAmNavigatingToTheURL() throws IOException {

        textBoxPage = new TextBoxPage(this.driver);
        String url = textBoxPage.getProperties("url");
        driver.get(url);
    }

    @When("^I click on textbox option$")
    public void iClickOnTextboxOption()
    {

        this.textBoxPage.clickTextButton();
        Assert.assertTrue(this.textBoxPage.isAt());
    }

    @And("^I enter all the textbox details and take screenshot as (.*)$")
    public void iEnterAllTheTextboxDetails(String screenshotName) throws InterruptedException, IOException
    {
        textBoxPage.enterDetails();
        textBoxPage.screenshot(screenshotName,this.driver);
    }

    @When("^I click on button option$")
    public void iClickOnButtonOption()
    {
        buttonPage = new ButtonPage(this.driver);
        this.buttonPage.clickButtonOption();
        Assert.assertTrue(this.buttonPage.isAt());
    }

    @And("^I click button options and take screenshot as (.*)$")
    public void clickingButtonOptions(String screenshotName) throws InterruptedException, IOException {
        buttonPage.clickingButtons();
        buttonPage.screenshot(screenshotName,this.driver);
    }

    @Then("^I quit the application$")
    public void iQuitTheApplication()
    {
        this.driver.close();
    }

    @And("I am navigating to the application")
    public void iAmNavigatingToTheApplication(DataTable dataTable)
    {
        List<String> tbl = dataTable.asList();
        String URL = tbl.get(0);
        driver.get(URL);
    }

    @And("I am navigating to the application with headers")
    public void iAmNavigatingToTheApplicationWithHeaders(DataTable dataTable)
    {
        List<Map<String, String>> listTbl = dataTable.asMaps();

        for(Map<String, String> valuetbl: listTbl)
        {
            String URL = valuetbl.get("URL");
            driver.get(URL);
        }
    }
}
