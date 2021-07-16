package ApiTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03_POST_request {
    @Test
    void POST_request(){

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

//Request response
        RequestSpecification httpRequest = RestAssured.given();


        JSONObject requestParams=new JSONObject();
        requestParams.put("userId",200);
        requestParams.put("id",200);
        requestParams.put("title","We can do it");
        requestParams.put("completed",false);

        httpRequest.header("Content-Type","application/json");
        httpRequest.body(requestParams.toJSONString());

        //Response ObjectString responseBody= response.getBody().asString();
        Response response = httpRequest.request(Method.POST, "/todos");

       int statusCode= response.getStatusCode();
        System.out.println("status code is :"+statusCode);
        Assert.assertEquals(statusCode,201);

        String responseBody= response.getBody().asString();
        System.out.println(responseBody);



    }
}
