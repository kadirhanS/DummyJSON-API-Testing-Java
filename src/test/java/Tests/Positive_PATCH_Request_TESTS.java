package Tests;

import Base.Config.BaseTest;
import Base.Config.ReUseableMethods;
import Pojos.User_Address_Pojo.Address;
import Test_Data.DummyExpectedTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import org.testng.internal.junit.ArrayAsserts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Positive_PATCH_Request_TESTS extends BaseTest {
    private SoftAssert sf = new SoftAssert();


    @Test
    public void tc_001_Patch_UserData_1_Title_Price_Rating_Stock() {
        //first, get the data to updated;
        Response beforeUpdateData_Response = ReUseableMethods.getWithPathParam(spec, "products", 1);
        //Assertion for get request:
        beforeUpdateData_Response.then()
                .statusCode(200)
                .contentType(ContentType.JSON);
        //write data:
        System.out.println("Before update data: \n" + beforeUpdateData_Response.asPrettyString());

        //Create expected data from DummyExpectedTestData class:
        Map<String, Object> expectedPatchData = DummyExpectedTestData.expectedPatchData();

        //Create patch request:
        Response afterPatchRequestResponse = ReUseableMethods.patchRequestWithParam(spec, expectedPatchData, "products", 1);
        //assert patch request:
        afterPatchRequestResponse.then()
                .statusCode(200)
                .contentType(ContentType.JSON);


        //de-serialization to response:
        Map<String, Object> actualResponse = ReUseableMethods.map_De_Serialization(afterPatchRequestResponse);

        //Write updated data:
//        Response afterUpdate = ReUseableMethods.getWithPathParam(spec,"products",1); --> Real services scenario
//        System.out.println("After Update data: \n"  + afterUpdate.asPrettyString()); --> Real services scenario

        System.out.println("Updated data from PATCH response:" + afterPatchRequestResponse.asPrettyString());

        //assert final data:
        sf.assertEquals(actualResponse.get("title"), expectedPatchData.get("title"),
                "Title values is not updated!");
        sf.assertEquals(actualResponse.get("price"), expectedPatchData.get("price"),
                "Price value is not updated!");
        sf.assertEquals(actualResponse.get("discountPercentage"), expectedPatchData.get("discountPercentage"),
                "Discount Percentage values is not updated!");
        sf.assertEquals(actualResponse.get("rating"), expectedPatchData.get("rating"),
                "Rating values is not updated!");
        sf.assertEquals(actualResponse.get("stock"), expectedPatchData.get("stock"),
                "Stock values is not updated!");
        sf.assertAll();


    }

    @Test
    public void tc_002_Patch_UserData_3_Address() {
        //Get request for user_3;
        Response beforeUpdate_Data = ReUseableMethods.getWithPathParam(spec, "users", 3);
        beforeUpdate_Data.then()
                .statusCode(200)
                .contentType(ContentType.JSON);

        //Write beforeUpdate_Data and de-serialization;
        Address user_3_AddressInfo = beforeUpdate_Data.jsonPath().getObject("address", Address.class);
        System.out.println("User 3 Address Info: \n" +
                "Address: " + user_3_AddressInfo.getAddress() + "\n" +
                "city: " + user_3_AddressInfo.getCity() + "\n" +
                "state: " + user_3_AddressInfo.getState() + "\n" +
                "stateCode: " + user_3_AddressInfo.getStateCode() + "\n" +
                "postalCode: " + user_3_AddressInfo.getPostalCode() + "\n" +
                "coordinates: " + "\n" +
                "lat: " + user_3_AddressInfo.getCoordinates().getLat() + "\n" +
                "lng: " + user_3_AddressInfo.getCoordinates().getLng() + "\n" +
                "country: " + user_3_AddressInfo.getCountry());

        //create PATCH request:
        Address expectedPatch_Data = DummyExpectedTestData.exptected_User_3_Address_PatchData();
        Response afterPatchToAddress = ReUseableMethods.patchRequestWithParam(spec, expectedPatch_Data, "users", 3);

        // NOTE: We are using a mock API in this test, which does not actually persist data updates.
        // Although we send a PATCH request to update the user's address,
        // the GET request afterward still returns the original unmodified data.
        // Therefore, we are not performing assertions on the updated values.
        // This behavior is expected when working with mock services that simulate, but do not store, data changes.

        //Assert patch request:
        afterPatchToAddress.then()
                .statusCode(200)
                .contentType(ContentType.JSON);

        //After patch address info:
        System.out.println("After patch addres: " + afterPatchToAddress.asPrettyString());
    }

    @Test
    public void tc_003_Patch_UserData_10_Username(){
        //Get request for user 10;
        Response beforeUpdateUsernameData = ReUseableMethods.getWithPathParam(spec,"users",10);
        beforeUpdateUsernameData.then()
                .statusCode(200)
                .contentType(ContentType.JSON);
        String oldUsername = beforeUpdateUsernameData.jsonPath().getString("username");
        System.out.println("User 10 username value is: " + oldUsername);

        //create new username data;
        Map<String, Object> mapForNewUsername = new HashMap<>();
        mapForNewUsername.put("username", "Random Username");

        // NOTE: Unlike nested objects (e.g., address), the username field exists directly at the root level.
        // Therefore, PATCH requests to update username work correctly even with a mock API,
        // because the returned response includes the updated field directly and in a predictable structure.

        //Create patch request:
        Response after_Patch_toUsername = ReUseableMethods.patchRequestWithParam(spec,mapForNewUsername,"users",10);
        after_Patch_toUsername.then()
                .statusCode(200)
                .contentType(ContentType.JSON);

        //write new username:
        String newUsername = after_Patch_toUsername.jsonPath().getString("username");
        System.out.println("New username is : " + newUsername);

        //assertion for username:
        sf.assertEquals(newUsername,mapForNewUsername.get("username"),
                "Username is not updated!");
        sf.assertAll();


    }
}
