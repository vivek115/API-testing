package API_Course;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.EncoderConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.*;

public class Create_MockRequest_Base_WithComplex_JSON {
    @BeforeClass
    public void beforeclass() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://85d206c8-ef2e-4db9-9184-76710f7913b9.mock.pstmn.io").
                addHeader("x-mock-match-request-body", "true").setConfig(config.encoderConfig(EncoderConfig.encoderConfig().
                appendDefaultContentCharsetToContentTypeIfUndefined(false)));
//setcontentType("application/json;charset=utf-8").log(logdetail.All);
        //requestSpecBuilder.addHeader("give the path of header");
        RestAssured.requestSpecification = requestSpecBuilder.build();
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).log(LogDetail.ALL);
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }
   @Test
    public void validate_post_request_payload_complex_json(){
        List<Integer> idarraylist  = new ArrayList<Integer>();
        idarraylist.add(5);
        idarraylist.add(6);
       HashMap<String,Object> betterhashmap2 = new HashMap<String, Object>();
       betterhashmap2.put("id",idarraylist);
       betterhashmap2.put("type","Regular");
       HashMap<String,Object> betterhashmap = new HashMap<String, Object>();
       betterhashmap2.put("id","1002");
       betterhashmap2.put("type","Chocolate");
       List<HashMap<String,Object>> betterarraylist = new ArrayList<HashMap<String, Object>>();
       betterarraylist.add(betterhashmap);
       betterarraylist.add(betterhashmap);
       HashMap<String,List> betterhashmap3 = new HashMap<String, List>();
       betterhashmap3.put("better",betterarraylist);
       List<String> typearraylist  = new ArrayList<String>();
       typearraylist.add("test1");
       typearraylist.add("test2");
       HashMap<String,Object> toppinghashmap2 = new HashMap<String, Object>();
       betterhashmap2.put("id",5002);
       betterhashmap2.put("type",typearraylist);
       HashMap<String,Object> toppinghashmap3 = new HashMap<String, Object>();
       betterhashmap2.put("id",5001);
       betterhashmap2.put("type","None");
       List<HashMap<String,Object>> TOPINGarraylist = new ArrayList<HashMap<String, Object>>();
       betterarraylist.add(toppinghashmap2);
       betterarraylist.add(toppinghashmap3);
       HashMap<String,Object> mainhashmap = new HashMap<String, Object>();
       mainhashmap.put("id",0001);
       mainhashmap.put("type","donut");
       mainhashmap.put("name","Cake");
       mainhashmap.put("ppu",0.55);
       mainhashmap.put("batter",betterhashmap2);
       mainhashmap.put("topping",toppinghashmap2);
       given().body(mainhashmap).when().post("/postcomplexjson").then().spec(responseSpecification);
       }
   }

