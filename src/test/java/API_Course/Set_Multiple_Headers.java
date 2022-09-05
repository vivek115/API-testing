package API_Course;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Set_Multiple_Headers {
    @Test
    public void test() {
        Header header = new Header("header", "value2");
        Header header1 = new Header("x-mock-match-request-headers", "header");
        // we can do by headers object
        Headers headers = new Headers(header, header1);
        given().
                baseUri("https://c2a74066-baa4-4c57-8cfa-3626c0d4a9a0.mock.pstmn.io").
                //headers(headers).
//                header(header).
//                header(header1).
//                header("headersName","value1").
//                header("x-mock-match-request-headers","headersName").
        when().
                //mention end point
                        get("/get").
                then().
                log().all().assertThat().statusCode(200);
    }

    public void hashmapheaders() {

        // we can verify headers by hashmap
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("header", "value2");
        headers.put("x-mock-match-request-headers", "header");
        given().
                baseUri("https://c2a74066-baa4-4c57-8cfa-3626c0d4a9a0.mock.pstmn.io").
                //headers(headers).
//                header(header).
//                header(header1).
//                header("headersName","value1").
//                header("x-mock-match-request-headers","headersName").
        when().
                //mention end point
                        get("/get").
                then().
                log().all().assertThat().statusCode(200);
    }

    public void multipleheaders() {
        Header header = new Header("multivalueHeader", "value1");
        Header header1 = new Header("multivalueHeader", "value2");
        Headers headers = new Headers(header, header1);
        given().
                baseUri("https://c2a74066-baa4-4c57-8cfa-3626c0d4a9a0.mock.pstmn.io").
                headers(headers).
                log().headers().
                when().
                //mention end point
                        get("/get").
                then().
                log().all().assertThat().statusCode(200);
    }
    public void Responseheaders_Assert(){
        Header header = new Header("multivalueHeader", "value1");
       // Header header1 = new Header("multivalueHeader", "value2");
        Headers headers = new Headers(header);
        given().
                baseUri("https://c2a74066-baa4-4c57-8cfa-3626c0d4a9a0.mock.pstmn.io").
                headers(headers).
                log().headers().
                when().
                //mention end point
                        get("/get").
                then().
                log().all().assertThat().statusCode(200).
       // header("responseheaders","resvalue1");
        // how to handle muliple headers in assertions
        headers("responseheaders","resvalue1","x-mock-match-request-headers","120");
    }
    public void Responseheaders_Extract(){
        Header header = new Header("multivalueHeader", "value1");
        // Header header1 = new Header("multivalueHeader", "value2");
        Headers extractedheaders = new Headers(header);
        given().
                baseUri("https://c2a74066-baa4-4c57-8cfa-3626c0d4a9a0.mock.pstmn.io").
                headers(extractedheaders).
                log().headers().
                when().
                //mention end point
                        get("/get").
                then().
                log().all().assertThat().statusCode(200).
                extract().headers();
        System.out.println("header = " + extractedheaders.get("responseheaders").getName());
        System.out.println("header = " + extractedheaders.get("responseheaders").getValue());
        System.out.println("header = " + extractedheaders.getValue("responseheaders"));
    }
    public void extract_multivalue_response_header(){
        Header header = new Header("multivalueHeader", "value1");
        // Header header1 = new Header("multivalueHeader", "value2");
        Headers extractedheaders = new Headers(header);
        given().
                baseUri("https://c2a74066-baa4-4c57-8cfa-3626c0d4a9a0.mock.pstmn.io").
                headers(extractedheaders).
                log().headers().
                when().
                //mention end point
                        get("/get").
                then().
                log().all().assertThat().statusCode(200).
                extract().headers();
        List<String> values = extractedheaders.getValues("multivalueHeaders");
        // for fetching individual values
        for(String value:values){
            System.out.println(value);
        }
    }
    }


