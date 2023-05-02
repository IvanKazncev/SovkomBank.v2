package com.Cleanui.test;

import com.Cleanui.data.GetData;
import com.Cleanui.steps.Steps;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тестирование укорачивания ссылок")
public class ApiCleanTest extends Steps {
    GetData getData = new GetData();
    public ApiCleanTest() throws IOException {
    }

    @SneakyThrows
    @Test
    @DisplayName("Тест длинной ссылки (205 символов)")
    void cleanUiTest() {
        System.out.println("Тест длинной ссылки (205 символов)");
        assertThat(apiTest(getData.getUrl("ya.ru"), 200).getResult_url())
                .isNotEmpty()
                .as("Проверка длинной ссылки не удалась")
                .isEqualTo("https://cleanuri.com/jYNOAE");
    }
    @Test
    @DisplayName("Тест короткой ссылки (16 символов)")
    void cleanUiSmallUrlTest() {
        assertThat(apiTest(getData.getUrl("mail.ru"), 200).getResult_url())
                .isNotEmpty()
                .as("Проверка короткой ссылки не удалась")
                .isEqualTo("https://cleanuri.com/2r83oJ");
    }
    @Test
    @DisplayName("Тест средней ссылки (61 символ) ")
    void cleanUiMiddleUrlTest() {
        assertThat(apiTest(getData.getUrl("mail.ru(middle)"), 200).getResult_url())
                .isNotEmpty()
                .as("Проверка средней ссылки не удалась")
                .isEqualTo("https://cleanuri.com/Zn8grW");
    }
    @Test
    @DisplayName("Тест пустой ссылки")
    void cleanUiEmptyUrlTest() {
        assertThat(apiTest(getData.getUrl("empty"), 400).getError())
                .isNotEmpty()
                .as("Проверка отправки пустой ссылки не удалась")
                .contains("URL is empty");
    }
    @Test
    @DisplayName("Отправка невалидной ссылки")
    void cleanUiInvalidUrlTest() {
        assertThat(apiTest(getData.getUrl("numbers"), 400).getError())
                .isNotEmpty()
                .as("Проверка не корректной пустой ссылки не удалась")
                .contains("URL is invalid");
    }
}
