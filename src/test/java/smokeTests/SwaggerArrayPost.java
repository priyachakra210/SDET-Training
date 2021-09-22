package smokeTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;
import swagsPojo.User;
import swagsPojo.UsersList.RootArrayUsers;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SwaggerArrayPost {
    @Test
    public void swaggerArray(){
        User user=new User();
        user.setId(0);
        user.setFirstname("String");
        user.setLastName("String");
        user.setEmail("String");
        user.setPassword("String");
        user.setPhone("String");
        user.setUserStatus(0);
        //creating object for list
        List<User> userList=new ArrayList<>();
        userList.add(user);
        Response response=given().
                                  when().
                                  header("Content-type", "application/Json")
                .body(userList)
                .post("https://petstore.swagger.io/v2/user/createWithArray");
        System.out.println(response.getStatusCode());
        String responseBody=response.getBody().asString();
        Assert.assertEquals(response.getStatusCode(),200);





    }


    }


