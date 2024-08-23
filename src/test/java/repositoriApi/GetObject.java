package repositoriApi;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetObject {
    String path = "./reports/Apis.html";
    //Extent Reporte
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter(path);



    @Test
    public void getObject(){

        extent.attachReporter(spark);

        /*objeto RequestSpecification objeto que nos pemite abrir el link de la api
        apuntar a la section en específico*/
        RequestSpecification requesGet = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects");
        Response response = requesGet
                .when()
                .get();

        /*La sigueinte linea imprime la respuesta*/
        response.prettyPrint();
        /*me permite verificar el numero de respuesta*/
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 200);
    }
}
