package Get_Request;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_GET_RequestBase {
    // In this get request we are validating the headers
    @Test
    void googlemaptest() {
        RestAssured.baseURI = "https://maps.googleapis.com";
        //requestspecification is the predefined class
        // we will send request to the server
        // request object is created(httprequest)
        RequestSpecification httprequest = RestAssured.given();
        // response object to store the response
        //Response is a pre defined class
        // delhi is path parameters
        Response response = httprequest.request(Method.GET, "/maps/api/js?key=&callback=initMap");
        // print response in the console window
        // getbody give response in json format where we convert json into string variable
        String responsebody = response.getBody().asString();
        System.out.println("Response body is:" + responsebody);
      // capture details of headers from response
//        String acceptencoding = response.header("Accept-Encoding");
//        System.out.println("accepencoding is:" +acceptencoding);
//        Assert.assertEquals(acceptencoding,"gzip");
        // printing all the headers
        Headers allheaders = response.headers(); // capture all the headers from response
        for(Header header:allheaders)
        {
            System.out.println(header.getName()+"     "+header.getValue());
        }
    }
}
