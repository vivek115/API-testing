package API_Course;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import java.util.Base64;

public class Basic_Authentication {
    @Test
     public void authentication(){
        RestAssured.baseURI="https://api.getpostman.com/collections";
        RequestSpecification request = RestAssured.given();
        String credentials = "myusername:myPassword";
        String base64Encoded = Base64.getEncoder().encodeToString(credentials.getBytes());
        System.out.println("encoded = " + base64Encoded);
        byte[] decodedBytes = Base64.getDecoder().decode(base64Encoded);
        System.out.println("Decoded = " + new String(decodedBytes));
        request.header("Authorization","Basic "+base64Encoded);
     }
//    public static void main(String[] args){
//        String usernameColonPassword = "myusername:myPassword";
//       String base64Encoded = Base64.getEncoder().encodeToString(usernameColonPassword.getBytes());
//        System.out.println("encoded = " + base64Encoded);
//        byte[] decodedBytes = Base64.getDecoder().decode(base64Encoded);
//        // created new instance to string
//        System.out.println("Decoded = " + new String(decodedBytes));
//    }
}
