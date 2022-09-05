package google.oauth2;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Base64;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SendEmail_API {
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    String access_token="ya29.A0ARrdaM-Dyu3XxVsV4xooOIBcm_NWCTHzikINXmuZGHewj-jAlfZxoN3P6rTUuxmuADmSNSGHXQY_vs9qa2-qiOSCcsRW9Ebj_w4VGt_5iv0J-lLQfGsnIADgVqmzsWpoiN_PffHTijzC0erz7vcKHWRzJJtLhw";
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

    @Test
    public void sendmessage(){
        //RFC 2822 basic format for gmail
        //RFC 2822 basic format for gmail
        String msg="From: vivekjoshi840@gmail.com\n" +
                "To: vivekjoshi840@gmail.com\n" +
                "Subject: Test Email\n" +
                "\n" +
                "Sending from Gmail API";
// convert that RFC 2822 format into base64 format
        String base64UrlEncoded = Base64.getUrlEncoder().encodeToString(msg.getBytes());
        // to pass as json string we use hashmap over there
        HashMap<String,String> payload = new HashMap<>();
        payload.put("raw",base64UrlEncoded);
        given(requestSpecification).basePath("/gmail/v1")
                .pathParam("userid","vivekjoshi840@gmail.com").
                //we have to pass it as json string instead of json we use hashmap upper
                body(payload).
                when().post("/users/{userid}/messages/send").then().spec(responseSpecification);
        
    }

}
