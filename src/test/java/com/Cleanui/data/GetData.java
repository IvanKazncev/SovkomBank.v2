package com.Cleanui.data;

import com.Cleanui.helpers.ReadFile;

import java.io.IOException;

public class GetData {
    ReadFile readFile = new ReadFile();

    public GetData() throws IOException {
    }

    public String getUrl(String web) {
        var website = readFile.getUrl(web);
        return website;

    }
}
