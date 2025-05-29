package Base.Config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ReUseableMethods {

    // GET request - simple
    public static Response getWithPathParam(RequestSpecification spec, String location) {
        return given()
                .spec(spec)
                .accept("application/json")
                .when()
                .get("/{location}", location);
    }

    // GET request - with string path
    public static Response getWithPathParam(RequestSpecification spec, String location, String path) {
        return given()
                .spec(spec)
                .accept("application/json")
                .pathParam("location", location)
                .pathParam("path", path)
                .when()
                .get("/{location}/{path}");
    }

    // GET request - with int path
    public static Response getWithPathParam(RequestSpecification spec, String location, int path) {
        return given()
                .spec(spec)
                .accept("application/json")
                .pathParam("location", location)
                .pathParam("path", path)
                .when()
                .get("/{location}/{path}");
    }

    // POST request
    public static Response postRequestWithParam(RequestSpecification spec, Map postData, String endpoint) {
        return given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(postData)
                .pathParam("endpoint", endpoint)
                .when()
                .post("/{endpoint}/add");
    }

    // DELETE request - int endpoint
    public static Response deleteRequestWithParam(RequestSpecification spec, String location, int endpoint) {
        return given()
                .spec(spec)
                .pathParam("location", location)
                .pathParam("endpoint", endpoint)
                .when()
                .delete("/{location}/{endpoint}");
    }

    // DELETE request - string endpoint
    public static Response deleteRequestWithParam(RequestSpecification spec, String location, String endpoint) {
        return given()
                .spec(spec)
                .pathParam("location", location)
                .pathParam("endpoint", endpoint)
                .when()
                .delete("/{location}/{endpoint}");
    }

    // PUT request - string path
    public static Response putRequestWithParam(RequestSpecification spec, Object resource, String location, String path) {
        return given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(resource)
                .pathParam("location", location)
                .pathParam("path", path)
                .when()
                .put("/{location}/{path}");
    }

    // PUT request - int path
    public static Response putRequestWithParam(RequestSpecification spec, Object resource, String location, int path) {
        return given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(resource)
                .pathParam("location", location)
                .pathParam("path", path)
                .when()
                .put("/{location}/{path}");
    }

    // PATCH request - string path
    public static Response patchRequestWithParam(RequestSpecification spec, Object resource, String location, String path) {
        return given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(resource)
                .pathParam("location", location)
                .pathParam("path", path)
                .when()
                .patch("/{location}/{path}");
    }

    // PATCH request - int path
    public static Response patchRequestWithParam(RequestSpecification spec, Object resource, String location, int path) {
        return given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(resource)
                .pathParam("location", location)
                .pathParam("path", path)
                .when()
                .patch("/{location}/{path}");
    }



    public static int getCount(Response response, String path) {
        return response.jsonPath().getList(path).size();  //get size from path
    }

    public static Map<String, Object> get_User_With_Specific_Id(Response response, int id, String location) {
        return response.jsonPath().getMap(location + ".find{it.id == " + id + " }");
    }

    public static void print_The_Desired_Data(String info, Map value) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String prettyJson = mapper.writeValueAsString(value);
        System.out.println(info + prettyJson);
    }

    public static List<Map<String, Object>> findUsersByAllMatch(Response response, String location, String equalType, String equalValue, String expectedResult) {
        return response.jsonPath().getList(location + ".findAll{it." + equalType + "== '" + equalValue + "' }." + expectedResult);
        //users.findAll{it.email== 'xxx@example.com'.id or somthing}
        //location.findAll{it.equalType == 'equalValue'}.expectedResult
    }

    public static List<Map<String, Object>> findUsersByPartialMatch(Response response, String location, String field, String value) {
        return response.jsonPath().getList(location + ".findAll{ it." + field + ".contains('" + value + "') }");
        //location.findAll{it.field.contains('value')}
    }

    public static Object getNestedValue(Map<String, Object> map, String outerKey, String innerKey) {
        return ((Map) map.get(outerKey)).get(innerKey);
    }

    //De-serialization map:
    public static Map map_De_Serialization(Response response){
        return response.as(Map.class);
    }

}
