package ApiTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04_PUTRequest {

    @Test
    void putRequest(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

//Request response
        RequestSpecification httpRequest = RestAssured.given();


        JSONObject requestParams=new JSONObject();

        requestParams.put("title","We can do it!!!yes");


        httpRequest.header("Content-Type","application/json");
        httpRequest.body(requestParams.toJSONString());

        //Response ObjectString responseBody= response.getBody().asString();
        Response response = httpRequest.request(Method.PUT, "/todos/3");

        int statusCode= response.getStatusCode();
        System.out.println("status code is :"+statusCode);
        Assert.assertEquals(statusCode,200);

        String responseBody= response.getBody().asString();
        System.out.println(responseBody);



    }
}
