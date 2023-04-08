package com.cleanui.helpers;

import com.cleanui.data.ValidRequestModel;
import com.google.gson.Gson;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
    Gson gson = new Gson();
    public ValidRequestModel parser() throws IOException {

        File file = new File("C:\\Users\\Рубиик\\IdeaProjects\\SovkomBank.v2\\src\\test\\resources\\Cleanui.json");
        try (FileReader reader = new FileReader(file)) {
            return gson.fromJson(reader, ValidRequestModel.class);
        }
    }
}
