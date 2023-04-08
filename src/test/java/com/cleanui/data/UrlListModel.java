package com.cleanui.data;

import lombok.Data;

@Data
public class UrlListModel {
    public UrlListModel(String url, String website) {
        this.url = url;
        this.website = website;
    }

    public String getUrl() {
        return url;
    }

    public String getWebsite() {
        return website;
    }

    private String url;
    private String website;
}

