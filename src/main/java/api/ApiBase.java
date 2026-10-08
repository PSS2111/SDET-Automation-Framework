package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ApiBase {

    protected RequestSpecification requestSpec;
    protected ResponseSpecification responseSpec;

    public ApiBase() {

        requestSpec =
                new RequestSpecBuilder()
                        .setBaseUri("https://reqres.in")
                        .setContentType("application/json")
                        .build();

        responseSpec =
                new ResponseSpecBuilder()
                        .expectHeader(
                                "Content-Type",
                                org.hamcrest.Matchers.containsString("application/json")
                        )
                        .build();
    }
}