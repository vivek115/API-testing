package Serialize_Deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static org.hamcrest.Matchers.equalTo;

public class SerializeMap_To_JSON_Object {
    @BeforeClass
    public void before_class() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://api.getpostman.com");
        requestSpecBuilder.log(LogDetail.ALL);
        //requestSpecBuilder.addHeader("give the path of header");
        RestAssured.requestSpecification = requestSpecBuilder.build();
    }

    @Test
    public void validate_post_request_payload_as_map() throws JsonProcessingException {
        HashMap<String, Object> mainobject = new HashMap<String, Object>();
        HashMap<String, String> nestedobject = new HashMap<String, String>();
        nestedobject.put("name", "myfourthworkspace");
        nestedobject.put("type", "koibhi");
        nestedobject.put("description", "hello");
        mainobject.put("workspace", nestedobject);
        // we are using object mapper class
        ObjectMapper objectMapper = new ObjectMapper();
        // writevalueasstring method will convert the java object into json object and json object as a string
        String mainobjectstr = objectMapper.writeValueAsString(mainobject);
        given().body(mainobjectstr).when().post("/workspaces").then().spec(responseSpecification).assertThat().body("workspace.name", equalTo("myfourthworkspace"));

    }

    @Test
    public void validate_post_request_payload_as_objectnode() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode nestedobjectNode = objectMapper.createObjectNode();
        nestedobjectNode.put("name", "myfourthworkspace1");
        nestedobjectNode.put("type", "koibhi");
        nestedobjectNode.put("description", "hello");
        ObjectNode mainobjectnode = objectMapper.createObjectNode();
        mainobjectnode.set("workspace", nestedobjectNode);
        // we are using object mapper class
        // writevalueasstring method will convert the java object into json object and json object as a string
        String mainobjectstr = objectMapper.writeValueAsString(mainobjectnode);
        given().body(mainobjectstr).when().post("/workspaces").then().spec(responseSpecification).assertThat().body("workspace.name", equalTo("myfourthworkspace"));

    }
}

