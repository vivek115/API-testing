package API_Course;

import io.restassured.config.EncoderConfig;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

public class Form_URL_Encoding {
    // sending data from form URL encoding
    // if content-type is undefined then not send charset by default content charset
    @Test
    public void form_url_encoding(){
        given().baseUri("https://reqres.in").config(config.encoderConfig(EncoderConfig.encoderConfig().
                appendDefaultContentCharsetToContentTypeIfUndefined(false))).formParam("key1","value1").
                formParam("key 2","value 2").log().all().when().post("/api/users").then().log().all().assertThat().statusCode(201);
    }
}
