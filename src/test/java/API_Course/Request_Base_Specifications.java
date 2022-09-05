package API_Course;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Request_Base_Specifications {
    RequestSpecification requestSpecification;
    //requestspecification is a instance variable

//    @BeforeClass
//    public void beforeclass(){
//     //requestSpecification = given(). baseUri("https://reqres.in");
//        requestSpecification = with(). baseUri("https://reqres.in").log().all();
//        // the difference between given and with is just syntactical.There is no difference in functionality
//    }

    // Request specification builder
    @BeforeClass

    public void beforeclass(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://reqres.in");
        //requestSpecBuilder.addHeader("give the path of header");
        requestSpecification=requestSpecBuilder.build();
    }
    @Test
    public void test() {
            // given(requestSpecification).
        //given().spec(requestSpecification).
                //log().all().
//                        log().headers().
//                log().parameters().
//                when().
                //mention end point
                 Response response = given().spec(requestSpecification).get("/api/users?page=2").then().log().all().extract().response();
                  assertThat(response.statusCode(),is(equalTo(200)));
//                then().
//                //log().all().
//                        log().body().
//                log().cookies().
//                log().all().assertThat().statusCode(200);
    }
    // how to reuse request specification
    @Test
    public void test1(){
//      given().spec(requestSpecification).
//                //log().all().
//                        log().headers().
//                log().parameters().
//                when().
                //mention end point
                  Response response=  given().spec(requestSpecification).get("/api/users?page=2").then().log().all().extract().response();
                  //we can apply assertion in body
                  //assertThat(response.path());
//                then().
//                //log().all().
//                        log().body().
//                log().cookies().
//                log().all().assertThat().statusCode(200);
    }
}
