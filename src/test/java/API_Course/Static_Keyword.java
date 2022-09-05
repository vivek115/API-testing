package API_Course;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Static_Keyword {
    @Test
    public void test() {
        given().
                when().
                then();

    }
}

