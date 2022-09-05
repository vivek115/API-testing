package API_Course;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class API_Key_Authentication {
    @Test
    public void authentication(){
        given().baseUri("https://api.getpostman.com").formParam("X-Api-Key","1234").
                when().get("/collections").
                then(). log().all().assertThat().statusCode(200);
    }
}
