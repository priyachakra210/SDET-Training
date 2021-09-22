package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.ButtonsPage;
import pageObject.TextBoxPage;

import java.io.IOException;

public class MyStepdefs {
    WebDriver driver;
    TextBoxPage page;
    ButtonsPage buttonsPage;

    @Given("^I am navigatting to the (.*)$")
    public void iAmNavigattingTothetextbox(String URI) throws IOException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\chakr\\IdeaProjects\\QA_to_QE" +
                "\\src\\main\\resources\\chromedriver.exe");
         driver = new ChromeDriver();
         page = new TextBoxPage(driver);

        driver.get(page.getProperty("URI"));
    }

    @When("i clicking on the textbox element")
    public void ClickingOnTheTextboxElement() {
        page.clickTextButton();
    }

    @And("I entered the all the details of textbox page")
    public void iEnteredTheAiiTheDetailsOfTextboxPage() {
        page.enterDetails();
    }

    @Then("I cilick on the submmit button")
    public void iCilickOnTheSubmmitButton() {
        page.clickSubmit();
    }

    @Then("I close the Browser")
    public void iCloseTheBrowser()
    {
        driver.close();
    }


    @And("I click on the Buttons option")
    public void iClickOnTheButtonsOption() {
        buttonsPage =new ButtonsPage(driver);
        buttonsPage.clickingButton();
    }

    @Then("I See three buttons page")
    public void iSeeThreeButtonsPage() {
        buttonsPage.isat();
    }

    @And("I click on the double click me button")
    public void iClickOnTheDoubleClickMeButton() {
        buttonsPage.DoubleClick();
    }

   // @Then("I get the text update {string}")
    public void iGetTheTextUpdate(String arg0) {

    }
    @And("I click on the Right click me button")
    public void iClickOnTheRightClickMeButton() {
        buttonsPage.RightClick();

    }

    @And("I click on Click me button")
    public void iClickOnClickMeButton() {
    buttonsPage.clickme();
    }

    @Then("I close the Window")
    public void iCloseTheWindow() {
        buttonsPage.closethewindow();
    }


}
