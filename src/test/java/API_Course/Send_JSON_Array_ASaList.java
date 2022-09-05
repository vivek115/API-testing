package API_Course;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class Send_JSON_Array_ASaList {
    @BeforeClass
    public void beforeclass() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://reqres.in").
         addHeader("x-mock-match-request-body","true").setContentType(ContentType.JSON).log(LogDetail.ALL);
        //requestSpecBuilder.addHeader("give the path of header");
        RestAssured.requestSpecification = requestSpecBuilder.build();
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).log(LogDetail.ALL);
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void test() {
        HashMap<String,String> obj = new HashMap<String,String>();
        obj.put("name","yenky33");
        obj.put("job","venky33");
        List<HashMap<String,String>> jsonlist = new ArrayList<HashMap<String,String>>();
        jsonlist.add(obj);
        given().body(jsonlist).when().post("/api/users").then().log().all().assertThat().body("name",equalTo("yenky33"));
    }
}
