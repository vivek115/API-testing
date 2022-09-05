package API_Course;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static io.restassured.RestAssured.given;

public class Download_File {
    // it will automatically download the file using rest assured
    // rest assured support extracting responses as byte array as well as input stream
    @Test
    public void download_file() throws IOException {
        byte[] bytes = given().baseUri("https://raw.githubusercontent.com").log().all().when().
                get("https://github.com/appium/appium/blob/master/sample-code/apps/ApiDemos-debug.apk").
                then().log().all().extract().response().asByteArray();
        OutputStream os = new FileOutputStream(new File("ApiDemos-debug.apk"));
        os.write(bytes);
        os.close();
    }
}
