package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Qurey_Parameter {
    @Test
            public void single_query_parameters(){
        given().baseUri("https://postman-echo.com").
                //param("fool1","bar1").
                queryParam("fool1","bar1").
                when().
                get("/get").
                then().
                log().all().
                assertThat().
                statusCode(200);
    }
}
