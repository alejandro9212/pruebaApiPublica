package repositoriApi;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class PutObject {

    @Test
    public void updateObject(){


        File putBody = new File("D:\\java_2023\\Automatizacion_api_v1\\src\\main\\resources\\json\\updatePut.json");

        RequestSpecification requestPut = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .header("Content-Type","application/json")
                .body(putBody);

        Response responsePut = requestPut
                .when()
                .put("ff80818190afe51a0190b900fa250f54");

        responsePut.prettyPrint();
        int statusCode = responsePut.getStatusCode();
        Assert.assertEquals(statusCode, 200);

    }
}
