package dev.stiebo;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class AiControllerTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/api/poem")
          .then()
             .statusCode(200);
    }

}