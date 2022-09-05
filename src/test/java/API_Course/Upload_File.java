package API_Course;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class Upload_File {
    @Test
    public void multi_value_query_parameters(){
        String attributes = "{\"name\":\"TEMP.TXT\",\"parent\":{\"id\":\"123456\"}}";
        given().baseUri("https://reqres.in").
                multiPart("file",new File("TEMP.TXT")).
                multiPart("attribute",attributes,"application/json").
                when().
                get("/api/users").
                then().
                log().all().
                assertThat().
                statusCode(200);
    }
}
