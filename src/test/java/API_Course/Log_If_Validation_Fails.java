package API_Course;

import io.restassured.config.LogConfig;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

public class Log_If_Validation_Fails {
    @Test
    public void test() {
        // BLACKLISTING ALL THE HEADERS
        Set<String> headers = new HashSet<String>();
        headers.add("give the headers name");
        headers.add("give the headers name");
        given().
                baseUri("https://reqres.in").
                //log().all().
                       // config(config.logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails())).
                               // BLACKLIST HEADERS
               // config(config.logConfig(LogConfig.logConfig().blacklistHeader("PROVIDE THE HEADERS NAME WHICH YOU WANT TO BLACKLIST"))).
                //log().ifValidationFails().
                when().
                //mention end point
                        get("/api/users?page=2").
                then().
                //log().all().
//                        log().body().
//                log().cookies().
                // log().if error will perform if there is an error in request log
                       // log().ifValidationFails().
                       // log().ifError().
                //assertThat().statusCode(200);
        assertThat().statusCode(201);

    }
}
