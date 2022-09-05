package Get_Request;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TC001_GET_RequestBase {
    @Test
     void getweatherDetails(){
         // specify base URL
        RestAssured.baseURI="https://newsapi.org/v2";
        //requestspecification is the predefined class
        // we will send request to the server
        // request object is created(httprequest)
        RequestSpecification httprequest = RestAssured.given();
        String search = "currency";
        String apiKey = "ac684f80c06c4d6e9ed1ac0b5af3733d";
        // response object to store the response
        //Response is a pre defined class
        // delhi is path parameters
        // Use parameterization in get request
        Response response = httprequest.request(Method.GET,String.format("/everything?q=%s&apiKey=%s",search,apiKey ));
       // print response in the console window
        // getbody give response in json format where we convert json into string variable
        String responsebody = response.getBody().asString();
        System.out.println("Response body is:" + responsebody);
        // status code validation
       int statuscode = response.getStatusCode();
        System.out.println("Status code is:" + statuscode);
        Assert.assertEquals(statuscode,200);
        // status line validation
        String statusline = response.getStatusLine();
        System.out.println("status line is:" +statusline);
        Assert.assertEquals(statusline,"HTTP/1.1 200 OK");
     }
}
