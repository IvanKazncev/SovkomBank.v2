package com.demoqa.elements;

import com.codeborne.selenide.SelenideElement;

public class UpLoadFile {
    private final String name;
    private final SelenideElement selector;

    public UpLoadFile(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }

    public void upLoadFile(String file) {
        System.out.println("Загружаем" + " " + name);
        selector.uploadFromClasspath(file);
    }
}
