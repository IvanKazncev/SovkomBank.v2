package com.demoqa.page;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultFormPage {
    private final static String TITLE_TEXT = "Thanks for submitting the form";

    public void checkVisible() {
        System.out.println("Итоговая таблица загрузилась");
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(TITLE_TEXT));
    }

    public ResultFormPage checkResult(String key, String value, String name) {
        System.out.println("Проверяем" + " " + name);
        $(".table-responsive table").$(byText(key))
                .parent().shouldHave(text(value));
        return this;
    }
}
