package com.demoqa.page;

import com.demoqa.elements.*;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormPage {

    private final static String TITLE_TEXT = "Student Registration Form";
    Url url = new Url("https://demoqa.com/automation-practice-form", "Practice Form");
    public final Input firstName = new Input("Имя", $("#firstName"));
    public final Input lastname = new Input("Фамилия", $("#lastName"));
    Input email = new Input("Почту", $("#userEmail"));
    public final Button genderButton = new Button("Выбор пола", $(".custom-control-label"));
    public final Input telephoneNumber = new Input("Телефон", $("#userNumber"));
    Calendar calendar = new Calendar("Practice Form", $(By.xpath("//DIV[@class='react-datepicker__day react-datepicker__day--008'][text()='8']")), $(".react-datepicker__month-select"), $(".react-datepicker__year-select"), $("#dateOfBirthInput"));
    InputWithAutoFill subjects = new InputWithAutoFill("Предметы", $("#subjectsInput"));
    Button hobbies = new Button("Хобби", $("#hobbiesWrapper"));
    UpLoadFile picture = new UpLoadFile("Изображение", $("#uploadPicture"));
    Input currentAddress = new Input("Адрес", $("#currentAddress"));
    DropDownMenu state = new DropDownMenu("Штат", $("#state"), $("#stateCity-wrapper"));
    DropDownMenu city = new DropDownMenu("Город", $("#city"), $("#stateCity-wrapper"));
    Button submit = new Button("Submit", $("#submit"));


    public void openPage() {
        url.openUrl();
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
    }

    public void setFirstName(String value) {
        firstName.setValue(value);
    }

    public void setLastName(String value) {
        lastname.setValue(value);
    }

    public void setEmail(String value) {
        email.setValue(value);
    }

    public void setGender() {
        genderButton.click();
    }

    public void setTelephoneNumber(String value) {
        telephoneNumber.setValue(value);
    }

    public void setCalendar(String month, String year, String day) {
        calendar.setCalendar(month, year, day);
    }

    public void setSubjects(String value) {
        subjects.setSubjects(value);
    }

    public void setHobbies() {
        hobbies.click();
    }

    public void setPicture(String value) {
        picture.upLoadFile(value);
    }

    public void setCurrentAddress(String value) {
        currentAddress.setValue(value);
    }

    public void setState(String value) {
        state.set(value);
    }

    public void setCity(String value) {
        city.set(value);
    }

    public void submit() {
        submit.click();
    }

    public String InputGetCssValue(@NotNull Input selector, String value) {
        String color = selector.getCssValue(value);
        return color;
    }

    public String ButtonGetCssValue(@NotNull Button selector, String value) {
        String color = selector.getCssValue(value);
        return color;
    }

}
