package ApiTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public  class TC01_Functionality_Working {

    @Test
   void apiWorking(){
//        RequestSpecification http=setUp.httpRequest;
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";

        //Request response
       RequestSpecification httpRequest=RestAssured.given();



        //Response Object
       Response response=  httpRequest.request(Method.GET,"/todos");

       //print response
        String responseBody=response.getBody().asString();
        System.out.println("Response Body is:"+responseBody);

        //print status code validation
        int statusCode= response.getStatusCode();
        System.out.println("Status code is:"+statusCode);
        Assert.assertEquals(statusCode,200 );



   }
}
