package ApiTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05_DELETE {
    @Test
    void delete() {


        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

//Request response
        RequestSpecification httpRequest = RestAssured.given();


        //Response ObjectString responseBody= response.getBody().asString();
        Response response = httpRequest.request(Method.DELETE, "/todos/3");

        int statusCode = response.getStatusCode();
        System.out.println("status code is :" + statusCode);
        Assert.assertEquals(statusCode, 200);

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);


    }
}
