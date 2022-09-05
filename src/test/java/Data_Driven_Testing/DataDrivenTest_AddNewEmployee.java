package Data_Driven_Testing;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

public class DataDrivenTest_AddNewEmployee {
    @Test(dataProvider = "empdataprovider")
    void postnewemployees(String name,String job){
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
        Response response = httprequest.request(Method.POST,"/users/create");
        // print response in the console window
        // getbody give response in json format where we convert json into string variable
        // CAPTURE RESPONSE BODY
        String responsebody = response.getBody().asString();
         System.out.println("Response body is:" + responsebody);
        Assert.assertEquals(responsebody.contains(name),true);
        // status code validation
        int statuscode = response.getStatusCode();
        System.out.println("Status code is:" + statuscode);
        Assert.assertEquals(statuscode,201);
    }
    // string type of 2 array it is returning
    @DataProvider(name="empdataprovider")
    Object[][] getEmpdata() throws IOException {
        // Read data from excel
        String path="C://Users//VivekJoshi//Downloads//Book 15 - Copy.xlsx";
        int rownum=XLUtils.getRowCount(path,"Sheet1");
        int column=XLUtils.getCellCount(path,"Sheet1",1);
        // here we define static array to get same number of rows and coum in the excel sheet
        String[][] empdata = new String[rownum][column];
        for(int i=1;i<=rownum;i++){
          for(int j=0;j<column;j++)  {
             empdata[i-1][j]=XLUtils.getcelldata(path,"Sheet1",i,j);
          }
        }
        //String empdata [][]={{"abc123","tesla"},{"cde123","tata"},{"efg","mahindra"}};
        return(empdata);

    }
}
