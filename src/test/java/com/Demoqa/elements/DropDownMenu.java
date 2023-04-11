package com.Demoqa.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;

public class DropDownMenu {
    private final String name;
    private final SelenideElement clickSelector;
    private final SelenideElement choiceSelector;

    public DropDownMenu(String name, SelenideElement clickSelector, SelenideElement citySelector) {
        this.name = name;
        this.clickSelector = clickSelector;
        this.choiceSelector = citySelector;
    }

    public void set(String value) {
        System.out.println("Выбираем" + " " + name);
        clickSelector.click();
        choiceSelector.$(byText(value)).click();
    }
}
