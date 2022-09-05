package POJO;

import com.rest.pojo.simple.workspace.Workspace;
import com.rest.pojo.simple.workspace.WorkspaceRoot;
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

public class Workspace_POJO {
    @BeforeClass
    public void beforeclass(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().setBaseUri("https://api.getpostman.com")
                .log(LogDetail.ALL);
        RestAssured.requestSpecification = requestSpecBuilder.build();
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
                .log(LogDetail.ALL);
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }
    @Test
    public void validate_post_request_payload_as_pojo(){
        Workspace workspace = new Workspace("Myworkspace","personal","description");
        WorkspaceRoot workspaceRoot = new WorkspaceRoot(workspace);
        //workspaceroot is the main object
       WorkspaceRoot deserializtionWorkspaceRoot = given().body(workspaceRoot).when().post("/workspaces").then().spec(responseSpecification).
               extract().response().as(WorkspaceRoot.class);
       assertThat(deserializtionWorkspaceRoot.getWorkspace().getName(),equalTo(workspaceRoot.getWorkspace().getName()));
        //assertThat(deserializtionWorkspaceRoot.getWorkspace().getName(),equalTo(workspaceRoot.getWorkspace().getId()));


    }
}
