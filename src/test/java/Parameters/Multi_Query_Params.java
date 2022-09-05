package Parameters;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Multi_Query_Params {
    @Test
    public void multi_query_parameters(){
        HashMap<String,String> queryparams = new HashMap<String, String>();
        queryparams.put("fool1","bar1");
        queryparams.put("fool2","bar2");
        given().baseUri("https://postman-echo.com").
                //param("fool1","bar1").
//                        queryParam("fool1","bar1").
//                queryParam("fool2","bar2").
                // we can also use hashmap to send multiple params
                   queryParams(queryparams).
                when().
                get("/get").
                then().
                log().all().
                assertThat().
                statusCode(200);
    }
}
