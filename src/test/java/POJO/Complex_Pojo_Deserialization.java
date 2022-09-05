package POJO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.pojo.collections.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.json.JSONException;
import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.ValueMatcher;
import org.skyscreamer.jsonassert.comparator.CustomComparator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class Complex_Pojo_Deserialization {
    @BeforeClass
    public void beforeclass() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://api.getpostman.com");
        requestSpecBuilder.log(LogDetail.ALL);
        //requestSpecBuilder.addHeader("give the path of header");
        RestAssured.requestSpecification = requestSpecBuilder.build();
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).log(LogDetail.ALL);
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void complex_pojo_create_collection() throws JsonProcessingException, JSONException {
        Header header = new Header("Content-Type", "application/json");
        List<Header> headerlist = new ArrayList<Header>();
        headerlist.add(header);
        Body body = new Body("raw", "{\"data\": \"123\"}");
        Request_Request request = new Request_Request("https://postman-echo.com/post", "POST", headerlist, body, "This is a sample POST Request");
        Requestroot_Request requestroot = new  Requestroot_Request("Sample POST Request", request);
        List<Requestroot_Base> requestrootBaseList = new ArrayList<Requestroot_Base>();
        requestrootBaseList.add(requestroot);
        Folder_Request folderBase = new Folder_Request("This is a folder", requestrootBaseList);
        List<Folder_Request> folderlist = new ArrayList<Folder_Request>();
        folderlist.add(folderBase);
        Info info = new Info("Sample Collection1", "This is just a sample collection.", "https://schema.getpostman.com/json/collection/v2.1.0/collection.json");
        Collection_Request collectionBase = new Collection_Request(info, folderlist);
        // request payload
        CollectionRoot_Request collectionRootBase = new CollectionRoot_Request(collectionBase);
        String collectionid = given().body(collectionRootBase).when().post("/collections").then().spec(responseSpecification)
                .extract().response().path("collection.id");
        //response payload
        CollectionRoot_Response deserializationcollectionroot = given().pathParam("collectionid", collectionid).when().get("/collections/{collectionid").then()
                .spec(responseSpecification).extract().response().as(CollectionRoot_Response.class);
        ObjectMapper objectMapper = new ObjectMapper();
        String collectionRootstr = objectMapper.writeValueAsString(collectionRootBase);
        String deserializationcollectionrootstr = objectMapper.writeValueAsString(deserializationcollectionroot);
        JSONAssert.assertEquals(collectionRootstr, deserializationcollectionrootstr, new CustomComparator(JSONCompareMode.STRICT_ORDER,
                new Customization("collection.item[*].item[*].request.url", new ValueMatcher<Object>() { // we are uwsing * for list and . for move further
                    public boolean equal(Object o1, Object o2) {

                        return true;
                    }
                })));
//        List<String> UrlRequestList = null;
//        List<String> UrlResponseList;
//        for(Requestroot_Request requestroot_request:requestroot){
//         UrlRequestList.add(requestroot_request.getRequestBase().getUrl());
//        }
//        List<Folder_Response> folder_responseList =deserializationcollectionroot.getCollections().getItem();
//        for(Folder_Response folder_response:folder_responseList){
//            List<Requestroot_Response> requestroot_responses =folder_response.getItem();
//            for(Requestroot_Response requestroot_response : requestroot_responses){
//              URL url =  requestroot_response.getRequestBase().getUrl();
//            }
//
        }
    }

