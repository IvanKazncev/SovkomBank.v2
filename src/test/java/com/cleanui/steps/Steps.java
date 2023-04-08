package com.cleanui.steps;

import com.cleanui.data.ValidRequestModel;
import com.cleanui.helpers.Parser;
import com.cleanui.models.ResponseModel;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Steps {

    Parser parser = new Parser();
    ValidRequestModel validRequestModel = parser.parser();

    public Steps() throws IOException {
    }

    void apiTest()  {


        List<ResponseModel> response = Collections.singletonList(given()
                .log().all()
                .contentType("multipart/form-data")
                .multiPart(url, website)
                .when()
                .post("https://cleanuri.com/api/v1/shorten")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().body().as(ResponseModel.class));
}

