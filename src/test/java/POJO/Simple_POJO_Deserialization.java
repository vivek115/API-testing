package POJO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.pojo.simple.Simple_POJO;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Simple_POJO_Deserialization {
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
    public void simple_pojo_deserialization() throws JsonProcessingException {
        Simple_POJO simple_pojo = new Simple_POJO("value1","value2");
        // we can't use the same object so we have to create new object for deserialization
        Simple_POJO deserialization =
        given().body(simple_pojo).when().post("/postsimplejson").then().spec(responseSpecification)
               .extract().response().as(Simple_POJO.class);
        ObjectMapper objectMapper = new ObjectMapper();
        String deserializedPojoStr = objectMapper.writeValueAsString(deserialization); // actual value of jSON
        String simplePojoStr = objectMapper.writeValueAsString(simple_pojo); //expected value of JSON
        assertThat(objectMapper.readTree(deserializedPojoStr),equalTo(objectMapper.readTree(simplePojoStr)));

    }
}
