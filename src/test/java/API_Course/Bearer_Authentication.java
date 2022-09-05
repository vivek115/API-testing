package API_Course;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Bearer_Authentication {
    @Test
    public void authentication(){
        given().
                formParam("client_id","yahoo").formParam("client_secret","b6d66ea7d6004824566f0c3c3356a12d")
                .formParam("grant_type","client_credentials").
                when().post("http://coop.apps.symfonycasts.com/token").
                then(). log().all().assertThat().statusCode(200);
    }
}
