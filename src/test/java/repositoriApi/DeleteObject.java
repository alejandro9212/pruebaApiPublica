package repositoriApi;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteObject {

    @Test
    public void deleteObject(){

            /*objeto RequestSpecification objeto que nos pemite abrir el link de la api
        apuntar a la section en específico*/
        RequestSpecification requesDelet = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects");
        Response response = requesDelet
                .when()
                .delete("/ff80818190afe51a0190b900fa250f54");



        /*La siguiente linea imprime la respuesta*/
        response.prettyPrint();
        /*me permite verificar el numero de respuesta*/
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 200);

    }
}
