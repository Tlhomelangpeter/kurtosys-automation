package api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class KurtoSystemApi {
    @Test
    public void kurtoSysRestApiTest() {
        RestAssured.baseURI = "https://www.kurtosys.com";

        given()
                .when()
                .get("/")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .header("Server", "cloudflare")
                .and()
                .time(lessThan(2000L));
    }
}