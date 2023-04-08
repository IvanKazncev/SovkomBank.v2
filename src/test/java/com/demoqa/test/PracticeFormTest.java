package com.demoqa.test;

import com.codeborne.selenide.Selenide;
import com.demoqa.data.InvalidData;
import com.demoqa.data.ValidData;
import com.demoqa.page.PracticeFormPage;
import com.demoqa.page.ResultFormPage;
import com.demoqa.settings.BaseTest;
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
        practiceFormPage.openPage();
        practiceFormPage.setFirstName(validData.firstName);
        practiceFormPage.setLastName(validData.lastName);
        practiceFormPage.setEmail(validData.email);
        practiceFormPage.setGender();
        practiceFormPage.setTelephoneNumber(validData.telephoneNumber);
        practiceFormPage.setCalendar(validData.month, validData.year, validData.day);
        practiceFormPage.setSubjects(validData.subjects);
        practiceFormPage.setHobbies();
        practiceFormPage.setPicture(validData.file);
        practiceFormPage.setCurrentAddress(validData.address);
        practiceFormPage.setState(validData.state);
        practiceFormPage.setCity(validData.city);
        practiceFormPage.submit();

        Selenide.sleep(100);

        resultFormPage.checkVisible();
        resultFormPage.checkResult("Student Name", validData.firstName + " " + validData.lastName
                , "имя и фамилию");
        resultFormPage.checkResult("Student Email", validData.email, "почту");
        resultFormPage.checkResult("Gender", validData.gender, "пол");
        resultFormPage.checkResult("Mobile", validData.telephoneNumber, "номер телефона");
        resultFormPage.checkResult("Date of Birth", validData.day + " " + validData.month + ","
                + validData.year, "дату рождения");
        resultFormPage.checkResult("Subjects", validData.subjects, "предмет");
        resultFormPage.checkResult("Hobbies", validData.hobbies, "хобби");
        resultFormPage.checkResult("Picture", validData.file, "загруженный файл");
        resultFormPage.checkResult("Address", validData.address, "адрес");
        resultFormPage.checkResult("State and City", validData.state + " " + validData.city,
                "штат и город");
    }

    @Test
    @DisplayName("Валидация полей.Оставляем поля не заполненными")
    public void PracticeFormPageNegativeTest() {
        practiceFormPage.openPage();
        practiceFormPage.submit();

        Selenide.sleep(500);

        assertThat(invalidData.InputRedColor).as("Ввод имени - цвет не совпадает")
                .isEqualTo(practiceFormPage.InputGetCssValue(practiceFormPage.firstName, "border-color"));
        assertThat(invalidData.InputRedColor).as("Ввод фамилии - цвет не совпадает")
                .isEqualTo(practiceFormPage.InputGetCssValue(practiceFormPage.lastname, "border-color"));
        assertThat(invalidData.InputRedColor).as("Ввод телефона - цвет не совпадает")
                .isEqualTo(practiceFormPage.InputGetCssValue(practiceFormPage.telephoneNumber, "border-color"));
        assertThat(practiceFormPage.ButtonGetCssValue(practiceFormPage.genderButton, "color"))
                .as("Кнопка выбора пола - цвет не совпадает")
                .isEqualTo(invalidData.ButtonRedColor);

    }

    @Test
    @DisplayName("Валидация полей.Вводим в поле телефон буквы")
    public void InputTelephoneNumberNegativeTest() {
        practiceFormPage.openPage();
        practiceFormPage.setTelephoneNumber(invalidData.Telephone);
        practiceFormPage.submit();

        Selenide.sleep(500);

        assertThat(invalidData.InputRedColor).as("Ввод телефона - цвет не совпадает")
                .isEqualTo(practiceFormPage.InputGetCssValue(practiceFormPage.telephoneNumber, "border-color"));

    }
}
