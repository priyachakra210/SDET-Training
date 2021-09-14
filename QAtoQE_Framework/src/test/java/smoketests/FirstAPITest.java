package smoketests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class FirstAPITest
{
    @Test (priority = 0)
    public void getCall()
    {
        Response response = given().
                            when().
                            header("Content-Type","application/json")
                            .get("https://reqres.in/api/users/2");

        Assert.assertEquals(response.statusCode(),200);


//        String responseBody = response.getBody().asString();
//
//        System.out.println(responseBody);

    }


    @Test (priority = 1)
    public void postCall()
    {
       Response response = given().
                            when().
                            header("Content-Type","application/json").
                            body("{\n" +
                                    "    \"name\": \"morpheus\",\n" +
                                    "    \"job\": \"leader\"\n" +
                                    "}").
                            post("https://reqres.in/api/users");

        Assert.assertEquals(response.statusCode(),201);

        //String responseBody = response.getBody().asString();

        //System.out.println(responseBody);

    }

    @Test (priority = 2)
    public void putCall()
    {
        Response response = given().
                when().
                header("Content-Type","application/json").
                body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}").
                put("https://reqres.in/api/users/2");

        //String responseBody = response.getBody().asString();

        //System.out.println("Status code of the API call: "+response.getStatusCode());

        Assert.assertEquals(response.getStatusCode(),200);

       // System.out.println(responseBody);

    }


    @Test (priority = 3)
    public void deleteCall()
    {
        Response response = given().
                when().
                header("Content-Type","application/json").
                delete("https://reqres.in/api/users/2");


        System.out.println("Status code of the API call: "+response.getStatusCode());

        Assert.assertEquals(response.getStatusCode(),204);


    }


}
