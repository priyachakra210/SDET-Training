package steps;

import base.FileReaderManager;
import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class RegressApiSteps {
    Response response;
    @Given("I am in baseURI")
    public void iAmInBaseURI() throws IOException {

        FileReaderManager fileReaderManager=new FileReaderManager();
        RestAssured.baseURI=fileReaderManager.getProperty("baseURI");
    }

    @When("I passing endpoint for singleuser")
    public void iPassingEndpointForSingleuser() {
         response= given()
                .when()
                .header("Content-Type", "application/json")
                .get("https://reqres.in/api/users/2");
        String responseBody=response.getBody().asString();
        String firstname= JsonPath.read(responseBody,"$.data.first_name");
        Assert.assertEquals(firstname,"Janet");
        String url=JsonPath.read(responseBody,"$.support.url");
        Assert.assertEquals(url,"https://reqres.in/#support-heading");
        System.out.println(responseBody);

    }

    @Then("I validate the status code")
    public void iValidateTheStatusCode() {
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
