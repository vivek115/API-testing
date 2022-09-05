package Parameters;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class Path_Params {
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
}
