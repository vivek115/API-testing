package PUT_Request;

import Data_Driven_Testing.XLUtils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

public class TC001_PUT_RequestBase {
    @Test(dataProvider = "EmpdataProvider")
    void updateemployees(String name,String job){
        RestAssured.baseURI="https://reqres.in/api";
        //requestspecification is the predefined class
        // we will send request to the server
        // request object is created(httprequest)
        RequestSpecification httprequest = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("name",name);
        requestParams.put("job",job);
        // Add a header starting the request body is a json
        httprequest.header("Content-Type","application/json");
        // particularly in the hashmap format
        // add the json to the body of the request
        httprequest.body(requestParams.toJSONString());
        // response object to store the response
        //Response is a pre defined class
        // delhi is path parameters
        // send the post request
        Response response = httprequest.request(Method.PUT,"/users/2");
        // print response in the console window
        // getbody give response in json format where we convert json into string variable
        // CAPTURE RESPONSE BODY
        String responsebody = response.getBody().asString();
        System.out.println("Response body is:" + responsebody);
        Assert.assertEquals(responsebody.contains(name),true);
        // status code validation
        int statuscode = response.getStatusCode();
        System.out.println("Status code is:" + statuscode);
        Assert.assertEquals(statuscode,200);
    }
    // string type of 2 array it is returning
    @DataProvider(name="EmpdataProvider")
    Object[][] getEmpdata() throws IOException {
        // Read data from excel
        String path="C://Users//VivekJoshi//Downloads//Book 15 - Copy (3).xlsx";
        int rownum= XLUtils.getRowCount(path,"Sheet2");
        int column=XLUtils.getCellCount(path,"Sheet2",1);
        // here we define static array to get same number of rows and coum in the excel sheet
        String[][] empdata = new String[rownum][column];
        for(int i=1;i<=rownum;i++){
            for(int j=0;j<column;j++)  {
                empdata[i-1][j]=XLUtils.getcelldata(path,"Sheet2",i,j);
            }
        }
        //String empdata [][]={{"abc123","tesla"},{"cde123","tata"},{"efg","mahindra"}};
        return(empdata);
    }
}
