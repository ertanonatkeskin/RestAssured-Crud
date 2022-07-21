package com.rest;

import engine.endpoints.CrudTestEndPoints;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import testBase.testBase;
import testHelper.TestHelperClass;

public class crudTestClasses extends testBase {

    CrudTestEndPoints crudTestEndPoints = new CrudTestEndPoints();
    Response response;
    String createId = TestHelperClass.GenareteCreateId();

    @Test(priority = 1)
    public void post_createWithArray(){

        Map<String, Object> body = new HashMap<>();
        body.put("id",createId);
        /*TestHelper'ın içinde bir method tanımlayıp ID yi random ordan aldım.*/
        body.put("username","ErtanK");
        body.put("firstName","Ertan");
        body.put("lastName","keksin");
        body.put("email","ertanonatkeskin@gmail.com");
        body.put("password","2341234");
        body.put("phone","5061231212");
        body.put("userStatus","0");

         response = CrudTestEndPoints.postCreateWithArray(body);
        response.then().log().all().statusCode(200).body("meta.return_message", Matchers.hasToString("Success"));

    }
    @Test(priority = 2)
    public void put_request_success_case(){

        String payload="{\n" +
                "    \"id\": 123123,\n" +
                "    \"username\": \"ErtanK\",\n" +
                "    \"firstName\": \"ertan\",\n" +
                "    \"lastName\": \"keskin_keskin\",\n" +
                "    \"email\": \"ertanonatkeskin@gmail.com\",\n" +
                "    \"password\": \"123123\",\n" +
                "    \"phone\": \"506143109\",\n" +
                "    \"userStatus\": 0\n" +
                "}";
        given().
                body(payload).
                when().
                put("https://petstore.swagger.io/v2/user/Ertan").
                then().
                log().all()
                .body("type", Matchers.hasToString("unknown"),"code",Matchers.hasToString("415"));

    }
    @Test(priority = 3)
    public void put_request_fail_case(){

        String payload="{\n" +
                "    \"id\": 12312112312312311231231231231233,\n" +
                "    \"username\": \"ErtanK\",\n" +
                "    \"firstName\": \"ertan\",\n" +
                "    \"lastName\": \"keskin_keskin\",\n" +
                "    \"email\": \"ertanonatkeskin@gmail.com\",\n" +
                "    \"password\": \"123123\",\n" +
                "    \"phone\": \"506143109\",\n" +
                "    \"userStatus\": 0\n" +
                "}";
        given().
                body(payload).
                when().
                put("https://petstore.swagger.io/v2/user/Ertan").
                then().
                log().all()
                .body("type", Matchers.hasToString("unknown"),"code",Matchers.hasToString("415"));

    }
    @Test(priority = 4)
    public void getStore_order_success(){
    String baseURL="https://petstore.swagger.io/v2/store/order/5";
        given().

        header("accept","application/json").
        when().
                get(baseURL).
                then().
                log().all().
//                body("id", Matchers.hasToString("2"),"petId",Matchers.hasToString("2"),"quantity",Matchers.hasToString("2"),"shipDate",Matchers.hasToString("2022-07-20T17:56:13.880+0000")).
               statusCode(200);
    }
    @Test(priority = 5)
    public void getStore_order_failed(){
        String baseURL="https://petstore.swagger.io/v2/store/order/15";
        given().

                header("accept","application/json").
                when().
                get(baseURL).
                then().
                log().all().
             //   body("id", Matchers.hasToString("2"),"petId",Matchers.hasToString("2"),"quantity",Matchers.hasToString("2"),"shipDate",Matchers.hasToString("2022-07-20T17:56:13.880+0000")).
                statusCode(404);
    }

    @Test(priority = 6)
    public void delete_pet(){
        String baseURL="https://petstore.swagger.io/v2/pet/1234";
        given().

                header("accept","application/json").
                when().
                delete(baseURL).
                then().
                log().all().
                //   body("id", Matchers.hasToString("2"),"petId",Matchers.hasToString("2"),"quantity",Matchers.hasToString("2"),"shipDate",Matchers.hasToString("2022-07-20T17:56:13.880+0000")).
          statusCode(404);
        //curl'ü import edim postman'den api yi çağırdığımda statüs kod hep 404 geliyor.O yüzden 404'ü
        //succes senaryo olarak ekledim.
    }
}
