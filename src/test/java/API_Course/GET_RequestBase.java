package API_Course;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.Argument;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GET_RequestBase {
    @Test
    public void test() {
        //String response = given().
                Response response = given().
                baseUri("https://reqres.in").
                when().
                        //mention end point
                        get("/api/users?page=2").
                then().
                        //log.all will print all the details in the console
                        //log().all().assertThat().statusCode(200);
        // how to validate response body we use different methods hasitem,hasitems,equal to,is(equalto())
                // body.name,body.item,body.size(we can get size of  array
                        // with the help groovy gpath we can do that
//body("body.first_name",hasItems("Michael","Lindsay","Tobias","Byron","George","Rachel"));
        // automate get request - Extract response
        // we can use extract response for further processing
        //
                        // log().all().assertThat().statusCode(200).extract().response().asString();
                                log().all().assertThat().statusCode(200).extract().response();
        // for fetch the workspace name we can use JsonPath object
        //JsonPath jsonpath = new JsonPath(response.asString());
        //JsonPath.from(response).getString("data[0].first_name");
        //System.out.println("response = " +  JsonPath.from(response).getString("data[0].first_name"));
//        System.out.println("response = " + jsonpath.getString("data[0].first_name"));
        //System.out.println("response = " + response.asString());
        // Extract single field from response
     //System.out.println("response = " + response.path("data[0].first_name"));
        // how to use hamcrest library for extracted reponse
//        System.out.println("response = " + response);
//        Assert.assertEquals(response,"tishlu");


        // These are the 3 different method we can use for apply assertion in response


//  System.out.println("response = " +  JsonPath.from(response).getString("data[0].first_name"));
        //JsonPath jsonpath = new JsonPath(response.asString());
      //  System.out.println("response = " + jsonpath.getString("data[0].first_name"));
       //System.out.println("response = " + response.path("data[0].first_name"));
    }
}
