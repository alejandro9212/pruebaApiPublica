package repositoriApi;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class PatchObjectUptade {

    @Test
    public void patchObject(){

        File patchBody = new File("D:\\java_2023\\Automatizacion_api_v1\\src\\main\\resources\\json\\updatePatch.json");

        RequestSpecification requestPatch = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .header("Content-Type","application/json")
                .body(patchBody);

        Response responsePatch = requestPatch
                .when()
                .patch("/ff80818190afe51a0190b900fa250f54");

        responsePatch.prettyPrint();
        int statusCode = responsePatch.getStatusCode();
        Assert.assertEquals(statusCode, 200);


        }

    }

