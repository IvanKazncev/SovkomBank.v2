package com.Cleanui.test;

import com.Cleanui.data.GetData;
import com.Cleanui.steps.Steps;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тесты валидными ссылками разной длины")
public class ApiCleanTest {
    Steps steps = new Steps();
    GetData getData = new GetData();

    public ApiCleanTest() throws IOException {
    }

    @SneakyThrows
    @Test
    @DisplayName("Отправка ссылок разной длины")
    void cleanUiTest() {
        System.out.println("Тест длинной ссылки (205 символов)");
        assertThat(steps.apiTest(getData.getUrl("ya.ru"), 200).getResult_url())
                .isNotEmpty()
                .as("Проверка длинной ссылки не удалась")
                .isEqualTo("https://cleanuri.com/jYNOAE");
        System.out.println("Тест короткой ссылки (16 символов) ");
        assertThat(steps.apiTest(getData.getUrl("mail.ru"), 200).getResult_url())
                .isNotEmpty()
                .as("Проверка короткой ссылки не удалась")
                .isEqualTo("https://cleanuri.com/2r83oJ");
        System.out.println("Тест средней ссылки (61 символ) ");
        assertThat(steps.apiTest(getData.getUrl("mail.ru(middle)"), 200).getResult_url())
                .isNotEmpty()
                .as("Проверка средней ссылки не удалась")
                .isEqualTo("https://cleanuri.com/Zn8grW");
        System.out.println("Тест пустой ссылки");
        assertThat(steps.apiTest(getData.getUrl("empty"), 400).getError())
                .isNotEmpty()
                .as("Проверка отправки пустой ссылки не удалась")
                .contains("URL is empty");
        assertThat(steps.apiTest(getData.getUrl("numbers"), 400).getError())
                .isNotEmpty()
                .as("Проверка не корректной пустой ссылки не удалась")
                .contains("URL is invalid");
    }
}
