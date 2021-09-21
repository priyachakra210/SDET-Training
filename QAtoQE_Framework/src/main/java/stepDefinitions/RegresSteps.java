package stepDefinitions;

import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import pojos.PostPojo;

import static io.restassured.RestAssured.given;

public class RegresSteps
{

    Response response;
    PostPojo postPojo;

    @Given("I am baseURI of the regres application")
    public void iAmBaseURIOfTheApplication()
    {
        RestAssured.baseURI = "https://reqres.in";
    }

    @When("I passing endpoints for single user")
    public void iPassingEndpointsForSingleUser()
    {
        response =  given()
                    .when()
                    .header("Content-Type","application/json")
                    .get("/api/users/2");

    }

    @Then("^I validate the Status code as (.*)$")
    public void iValidateTheStatusCode(int exp_statusCode)
    {
        Assert.assertEquals(response.statusCode(),exp_statusCode);
    }

    @And("^I validate the email as (.*)$")
    public void iValidateTheEmailAsJanetWeaverReqresIn(String expected_emailValue)
    {
        String responseBody = response.getBody().asString();
        String actual_emailValue = JsonPath.read(responseBody,"$.data.email");
        Assert.assertEquals(actual_emailValue,expected_emailValue);

    }

    @When("I passing endpoints for create user")
    public void iPassingEndpointsForCreateUser()
    {
        postPojo = new PostPojo();

        postPojo.setName("morpheus");
        postPojo.setJob("zion resident");

        response =  given()
                   .when()
                   .header("Content-Type","application/json")
                   .body(postPojo)
                   .post("/api/users");
    }

    @And("^I validate the name as (.*)$")
    public void iValidateTheNameAsMorpheus(String expectedName)
    {
        String responseBody = response.getBody().asString();

        String nameValue = JsonPath.read(responseBody,"$.name");
        Assert.assertEquals(nameValue,expectedName);
    }
}
