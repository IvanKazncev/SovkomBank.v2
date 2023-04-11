package com.Cleanui.steps;

import com.Cleanui.models.ResponseModel;

import static io.restassured.RestAssured.given;

public class Steps {

    public Steps() {
    }

    public ResponseModel apiTest(String website, Integer statusCode) {
        ResponseModel response = given()
                .log().all()
                .contentType("multipart/form-data")
                .multiPart("url", website)
                .when()
                .post("https://cleanuri.com/api/v1/shorten")
                .then()
                .log().status()
                .log().body()
                .statusCode(statusCode)
                .extract().body().as(ResponseModel.class);
        return response;
    }
}
