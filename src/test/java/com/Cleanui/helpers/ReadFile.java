package com.Cleanui.helpers;

import com.Cleanui.models.ValidRequestModel;
import com.Cleanui.models.ValidUrlListModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ReadFile {
    ObjectMapper objectMapper = new ObjectMapper();
    File file = new File("src/test/resources/Cleanui.json");
    private ValidRequestModel ob = objectMapper.readValue(file, ValidRequestModel.class);

    public ReadFile() throws IOException {
    }

    public String getUrl(String website) {
        return ob.getUrlList().stream().filter(x -> x.getWebsite().equals(website)).map(ValidUrlListModel::getUrl)
                .findFirst().orElseThrow(() -> new AssertionError("Нет ссылки"));
    }
}
