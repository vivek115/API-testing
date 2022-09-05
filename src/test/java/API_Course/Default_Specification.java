package API_Course;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.get;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Default_Specification {

    @BeforeClass

    public void beforeclass() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://reqres.in");
        requestSpecBuilder.log(LogDetail.ALL);
        //requestSpecBuilder.addHeader("give the path of header");
        RestAssured.requestSpecification = requestSpecBuilder.build();
    }
    //query request specification is used to fetch the details or get data
@Test
public void querytest(){
    QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(RestAssured.requestSpecification);
    System.out.println(queryableRequestSpecification.getBaseUri());
    //System.out.println(queryableRequestSpecification.getHeaders());
}
    @Test
    public void test() {
        Response response = get("/api/users?page=2").then().log().all().extract().response();
        assertThat(response.statusCode(), is(equalTo(200)));
    }
}
