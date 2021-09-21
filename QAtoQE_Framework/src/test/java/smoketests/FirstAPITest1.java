package smoketests;

import base.baseAPI;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.PostPojo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class FirstAPITest1 extends baseAPI
{
    PostPojo postPojo;

    @Test (priority = 0)
    public void getCallSingleUser()
    {
        Response response = given().
                            when().
                            header("Content-Type","application/json")
                            .get("/api/users/2");

        Assert.assertEquals(response.statusCode(),200);


        String responseBody = response.getBody().asString();

        String emailValue = JsonPath.read(responseBody,"$.data.email");
        String supportURL = JsonPath.read(responseBody,"$.support.url");

        Assert.assertEquals(emailValue,"janet.weaver@reqres.in");
        Assert.assertEquals(supportURL,"https://reqres.in/#support-heading");

    }


    @Test (priority = 1)
    public void postCall()
    {
        postPojo = new PostPojo();

        postPojo.setName("morpheus");
        postPojo.setJob("zion resident");

        System.out.println(postPojo.getName());

       Response response = given().
                            when().
                            header("Content-Type","application/json").
                            body(postPojo).
                            post("/api/users");

        Assert.assertEquals(response.statusCode(),201);

        String responseBody = response.getBody().asString();

        String nameValue = JsonPath.read(responseBody,"$.name");

        Assert.assertEquals(nameValue,"morpheus");


    }

    @Test (priority = 2)
    public void putCall()
    {
        Map<String,String> bodyParam = new HashMap<>();
        bodyParam.put("name","morpheus");
        bodyParam.put("job","zion resident");


        Response response = given().
                when().
                header("Content-Type","application/json").
                body(bodyParam).
                put("/api/users/2");

        String responseBody = response.getBody().asString();

        System.out.println("Status code of the API call: "+response.getStatusCode());

        Assert.assertEquals(response.getStatusCode(),200);

        System.out.println(responseBody);

    }


    @Test (priority = 3)
    public void deleteCall()
    {
        Response response = given().
                when().
                header("Content-Type","application/json").
                delete("/api/users/2");


        System.out.println("Status code of the API call: "+response.getStatusCode());

        Assert.assertEquals(response.getStatusCode(),204);


    }


}
