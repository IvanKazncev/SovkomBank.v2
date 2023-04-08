package com.cleanui.test;

import com.cleanui.data.ValidRequestModel;
import com.cleanui.models.ResponseModel;
import com.cleanui.steps.Steps;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ApiCleanTest {
    ResponseModel responseModel = new ResponseModel();
    ValidRequestModel root = new ValidRequestModel();

    Steps steps = new Steps();

    public ApiCleanTest() throws IOException {
    }

    @Test
    void cleanUiTest(){
        //steps.cleanUiTest();
        System.out.println(root.getName());
    }

}
