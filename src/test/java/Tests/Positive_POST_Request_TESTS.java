package Tests;

import Base.Config.BaseTest;
import Base.Config.ReUseableMethods;
import Test_Data.DummyExpectedTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.Map;

import static org.hamcrest.Matchers.*;

public class Positive_POST_Request_TESTS extends BaseTest {

    private SoftAssert softAssert = new SoftAssert();

    //  TC-001: Creating a new user;
    @Test
    public void tc_001_Create_New_User() {
        //create expected post data:
        Map <String,Object> expectedPostData = DummyExpectedTestData.postRequestCreateNewUserData();
        //Post request with post data;
        Response usersPost_Request = ReUseableMethods.postRequestWithParam(spec, expectedPostData, "users");

        //De-serialization:
        Map<String, Object> actualUserData = usersPost_Request.as(Map.class);

        //Status code, content type and body asseritons;
        /*
        Since the address I use is a mock service, I cannot check it by sending a get request to the newly created user,
        so I verify it using the data corresponding to the request I send!
         */
        usersPost_Request.then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body(
                        "firstName", equalTo(expectedPostData.get("firstName")),
                        "lastName", equalTo(expectedPostData.get("lastName")),
                        "username", equalTo(expectedPostData.get("username")),
                        "email", equalTo(expectedPostData.get("email")),
                        "password", equalTo(expectedPostData.get("password")),
                        "hair.color", equalTo(ReUseableMethods.getNestedValue(expectedPostData,"hair","color")),
                        "hair.type", equalTo(ReUseableMethods.getNestedValue(expectedPostData,"hair","type")));

    }

    //  TC-002:   Create a new user and delete it;
    @Test
    public void tc_002_Create_New_User_And_Delete_It(){
        /*
        READ ME!:
        // This test does not have any real effect on the DELETE operation since the dummyjson API is used.
        // Since the API is dummy, data cannot be deleted. In the real scenario, 200 or 204 is expected.
         */


        //Create new user;
        Response newUser_Response = ReUseableMethods.postRequestWithParam(spec,DummyExpectedTestData.postRequestCreateNewUserData(),"users");
        System.out.println("Created new user: " + newUser_Response.asPrettyString());

        //take new user data id;
        int newUserId = newUser_Response.jsonPath().getInt("id");
        System.out.println("Created new user id: " + newUserId);

        //assert post request:
        newUser_Response.then()
                .statusCode(201)
                .contentType(ContentType.JSON);


        //Delete request with new user id:
        Response delete_NewUser_withID = ReUseableMethods.deleteRequestWithParam(spec,"users",newUserId);

        //Assert delete request:
        delete_NewUser_withID.then().statusCode(200);

        //Get request for deleted user;
        Response afterDelete_Response = ReUseableMethods.getWithPathParam(spec,"users",newUserId);

        //assert after delete:
        Assert.assertEquals("Status code is not 404 ", 404,afterDelete_Response.getStatusCode());

    }












}
