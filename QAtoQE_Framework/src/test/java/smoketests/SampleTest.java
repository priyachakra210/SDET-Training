//package smoketests;
//
//import com.jayway.jsonpath.JsonPath;
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//
//import static io.restassured.RestAssured.given;
//
//public class SampleTest
//{
//    public static void main(String[] args) {
//        RestAssured.baseURI = "https://reqres.in";
//        Response response = given().
//                when().
//                header("Content-Type","application/json").
//                get("/api/users?page=2");
//
//        String responseBody = response.getBody().asString();
//
//        System.out.println(responseBody);
//
//        int nameValue = JsonPath.read(responseBody, "$.data[1].id");
//
////        String email = JsonPath.read(responseBody, "$.data.id");
//
//        System.out.println(nameValue);
//    }
//}
