package smokeTests;

import base.BaseAPI;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.PostPojo;

import static io.restassured.RestAssured.given;

public class FirstAPITest extends BaseAPI {
    PostPojo postPojo;
    @Test
    public void getCall() {
        Response response= given()
                .when()
                .header("Content-Type", "application/json")
                .get("https://reqres.in/api/users/2");
        String responseBody=response.getBody().asString();
        String firstname=JsonPath.read(responseBody,"$.data.first_name");
        Assert.assertEquals(firstname,"Janet");
        String url=JsonPath.read(responseBody,"$.support.url");
        Assert.assertEquals(url,"https://reqres.in/#support-heading");
        System.out.println(responseBody);
    }
    @Test
    public void postCall(){
        postPojo=new PostPojo();
        Response response = given().
                            when().
                            header("Content-Type" , "application/json").
                            body("{\n" +
                                    "    \"name\": \"morpheus\",\n" +
                                    "    \"job\": \"leader\"\n" +"}\n").
                            post("/api/users");
        postPojo.setName("morpheus");
        postPojo.setJob( "leader");
        System.out.println(postPojo.getName());
        System.out.println(postPojo.getJob());
        String postResponse=response.getBody().asString();
        System.out.println(postResponse);
        String nameValue= JsonPath.read(postResponse,"name");
        Assert .assertEquals( nameValue,"morpheus");
        System.out.println(response.getStatusCode());
    }
    @Test
    public void  putCall(){
        Response response=given().
                           when().
                headers("Content-Type" , "application/json").
                body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}\n").
                        put("/api/users");
                   String putResponse=response.getBody().asString();
           System.out.println(putResponse);
           Assert.assertEquals(response.getStatusCode(),200);
           System.out.println(response.getStatusCode());

    }
@Test
    public void delete(){
    Response response= given()
            .when()
            .header("Content-Type", "application/json")
            .delete("/api/users/2");
    String responseBody=response.getBody().asString();
    System.out.println(responseBody);
    Assert.assertEquals(response.getStatusCode(),204);
    System.out.println(response.getStatusCode());
}





}
