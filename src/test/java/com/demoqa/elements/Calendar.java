package com.demoqa.elements;

import com.codeborne.selenide.SelenideElement;

public class Calendar {
    private final String name;
    private final SelenideElement selectorCalendar;
    private final SelenideElement selectorDay;
    private final SelenideElement selectorMonth;
    private final SelenideElement selectorYear;

    public Calendar(String name, SelenideElement selectorDay,
                    SelenideElement selectorMonth, SelenideElement selectorYear, SelenideElement selectorCalendar) {

        this.name = name;
        this.selectorDay = selectorDay;
        this.selectorMonth = selectorMonth;
        this.selectorYear = selectorYear;
        this.selectorCalendar = selectorCalendar;
    }

    public void setCalendar(String month, String year, String day) {
        System.out.println("Заполняем календарь" + " " + name);
        selectorCalendar.click();
        selectorMonth.selectOption(month);
        selectorYear.selectOption(year);
        selectorDay.click();
    }
}
