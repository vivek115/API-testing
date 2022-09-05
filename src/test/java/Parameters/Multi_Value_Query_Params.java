package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Multi_Value_Query_Params {
    @Test
    public void multi_value_query_parameters(){
        given().baseUri("https://postman-echo.com").
                //param("fool1","bar1").
                        //queryParam("fool1","bar1,bar2,bar3").
                                queryParam("fool1","bar1;bar2;bar3").
                when().
                get("/get").
                then().
                log().all().
                assertThat().
                statusCode(200);
    }
}
