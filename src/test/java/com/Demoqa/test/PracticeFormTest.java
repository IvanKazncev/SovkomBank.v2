package com.Demoqa.test;

import com.Demoqa.data.InvalidData;
import com.Demoqa.data.ValidData;
import com.Demoqa.page.PracticeFormPage;
import com.Demoqa.page.ResultFormPage;
import com.Demoqa.settings.BaseTest;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Проверка формы регистрации студента")
public class PracticeFormTest extends BaseTest {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    ValidData validData = new ValidData();
    ResultFormPage resultFormPage = new ResultFormPage();
    InvalidData invalidData = new InvalidData();


    @Test
    @DisplayName("Проверка заполнения формы валидными данными")
    public void CompletionFormTest() {
        practiceFormPage.openPage()
                .setFirstName(validData.getFirstName())
                .setLastName(validData.getLastName())
                .setEmail(validData.getEmail())
                .setGender()
                .setTelephoneNumber(validData.getTelephoneNumber())
                .setCalendar(validData.getMonth(), validData.getYear(), validData.getDay())
                .setSubjects(validData.getSubjects())
                .setHobbies()
                .setPicture(validData.getFile())
                .setCurrentAddress(validData.getAddress())
                .setState(validData.getState())
                .setCity(validData.getCity())
                .submit();

        Selenide.sleep(100);

        resultFormPage.checkVisible()
                .checkResult("Student Name", validData.getFirstName() + " " + validData.getLastName()
                        , "имя и фамилию")
                .checkResult("Student Email", validData.getEmail(), "почту")
                .checkResult("Gender", validData.getGender(), "пол")
                .checkResult("Mobile", validData.getTelephoneNumber(), "номер телефона")
                .checkResult("Date of Birth", validData.getDay() + " " + validData.getMonth() + ","
                        + validData.getYear(), "дату рождения")
                .checkResult("Subjects", validData.getSubjects(), "предмет")
                .checkResult("Hobbies", validData.getHobbies(), "хобби")
                .checkResult("Picture", validData.getFile(), "загруженный файл")
                .checkResult("Address", validData.getAddress(), "адрес")
                .checkResult("State and City", validData.getState() + " " + validData.getCity(),
                        "штат и город");
    }

    @Test
    @DisplayName("Валидация полей.Оставляем поля не заполненными")
    public void PracticeFormPageNegativeTest() {
        practiceFormPage.openPage()
                .submit();

        Selenide.sleep(500);

        assertThat(invalidData.getInputRedColor()).as("Ввод имени - цвет не совпадает")
                .isEqualTo(practiceFormPage.InputGetCssValueFirstName());
        assertThat(invalidData.getInputRedColor()).as("Ввод фамилии - цвет не совпадает")
                .isEqualTo(practiceFormPage.InputGetCssValueLastName());
        assertThat(invalidData.getInputRedColor()).as("Ввод телефона - цвет не совпадает")
                .isEqualTo(practiceFormPage.InputGetCssValueTelephoneNumber());
        assertThat(practiceFormPage.ButtonGetCssValueGender())
                .as("Кнопка выбора пола - цвет не совпадает")
                .isEqualTo(invalidData.getButtonRedColor());
    }

    @Test
    @DisplayName("Валидация полей.Вводим в поле телефон буквы")
    public void InputTelephoneNumberNegativeTest() {
        practiceFormPage.openPage()
                .setTelephoneNumber(invalidData.getTelephone())
                .submit();

        Selenide.sleep(500);

        assertThat(invalidData.getInputRedColor()).as("Ввод телефона - цвет не совпадает")
                .isEqualTo(practiceFormPage.InputGetCssValueTelephoneNumber());

    }
}
