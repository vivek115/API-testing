package API_Course;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class MultiPart_Form_Data {
    @Test
    public void multi_value_query_parameters(){
        given().baseUri("https://reqres.in").
                pathParam("userid","2").
                when().
                get("/api/users/{userid}").
                then().
                log().all().
                assertThat().
                statusCode(200);
    }
    @Test
    public void multipart_form_data(){
        given().baseUri("https://reqres.in").multiPart("foo1","bar1").log().all().post("/api/users").then().log().all().assertThat().statusCode(201);
    }
}
