package engine.endpoints;
import engine.endpoints.CrudTestEndPoints;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import testBase.testBase;
import java.util.Map;

import static io.restassured.RestAssured.given;

import java.util.Map;


public class CrudTestEndPoints extends testBase {

    public static Response postCreateWithArray(Map payload) {

        Response response;

       response= given()
                .filter(new RequestLoggingFilter(captor))
                .contentType(ContentType.JSON).headers("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .log()
                .all()
                .post("https://petstore.swagger.io/v2/user/createWithArray");
        writeRequestAndResponseInReport(writer.toString(), response.prettyPrint());

        return response;
    }

}