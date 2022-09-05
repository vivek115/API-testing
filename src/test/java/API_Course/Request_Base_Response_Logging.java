package API_Course;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Request_Base_Response_Logging {
    @Test
    public void test() {
        given().
                baseUri("https://reqres.in").
                //log().all().
                log().headers().
                log().parameters().
                when().
                //mention end point
                        get("/api/users?page=2").
                then().
                //log().all().
                        log().body().
                log().cookies().
                log().all().assertThat().statusCode(200);
    }
}
