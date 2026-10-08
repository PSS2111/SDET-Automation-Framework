package api;

import api.models.User;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserApiTest extends ApiBase {

    @Test(groups = "smoke")
    public void getUserById() {

        String userId = "2";

        given()
                .spec(requestSpec)
                .pathParam("id", userId)
                .log().all()

                .when()
                .get("/api/users/{id}")

                .then()
                .log().ifValidationFails()
                .spec(responseSpec)
                .statusCode(200)
                .body("data.id", equalTo(2))
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"));
    }


    @Test(groups = "regression")
    public void createUser() {

        User user = new User("RAM", "SDET");

        String userId =
                given()
                        .spec(requestSpec)
                        .body(user)
                        .log().all()

                        .when()
                        .post("/api/users")

                        .then()
                        .log().ifValidationFails()
                        .spec(responseSpec)
                        .statusCode(201)
                        .extract()
                        .path("id");

        System.out.println("Created User ID: " + userId);
    }


    @Test(groups = "regression")
    public void updateUser() {

        User user = new User(
                "RAM Updated",
                "Senior SDET"
        );

        given()
                .spec(requestSpec)
                .pathParam("id", "2")
                .body(user)
                .log().all()

                .when()
                .put("/api/users/{id}")

                .then()
                .log().ifValidationFails()
                .spec(responseSpec)
                .statusCode(200)
                .body("name", equalTo("RAM Updated"))
                .body("job", equalTo("Senior SDET"));
    }


    @Test(groups = "regression")
    public void deleteUser() {

        given()
                .spec(requestSpec)
                .pathParam("id", "2")
                .log().all()

                .when()
                .delete("/api/users/{id}")

                .then()
                .log().ifValidationFails()
                .statusCode(204);
    }
}