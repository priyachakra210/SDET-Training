package smoketests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.swaggerPost.Category;
import pojos.swaggerPost.Root;
import pojos.swaggerPost.Tags;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SwaggerPost
{
    Root root;
    Category category;
    Tags tags;

    @Test(priority = 0)
    public void swaggerPost()
    {
        //Creating objects for Category, tags and root classes
        category = new Category();
        tags = new Tags();
        root = new Root();

        //Creating List for tags class
        tags.setName("dogpup");
        tags.setId(1);
        List<Tags> listTags = new ArrayList<>();
        listTags.add(tags);

        //Creating list for photo field
        List<String> listPhoto = new ArrayList<>();
        listPhoto.add("string");

        //Setting values for Category class
        category.setId(1);
        category.setName("doggie");

        //Setting values for Root values
        root.setTags(listTags);
        root.setCategory(category);
        root.setPhotoUrls(listPhoto);
        root.setStatus("available");
        root.setName("Pup");
        root.setId(100);



        Response response = given().
                when().
                header("Content-Type","application/json")
                .body(root)
                .post("https://petstore.swagger.io/v2/pet");

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
    }
}
