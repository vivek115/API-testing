package DELETE_Request;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_DELETE_RequestBase {
    @Test
    void getautherization(){
    RestAssured.baseURI="https://reqres.in/api";
    //requestspecification is the predefined class
    // we will send request to the server
    // request object is created(httprequest)
    RequestSpecification httprequest = RestAssured.given();
    // response object to store the response
    //Response is a pre defined class
    // delhi is path parameters
    // send the post request
    Response response = httprequest.request(Method.DELETE,"/users/2");
    // print response in the console window
    // getbody give response in json format where we convert json into string variable
    // status code validation
    int statuscode = response.getStatusCode();
        System.out.println("Status code is:" + statuscode);
        Assert.assertEquals(statuscode,204);
}
}
