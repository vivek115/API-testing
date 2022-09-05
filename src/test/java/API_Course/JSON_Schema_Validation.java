package API_Course;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JSON_Schema_Validation {
    @Test
    public void validateJsonschema(){
        given().baseUri("https://reqres.in").log().all().when()
                .get("/api/users/2").then().log().all().assertThat().statusCode(200);
    }
}
