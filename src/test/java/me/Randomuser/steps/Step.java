package me.Randomuser.steps;

import me.Randomuser.models.ResultModel;

import java.lang.reflect.Type;

import static io.restassured.RestAssured.given;

public class Step {
    public ResultModel randomuserApiTest(String gender, Integer results, String url, Integer statusCode) {
        ResultModel response = given()
                .log().uri()
                .queryParam("gender", gender)
                .queryParam("results", results)
                .when()
                .get(url)
                .then().log().all()
                .statusCode(statusCode)
                .extract().as((Type) ResultModel.class);
        return response;
    }
}
