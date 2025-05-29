package Test_Data;

import Pojos.PostsPojos.Post;
import Pojos.PostsPojos.Posts;
import Pojos.PostsPojos.Reactions;
import Pojos.User_Address_Pojo.Address;
import Pojos.User_Address_Pojo.Coordinates;

import java.util.*;

public class DummyExpectedTestData {

    public static Map<String, Object> user_With_Id_20(){
        Map<String, Object> user = new HashMap<>();
        user.put("firstName","Jackson");
        user.put("gender", "male");
        user.put("lastName", "Evans");
        user.put("email","jackson.evans@x.dummyjson.com");
        user.put("age",34);
        user.put("username", "jacksone");
        user.put("birthDate","1990-11-30");
        return user;
    }

    public static Map<String, Object> postRequestCreateNewUserData(){

        Map<String, Object> hair = new HashMap<>();
        hair.put("calor", "blue");
        hair.put("type","curly");

        Map<String, Object> newUser = new HashMap<>();
        newUser.put("firstName", "RandomName");
        newUser.put("lastName", "RandomLastName");
        newUser.put("username", "RandomUserName");
        newUser.put("email","xxxx@example.com");
        newUser.put("password","RandomPassword");
        newUser.put("hair",hair);
        return newUser;
                /*
                firstName
                lastName
                username
                email
                password   */
    }

    public static Map<String ,Object> expectedPatchData(){
        Map<String, Object> updateUserData = new HashMap<>();
        updateUserData.put("title", "Random New Title");
        updateUserData.put("price", 20.99);
        updateUserData.put("discountPercentage",12.70);
        updateUserData.put("rating", 3.40);
        updateUserData.put("stock", 1000);
        return updateUserData;
        /*
         "price": 9.99,
        "discountPercentage": 10.48,
        "rating": 2.56,
        "stock": 99,
                 */
    }
    public static Address exptected_User_3_Address_PatchData(){
        Coordinates coordinates = new Coordinates(20.0000,60.0000);
        Address address = new Address("Random Address", "Random City", "Random State", "Random State Code","Random Postal Code",coordinates,"Turkey");
        return address;
    }

    public static Posts expectedPutData(){
        List<String> tags = Arrays.asList( "Random Tags_1","Random Tags_2","Random Tags_3");
        Reactions reactions = new Reactions(100,100);
        Post post = new Post(4,"Random Title", "Random Body", tags,reactions,300,20);
        List<Post> postList = Arrays.asList(post);

        Posts posts = new Posts(postList,10,10,10);

        return posts;
    }
}
