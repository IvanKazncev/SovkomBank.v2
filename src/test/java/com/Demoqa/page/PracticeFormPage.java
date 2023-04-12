package com.Demoqa.page;

import com.Demoqa.elements.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormPage {


    private final String TITLE_TEXT = "Student Registration Form";
    private final Url url = new Url("https://demoqa.com/automation-practice-form", "Practice Form");
    private final Input firstName = new Input("Имя", $("#firstName"));
    private final Input lastname = new Input("Фамилия", $("#lastName"));
    private final Input email = new Input("Почту", $("#userEmail"));
    private final Button genderButton = new Button("Выбор пола", $(".custom-control-label"));
    private final Input telephoneNumber = new Input("Телефон", $("#userNumber"));
    private final Calendar calendar = new Calendar("Practice Form", $(By.xpath("//DIV[@class='react-datepicker__day" +
            " react-datepicker__day--008'][text()='8']")), $(".react-datepicker__month-select"),
            $(".react-datepicker__year-select"), $("#dateOfBirthInput"));
    private final InputWithAutoFill subjects = new InputWithAutoFill("Предметы", $("#subjectsInput"));
    private final Button hobbies = new Button("Хобби", $("#hobbiesWrapper"));
    private final UpLoadFile picture = new UpLoadFile("Изображение", $("#uploadPicture"));
    private final Input currentAddress = new Input("Адрес", $("#currentAddress"));
    private final DropDownMenu state = new DropDownMenu("Штат", $("#state"), $("#stateCity-wrapper"));
    private final DropDownMenu city = new DropDownMenu("Город", $("#city"), $("#stateCity-wrapper"));
    private final Button submit = new Button("Submit", $("#submit"));


    public PracticeFormPage openPage() {
        url.openUrl();
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    public PracticeFormPage setLastName(String value) {
        lastname.setValue(value);
        return this;
    }

    public PracticeFormPage setEmail(String value) {
        email.setValue(value);
        return this;
    }

    public PracticeFormPage setGender() {
        genderButton.click();
        return this;
    }

    public PracticeFormPage setTelephoneNumber(String value) {
        telephoneNumber.setValue(value);
        return this;
    }

    public PracticeFormPage setCalendar(String month, String year, String day) {
        calendar.setCalendar(month, year, day);
        return this;
    }

    public PracticeFormPage setSubjects(String value) {
        subjects.setSubjects(value);
        return this;
    }

    public PracticeFormPage setHobbies() {
        hobbies.click();
        return this;
    }

    public PracticeFormPage setPicture(String value) {
        picture.upLoadFile(value);
        return this;
    }

    public PracticeFormPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public PracticeFormPage setState(String value) {
        state.set(value);
        return this;
    }

    public PracticeFormPage setCity(String value) {
        city.set(value);
        return this;
    }

    public PracticeFormPage submit() {
        submit.click();
        return this;
    }

    public String InputGetCssValueFirstName() {
        String color = firstName.getCssValue("border-color");
        return color;

    }

    public String InputGetCssValueLastName() {
        String color = lastname.getCssValue("border-color");
        return color;

    }

    public String InputGetCssValueTelephoneNumber() {
        String color = telephoneNumber.getCssValue("border-color");
        return color;

    }

    public String ButtonGetCssValueGender() {
        String color = genderButton.getCssValue("color");
        return color;

    }

}
