package API_Course;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Collections;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class Hamcrest_Collection_Base_Matchers {
    @Test
    public void test() {
         given().
                baseUri("https://reqres.in").
                when().
                //mention end point
                        get("/api/users?page=2").
                        then().
       log().all().assertThat().statusCode(200).
         body("data.first_name",contains("Michael","Lindsay","Tobias","Byron","George","Rachel"),
         //"data.first_name",empty());
        //"data.first_name",is(not(empty())));
              //   "data.first_name",hasSize(6));


                 // Hamcrest map methods
        //"data[0]",hasKey("id"));
        //"data[0]",hasValue("Michael"));
        //"data[0]",hasEntry("id"," 7"));
         //        "data[0]",not(equalTo(Collections.EMPTY_MAP)));
              //
                 //   "data[0].first_name",allOf(startsWith("Michael"),containsString("data")));
                 "data[0].first_name",anyOf(startsWith("Michael"),containsString("data")));
    }
}
