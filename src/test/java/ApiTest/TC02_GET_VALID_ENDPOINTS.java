package ApiTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02_GET_VALID_ENDPOINTS {
    @Test
    void Tc02() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        //Request response
        RequestSpecification httpRequest = RestAssured.given();

        //Response ObjectString responseBody= response.getBody().asString();
        Response response = httpRequest.request(Method.GET, "/todos");

       String body =response.getBody().asString();
        Assert.assertEquals(body.contains("\"id\": 5"), true);



    }


}

