package smokeTests;

import base.FileReaderManager;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import jdk.jfr.ContentType;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import swagsPojo.Category;
import swagsPojo.UsersList.Pet;
import swagsPojo.UsersList.Tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PetAPITest {
    long petId;
    Pet root;
    Category category;
    Tags tags;
    FileReaderManager fileReaderManager;
    @BeforeTest
    public void base() throws IOException {
        fileReaderManager = new FileReaderManager();
        RestAssured.baseURI = fileReaderManager.getProperty("baseSwagUrI");
    }
 @Test(priority = 0)
    public void swaggerPost(){
        //creating object for category
     category=new Category();
     category.setName("puppy");
     category.setId(0);
     //creating list  for tags
     tags = new Tags();
     tags.setId(0);
     tags.setName("doggie");
     List<Tags> tagsList=new ArrayList<>();
     tagsList.add(tags);
     //creating list for photofeild
     List<String> listPhoto=new ArrayList<>();
     listPhoto.add("String");
          //crating object for root
     root= new Pet();
     root.setCategory(category);
     root.setTagsList(tagsList);
     root.setPhotoUrllist(listPhoto);
     root.setId(0);
     root.setName("doggie");
     root.setStatus("available");

     Response response= given()
             .when()
             .header("Content-Type", "application/json")
             .body(root)
             .post("/pet");
     System.out.println(response.getStatusCode());
     Assert.assertEquals(response.getStatusCode(),200);
     String responseBody=response.getBody().asString();
     System.out.println(responseBody);
      petId= JsonPath.read(responseBody,"$.id");

 }


    @Test(priority = 1)
    public void swaggerPost1(){
        Response response=given()
                .when()
                .header("Content-type","application/json")
                .body("$.id")
                .pathParam("petId", petId)
                .post("https://petstore.swagger.io/v2/pet/{petId}}\n");
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200);
        String responseBody=response.getBody().asString();
        System.out.println(responseBody);

    }




}
