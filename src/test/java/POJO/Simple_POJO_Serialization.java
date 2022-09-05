package POJO;

import com.rest.pojo.simple.Simple_POJO;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Simple_POJO_Serialization {
    @BeforeClass
    public void beforeclass(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().setBaseUri("https://98631c02-c640-4276-af1d-0c8f9790a935.mock.pstmn.io")
                .log(LogDetail.ALL);
       RestAssured.requestSpecification = requestSpecBuilder.build();
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
                .log(LogDetail.ALL);
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }
    @Test
    public void simple_pojo_example(){
      Simple_POJO simple_pojo = new Simple_POJO("value1","value2");

        // It convert pojo object into json object through serialization
        // Our mai task convert this payload into pojo class
//        String payload ="{\n" +
//                "    \"key1\":\"value1\",\n" +
//                "    \"key2\":\"value2\"\n" +
//                "}";
        given().body(simple_pojo).when().post("/postsimplejson").then().spec(responseSpecification)
                .assertThat().body("key1",equalTo(simple_pojo.getKey1()),"key2",equalTo(simple_pojo.getKey2()));
//                .assertThat().body("key1",equalTo("value1"),
//                "key2",equalTo("value2"));
    }
}
