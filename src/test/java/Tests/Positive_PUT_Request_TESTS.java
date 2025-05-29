package Tests;

import Base.Config.BaseTest;
import Base.Config.ReUseableMethods;
import Pojos.PostsPojos.Post;
import Pojos.PostsPojos.Posts;
import Test_Data.DummyExpectedTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

public class Positive_PUT_Request_TESTS extends BaseTest {
    private SoftAssert softAssert = new SoftAssert();


    /*
    READ ME:
    The PUT request in this project was implemented to simulate the update operation of an existing post using a mock API. Although the request is
    successfully sent and receives a 201 Created response code, the data returned does not reflect the changes that were sent.
    This is because the mock API is not stateful, meaning it does not actually persist or store the changes made via the request. As a result:
    The updated data is not stored, and
    Subsequent GET requests return the original, unchanged data,
    Even the PUT response itself sometimes returns default/static data, not what was sent.
    In a real API, a successful PUT would update the resource on the server, and a following GET would return the updated data. But with mock services,
    this full behavior can't be verified.
    Therefore, PUT test assertions fail if they rely on actual data change or on post-update GET requests.
     */

    @Test
    public void tc_001_PutRequest() {
        //Get request for 2.post data + get assertions:
        Response getResponse = ReUseableMethods.getWithPathParam(spec, "posts",2);
        getResponse.then().statusCode(200).contentType(ContentType.JSON);
        //2. put data value:
        System.out.println("2. Post data: \n" + getResponse.asPrettyString());

        //Create put data from DummyExpectedTestData:
        Posts expectedPutData = DummyExpectedTestData.expectedPutData();

        //Send put request address:
        Response afterPutRequest_Response = ReUseableMethods.putRequestWithParam(spec,expectedPutData,"posts",2);
        afterPutRequest_Response.then().statusCode(201).contentType(ContentType.JSON);
        System.out.println("Gelen data: " + afterPutRequest_Response.asPrettyString());

        //Real service scenario:
        //After put update get request:
//        Response afterPutRequest_Get_Response = ReUseableMethods.getWithPathParam(spec,"posts",2);
//        afterPutRequest_Get_Response.then()
//                .statusCode(200)
//                .contentType(ContentType.JSON);
//        //De-serialization for updatedData
//        Post actualData = afterPutRequest_Get_Response.as(Post.class);
//
//        //Assertions:
//        softAssert.assertEquals(
//                actualData.getId(),
//                expectedPutData.getPosts().get(0).getId(),
//                "");
//        softAssert.assertEquals(
//                actualData.getBody(),
//                expectedPutData.getPosts().get(0).getBody(),
//                "");
//
//        //Reactions:
//        softAssert.assertEquals(
//                actualData.getReactions().getLikes(),
//                expectedPutData.getPosts().get(0).getReactions().getLikes(),
//                "");
//        softAssert.assertEquals(
//                actualData.getReactions().getDislikes(),
//                expectedPutData.getPosts().get(0).getReactions().getDislikes(),
//                "");
//        //Tags:
//        softAssert.assertEquals(
//                actualData.getTags().get(0),
//                expectedPutData.getPosts().get(0).getTags().get(0),
//                "");
//        softAssert.assertEquals(
//                actualData.getTags().get(1),
//                expectedPutData.getPosts().get(0).getTags().get(1),
//                "");
//        softAssert.assertEquals(
//                actualData.getTags().get(2),
//                expectedPutData.getPosts().get(0).getTags().get(2),
//                "");
//        softAssert.assertEquals(
//                actualData.getUserId(),
//                expectedPutData.getPosts().get(0).getUserId(),
//                "");
//        softAssert.assertEquals(
//                actualData.getViews(),
//                expectedPutData.getPosts().get(0).getViews(),
//                "");
//        softAssert.assertAll();


        //Codes for mock Serices
        //De-serialization for updatedData
        Post actualData = afterPutRequest_Response.as(Post.class);

        //Assertions:
        softAssert.assertEquals(
                actualData.getId(),
                expectedPutData.getPosts().get(0).getId(),
                "");
        softAssert.assertEquals(
                actualData.getBody(),
                expectedPutData.getPosts().get(0).getBody(),
                "");

        //Reactions:
        softAssert.assertEquals(
                actualData.getReactions().getLikes(),
                expectedPutData.getPosts().get(0).getReactions().getLikes(),
                "");
        softAssert.assertEquals(actualData.getReactions().getDislikes(),
                expectedPutData.getPosts().get(0).getReactions().getDislikes(),
                "");
        //Tags:
        softAssert.assertEquals(
                actualData.getTags().get(0),
                expectedPutData.getPosts().get(0).getTags().get(0),
                "");
        softAssert.assertEquals(
                actualData.getTags().get(1),
                expectedPutData.getPosts().get(0).getTags().get(1),
                "");
        softAssert.assertEquals(
                actualData.getTags().get(2),
                expectedPutData.getPosts().get(0).getTags().get(2),
                "");
        softAssert.assertEquals(
                actualData.getUserId(),
                expectedPutData.getPosts().get(0).getUserId(),
                "");
        softAssert.assertEquals(
                actualData.getViews(),
                expectedPutData.getPosts().get(0).getViews(),
                "");
        softAssert.assertAll();

    }
}
