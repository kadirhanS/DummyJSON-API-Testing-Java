package Tests;

import Base.Config.BaseTest;
import Base.Config.ReUseableMethods;
import Test_Data.DummyExpectedTestData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.http.ContentType;
import io.restassured.internal.mapping.GsonMapper;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import javax.accessibility.AccessibleAttributeSequence;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Positive_GET_TESTS extends BaseTest {

    private SoftAssert softAssert = new SoftAssert();

    //  TC-001 : Get all users with count from dummy json website;
    @Test
    public void tc_001_GET_All_Users_From_DrummyJson() {
        //get all users:
        Response all_Users = ReUseableMethods.getWithPathParam(spec, "users");

        //assertions and log all:
        all_Users.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log().all();

        //get all users count:
        int usersCount = ReUseableMethods.getCount(all_Users, "users");
        System.out.println("All users count: " + usersCount);

        //assert users count:
        Assert.assertEquals("Users count not equals to 30", 30, usersCount);

    }

    //  TC-002 : Get user with id value 20;
    @Test
    public void tc_002_Fetch_User_With_Id_20() throws JsonProcessingException {
        //Get request:
        Response response = ReUseableMethods.getWithPathParam(spec, "users");

        //assertions And logs:
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log().all();
        // 20. user:
        Map<String, Object> user = ReUseableMethods.get_User_With_Specific_Id(response, 20, "users");

        //create expectedDAta
        Map expectedData = DummyExpectedTestData.user_With_Id_20();

        //assertions:
        softAssert.assertEquals(user.get("username"),
                expectedData.get("username"),
                "User names is not equals");
        softAssert.assertEquals(user.get("lastname"), expectedData.get("lastname"),
                "Last names is not equals");
        softAssert.assertEquals(user.get("age"), expectedData.get("age"),
                "Age values is not equals");
        softAssert.assertEquals(user.get("gender"), expectedData.get("gender"),
                "Gender values is not equals");
        softAssert.assertEquals(user.get("email"), expectedData.get("email"),
                "E-mail values is not equals");
        softAssert.assertEquals(user.get("username"), expectedData.get("username"),
                "Username values is not equals");
        softAssert.assertEquals(user.get("birthDate"), expectedData.get("birthDate"),
                "Birth day values is not equals");
        softAssert.assertAll();

        //Print 20.user data:
        ReUseableMethods.print_The_Desired_Data( "20. user data is: ", user);


    }

    // TC-003: Fetching data according to the requested information;
    @Test
    public void tc_003_Filter_By_Desired_Value() {
        //Get request:
        Response response = ReUseableMethods.getWithPathParam(spec, "users");

        //assert:
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON);
        //get users email contains '@x':
        List<Map<String, Object>> responseUsers = ReUseableMethods.findUsersByPartialMatch(response, "users", "email", "@x");
        int counter = 1;
        for (Map<String, Object> value : responseUsers) {
            System.out.println(counter + ". user e-mail: " + value.get("email"));
            counter++;
        }
        System.out.println("Response user size: " + responseUsers.size());


        //assertions:
        Assert.assertEquals(30, responseUsers.size());

    }


}
