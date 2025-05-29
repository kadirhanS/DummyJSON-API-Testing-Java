package Base.Config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseTest {

    protected RequestSpecification spec;

    @Before
    public void setUpSpec() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://dummyjson.com")
                .setContentType("application/json")
                .build();
    }
}
