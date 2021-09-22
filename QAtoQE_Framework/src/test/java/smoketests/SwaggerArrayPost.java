package smoketests;

import com.github.javafaker.Faker;
import io.cucumber.java.bs.A;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.swaggerArrayPost.ArrRoot;
import pojos.swaggerArrayPost.Parameters;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SwaggerArrayPost
{
    ArrRoot arrRoot;
    Parameters parameters;
    Faker faker;

    @Test(priority = 0)
    public void swaggerarrPost()
    {
        //Create objects for ArrRoot and Parameters class
        arrRoot = new ArrRoot();
        parameters = new Parameters();
        faker = new Faker();

        parameters.setId(0);
        parameters.setUsername(faker.name().username());
        parameters.setEmail(faker.internet().emailAddress());
        parameters.setFirstName(faker.name().firstName());
        parameters.setLastName(faker.name().lastName());
        parameters.setPassword(faker.internet().password());
        parameters.setPhone(faker.phoneNumber().phoneNumber());
        parameters.setUserStatus(0);

        List<Parameters> parametersList = new ArrayList<>();
        parametersList.add(parameters);

        arrRoot.setParametersList(parametersList);

        Response response = given().
                when().
                header("Content-Type","application/json")
                .body(arrRoot.getParametersList())
                .post("https://petstore.swagger.io/v2/user/createWithArray");

        String responseBody = response.getBody().asString();

        System.out.println(responseBody);

    }
}
