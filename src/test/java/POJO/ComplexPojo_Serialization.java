package POJO;
import com.rest.pojo.collections.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class ComplexPojo_Serialization {
    @BeforeClass
    public void beforeclass(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://api.getpostman.com");
        requestSpecBuilder.log(LogDetail.ALL);
        //requestSpecBuilder.addHeader("give the path of header");
        RestAssured.requestSpecification = requestSpecBuilder.build();
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).log(LogDetail.ALL);
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }
    @Test
    public void complex_pojo_create_collection(){
        Header header = new Header("Content-Type","application/json");
        List<Header> headerlist = new ArrayList<Header>();
        headerlist.add(header);
        Body body = new Body("raw","{\"data\": \"123\"}");
        Request_Request request = new Request_Request("https://postman-echo.com/post","POST",headerlist,body,"This is a sample POST Request");
        Requestroot_Request requestroot = new Requestroot_Request("Sample POST Request", request);
        List<Requestroot_Base> requestrootBaseList = new ArrayList<Requestroot_Base>();
        requestrootBaseList.add(requestroot);
       Folder_Request folderBase = new Folder_Request("This is a folder", requestrootBaseList);
        List<Folder_Request> folderlist = new ArrayList<Folder_Request>();
        folderlist.add(folderBase);
        Info info = new Info("Sample Collection1","This is just a sample collection.","https://schema.getpostman.com/json/collection/v2.1.0/collection.json");
        Collection_Request collectionBase = new Collection_Request(info,folderlist);
        CollectionRoot_Request collectionRootBase = new  CollectionRoot_Request(collectionBase);
        given().body(collectionRootBase).when().post("/collections").then().spec(responseSpecification);

    }
}
