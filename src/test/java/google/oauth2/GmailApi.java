package google.oauth2;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class GmailApi {
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    String access_token="ya29.A0ARrdaM_1Vl_KcBpX510hLulfSLqcSR8eLt0-oJdK1-Z1X75C4IEb_99TCrXAQQsj1Yr9mW5qQ-K6T9dAIqjY9WPy_2Zn9pDBl2Ixoq7smiJEmcgfWY52UFMDtKpVen9K6z8pwFj0N3MLVNBlu9aALao-TqMT";
    @BeforeClass
    public void beforeclass(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().setBaseUri("https://gmail.googleapis.com")
                .addHeader("Authorization","Bearer "+access_token)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL);
        requestSpecification=requestSpecBuilder.build();
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).log(LogDetail.ALL);
        responseSpecification=responseSpecBuilder.build();
    }
    @Test
            public void getuserprofile(){
        given(requestSpecification).basePath("/gmail/v1")
                .pathParam("userid","vivekjoshi840@gmail.com").
                when().get("users/{userid}/profile").then().spec(responseSpecification);
    }
}
