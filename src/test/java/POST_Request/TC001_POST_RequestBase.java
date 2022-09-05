package POST_Request;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_POST_RequestBase {
    @Test
    void RegistrationSuccessfull() {
        RestAssured.baseURI = "https://reqres.in/api";
        //requestspecification is the predefined class
        // we will send request to the server
        // request object is created(httprequest)
        RequestSpecification httprequest = RestAssured.given();
        // delhi is path parameters
        //request parameters or request payloads along with post request
        // these all are post request
        JSONObject requestparams = new JSONObject();
        requestparams.put("name", "Vivek123");
        requestparams.put("job", "koi bhi");
//        requestparams.put("UserName", "Vivek@123");
//        requestparams.put("Password", "Vivek@123");
//        requestparams.put("Email", "vivek@123");
        // we have to send some headers
        httprequest.header("Content-Type", "application/json");
        // it will add json to the body request
        httprequest.body(requestparams.toJSONString()); // attach above data to the request
        Response response = httprequest.request(Method.POST, "/users");
        // print response in the console window
        // getbody give response in json format where we convert json into string variable
        String responsebody = response.getBody().asString();
        System.out.println("Response body is:" + responsebody);
        // status code validation
        int statuscode = response.getStatusCode();
        System.out.println("Status code is:" + statuscode);
        Assert.assertEquals(statuscode, 201);
        String successcode = response.jsonPath().get("SuccessCode");
        //Assert.assertEquals(successcode, "OPERATION_SUCCESS");
    }
}
