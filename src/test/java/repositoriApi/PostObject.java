package repositoriApi;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class PostObject {

    @Test
    public void postNewObject(){

        File postBody = new File("D:\\java_2023\\Automatizacion_api_v1\\src\\main\\resources\\json\\createPost.json");

        RequestSpecification requestPost = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .header("Content-Type","application/json")
                .body(postBody);

        Response responsePost = requestPost
                .when()
                .post();

                responsePost.prettyPrint();
                int statusCode = responsePost.getStatusCode();
        Assert.assertEquals(statusCode, 200);

    }
}
