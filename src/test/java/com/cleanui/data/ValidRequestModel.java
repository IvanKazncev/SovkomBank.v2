package com.cleanui.data;

import lombok.Data;

import java.util.List;

@Data
public class ValidRequestModel {

  private String name;
  private List<UrlListModel> urlListModels;


}
