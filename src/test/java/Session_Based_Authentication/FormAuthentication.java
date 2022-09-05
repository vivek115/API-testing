package Session_Based_Authentication;
import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.session.SessionFilter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FormAuthentication {
    @BeforeClass
    public void beforeclass(){
        RestAssured.requestSpecification = new RequestSpecBuilder().
                setRelaxedHTTPSValidation().
                setBaseUri("https://localhost:8443").build();
    }
    @Test
    public void form_authentication_using_csrf_token(){
        // SESSION FILTER IS USED TO FETCH SESSION ID
        SessionFilter filter = new SessionFilter();
        given().
                auth().form("dan","dan123",new FormAuthConfig("/signin","txtUsername","txtPassword")
        .withAutoDetectionOfCsrf()).
                filter(filter).
                log().all().
                when().
                get("/login").
                then().
                log().all().
                assertThat().
                statusCode(200);
        System.out.println("session id = " + filter.getSessionId());
        given().
                sessionId(filter.getSessionId()).
                log().all().
                when().get("/profile/index").then()
                .log().all().assertThat().statusCode(200).
                body("html.body.div.p",equalTo("This is User Profile\\Index. Only authenticated people can see this"));
    }
}
