package API_Course;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Log_If_Error {
    @Test
    public void test() {
        given().
                baseUri("https://reqres.in").
              log().all().
                when().
                //mention end point
                        get("/api/users?page=2").
                then().
                //log().all().
//                        log().body().
//                log().cookies().
        // log().if error will perform if there is an error in request log
        log().ifError().
                log().all().assertThat().statusCode(200);
    }
}

