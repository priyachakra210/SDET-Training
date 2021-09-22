package gmail_smoketest;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;


import static io.restassured.RestAssured.given;

public class GmailAPITesting {
    String token="Bearer ya29.a0ARrdaM_Iajv6kb8gulbRMDrFi9dfrXRRpLHrXK0iz9SVe9n4aHZ6KSctEU6nWCyb3I9tQKunFWuBLb3lFJO8-F8PJ4Y_m-cqPUqFc72dpbJvgVOHXDXkhWXgaYyUmtKdUZcs8iFhnMdAsUFKxMW02IfZp7Xv";
    @Test()
   public void getProfile(){
        Response response = given()
                .when()
                .header("Authourisation",token)
                .get("https://gmail.googleapis.com/gmail/v1/users/ravuripriya123@gmail.com/profile");
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200);
        String responsebody =response.getBody().asString();
    }
    @Test
    public void sendingmail(){
        Response response = given()
                .when()
                .header("Authourisation",token)
                .body("{\n" +
                        "raw: \"ZnJvbTogcmF2dXJpcHJpeWExMjNAZ21haWwuY29tCnRvOnJhdnVyaXByaXlhMTIzQGdtYWlsLmNvbQpzdWJqZWN0OiByZWdhcmRpbmcgdGVzdG1haWwKSSBhbSBzZW5kaW5nIGEgbWFpbAo=\"\n" +
                        "}")
                .post("https://gmail.googleapis.com/gmail/v1/users/ravuripriya123@gmail.com/messages/send");
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200);
        String responsebody =response.getBody().asString();

    }
    @Test
    public void getMail(){
        Response response = given()
                .when()
                .header("Authourisation",token)
                .get("https://gmail.googleapis.com/gmail/v1/users/ravuripriya123@gmail.com/messages/17c01aeeeba4eada\n" +
                        "\n");
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200);
        String responsebody =response.getBody().asString();
    }

@Test
    public void trashingMail(){
    Response response = given()
            .when()
            .header("Authourisation",token)
            .post("https://gmail.googleapis.com/gmail/v1/users/ravuripriya123@gmail.com/messages/17c01aeeeba4eada/trash");
    System.out.println(response.getStatusCode());
    Assert.assertEquals(response.getStatusCode(),200);
    String responsebody =response.getBody().asString();

}
@Test
    public void untrashMail(){
    Response response = given()
            .when()
            .header("Authourisation",token)
            .post("https://gmail.googleapis.com/gmail/v1/users/ravuripriya123@gmail.com/messages/17c01aeeeba4eada/untrash\n" +
                    "\n");
    System.out.println(response.getStatusCode());
    Assert.assertEquals(response.getStatusCode(),200);
    String responsebody =response.getBody().asString();
}

}
