package Autherization;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TC001_GET_Request_Base_Autherization {
    @Test
    void getautherization(){
        RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
        // Basic authentication
        //  authentication should be specified before sending the request
        // Preemptivebasicauthscheme is a predefined class
        PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
        // by using this authscheme object we pass basic auth(username and password)
        authscheme.setUserName("ToolsQA");
        authscheme.setPassword("TestPassword");
        RestAssured.authentication=authscheme;
        //requestspecification is the predefined class
        // we will send request to the server
        // request object is created(httprequest)
        RequestSpecification httprequest = RestAssured.given();
        // response object to store the response
        //Response is a pre defined class
        Response response = httprequest.request(Method.GET,"/");
        // status code validation
        int statuscode = response.getStatusCode();
        System.out.println("Status code is:" + statuscode);
        Assert.assertEquals(statuscode,200);
        // status line validation
        String statusline = response.getStatusLine();
        System.out.println("status line is:" +statusline);
        Assert.assertEquals(statusline,"HTTP/1.1 200 OK");
        // print response in console window
        String responsebody = response.getBody().asString();
        System.out.println("Response body is:" + responsebody);
    }
    }

