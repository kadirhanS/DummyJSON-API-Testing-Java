package Tests;

import Base.Config.BaseTest;
import Base.Config.ReUseableMethods;
import Test_Data.DummyExpectedTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class Positive_DELETE_Request_TESTS extends BaseTest {

    @Test
    public void TC_001_CreateUserAndDeleteIt() {
        //Codes for real services scenario
        //Create user data:
//        Map<String, Object> newUserForDelete = DummyExpectedTestData.postRequestCreateNewUserData();

        //Create post request with newUserForDelete body:
//        Response postRequestResponse = ReUseableMethods.postRequestWithParam(spec, newUserForDelete, "users");
        //assertion for post request:
//        postRequestResponse.then()
//                .statusCode(201)
//                .contentType(ContentType.JSON);

        // Extract user ID for deletion
//        int idForDelete = postRequestResponse.jsonPath().getInt("id");
//        System.out.println("New user id is: " + idForDelete);

        // Send DELETE request to remove the newly created user.:
//        Response deleteRequestResponse = ReUseableMethods.deleteRequestWithParam(spec, "users", idForDelete);
//        deleteRequestResponse.then()
//                .statusCode(200);

        // Optional: assert response message if available
        // Assert.assertEquals(deleteRequestResponse.jsonPath().getString("message"), "User deleted successfully");

        // Verify user is deleted by sending GET request (should return 404)
//        Response getRequestForAfterDelete = ReUseableMethods.getWithPathParam(spec, "users", idForDelete);
//        getRequestForAfterDelete.then()
//                .statusCode(404);

        //Codes for mock services:
        Response deleteRequestResponse = ReUseableMethods.deleteRequestWithParam(spec, "users", 2);
        Boolean isDeleted = deleteRequestResponse.jsonPath().get("isDeleted");
        deleteRequestResponse.then()
                .statusCode(200);
        System.out.println("is deleted ? : " + isDeleted);
        Assert.assertTrue("user 2 is not deleted", isDeleted);



        /*
        NOTE:
            The lines for dynamically creating a new user and deleting it are commented out.
            This is because we are using a mock API that does not persist data.
            In a real API test, we would POST a new user, DELETE it, and then GET it to verify deletion (expecting a 404).
            Since the mock server doesn't support actual creation or deletion, we directly call DELETE on a predefined user ID (e.g., user 2).
            We also validate the deletion based on the 'isDeleted' field returned in the response.
 */

    }

}
