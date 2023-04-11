package com.Cleanui.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidRequestModel {

    private String name;
    private List<ValidUrlListModel> urlList;

}
