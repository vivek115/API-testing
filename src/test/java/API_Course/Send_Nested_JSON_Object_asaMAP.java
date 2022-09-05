package API_Course;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Send_Nested_JSON_Object_asaMAP {
    @BeforeClass
    public void beforeclass() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().setBaseUri("https://reqres.in").setContentType(ContentType.JSON).log(LogDetail.ALL);
        RestAssured.requestSpecification = requestSpecBuilder.build();
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).log(LogDetail.ALL);
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void validate_post_request() {
        // string is a key and object is the value
        HashMap<String, Object> mainobject = new HashMap<String, Object>();
        HashMap<String, String> nestedobject = new HashMap<String, String>();
        nestedobject.put("name", "yenky333");
        nestedobject.put("job", "venky333");
        mainobject.put("data",nestedobject);
        given().
                body(mainobject).when().post("/api/users").then().assertThat().body("data.name", equalTo("yenky333"));
    }
}
