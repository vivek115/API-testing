package Get_Request;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003_GET_RequestBase {
    // validating JSON response body
    @Test
    void getjsonresponsebody(){
        RestAssured.baseURI = "https://reqres.in";
        //requestspecification is the predefined class
        // we will send request to the server
        // request object is created(httprequest)
        RequestSpecification httprequest = RestAssured.given();
        // response object to store the response
        //Response is a pre defined class
        // delhi is path parameters
        Response response = httprequest.request(Method.GET, "/api/users?page=2");
        // print response in the console window
        // getbody give response in json format where we convert json into string variable
//        String responsebody = response.getBody().asString();
//        System.out.println("Response body is:" + responsebody);
        //
//        Assert.assertEquals(responsebody.contains("fuchsia rose"),true);
        // it will print all the details of the json body
        // jsonpath is a predefined class
        JsonPath jsonPath = response.jsonPath();
//        System.out.println(jsonPath.get("first_name"));
//        System.out.println(jsonPath.get("last_name"));
//        System.out.println(jsonPath.get("email"));
    }
}
