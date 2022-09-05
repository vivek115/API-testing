package Cookie;
import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class SendingCookie {
    @BeforeClass
    public void beforeclass() {
        RestAssured.requestSpecification = new RequestSpecBuilder().
                setRelaxedHTTPSValidation().
                setBaseUri("https://localhost:8443").build();
    }
    @Test
    public void form_authentication_using_csrf_token_cookie_example() {
        // SESSION FILTER IS USED TO FETCH SESSION ID
        SessionFilter filter = new SessionFilter();
        given().
                auth().form("dan", "dan123", new FormAuthConfig("/signin", "txtUsername", "txtPassword")
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
        Cookie cookie = new Cookie.Builder("JSESSIONID", filter.getSessionId()).setSecured(true)
                .setHttpOnly(true).setComment("my cookie").build();
        Cookie cookie1 = new Cookie.Builder("dummy", "dummyvalue").build();
        Cookies cookies = new Cookies(cookie, cookie1);
        given().
                //set the cookie as request header and send as a request
                // cookie(cookie).
                        cookies(cookies).
                log().all().
                when().get("/profile/index").then()
                .log().all().assertThat().statusCode(200).
                body("html.body.div.p", equalTo("This is User Profile\\Index. Only authenticated people can see this"));
    }
    @Test
    public void fetch_single_cookie() {
        Response response = given().log().all()
                .when()
                .get("/profile/index").
                        then().
                        log().all().
                        assertThat().
                        statusCode(200).
                        extract().response();
        System.out.println(response.getCookie("JSESSIONID"));
        System.out.println(response.getDetailedCookie("JSESSIONID"));
    }
    @Test
    public void fetch_multiple_cookies() {
        Response response = given().log().all()
                .when()
                .get("/profile/index").
                        then().
                        log().all().
                        assertThat().
                        statusCode(200).
                        extract().response();
        // cookie name and cookie value
        Map<String, String> cookies = response.getCookies();
        for (Map.Entry<String, String> entry : cookies.entrySet()) {
            System.out.println("cookie name = " + entry.getKey());
            System.out.println("cookie value = " + entry.getValue());
        }
        // fetching detailed cookies with attributes
        Cookies cookies1 = response.getDetailedCookies();
        List<Cookie> cookieList = cookies1.asList();
        for (Cookie cookie : cookieList) {
            System.out.println("cookie = " + cookie.toString());
        }
    }
}
