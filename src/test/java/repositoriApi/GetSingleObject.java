package repositoriApi;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetSingleObject {

    @Test
   public void singleObject (){
       /*objeto RequestSpecification objeto que nos pemite abrir el link de la api
        apuntar a la section en específico*/
       RequestSpecification requesGet = given()
               .baseUri("https://api.restful-api.dev")
               .basePath("/objects");
       Response response = requesGet
               .when()
               .get("/ff80818190afe51a0190bbea45d318d6");



       /*La siguiente linea imprime la respuesta*/
       response.prettyPrint();
       /*me permite verificar el numero de respuesta*/
       int statusCode = response.getStatusCode();
       System.out.println(statusCode);
       Assert.assertEquals(statusCode, 200);

    }
}
