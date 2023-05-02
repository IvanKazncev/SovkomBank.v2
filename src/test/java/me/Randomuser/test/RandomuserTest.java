package me.Randomuser.test;

import me.Randomuser.data.Data;
import me.Randomuser.models.RootModel;
import me.Randomuser.steps.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тестирование Get запроса")
public class RandomuserTest extends Step {
    Data data = new Data();

    @Test
    @DisplayName("Проверка размера List (1 элемент)")
    void apiTest() {
        assertThat(randomuserApiTest(data.getFemaleGender(), data.getMyList().get(2),
                        data.getUrl(), 200)
                .getResults().size()).as("Количество объектов не соответствует заявленной")
                .isEqualTo(1);
    }

    @Test
    @DisplayName("Проверка размера List(2 элемента)")
    void numberOfElementsTest() {
        assertThat(randomuserApiTest(data.getFemaleGender(), data.getMyList().get(3),
                        data.getUrl(), 200)
                .getResults().size()).as("Количество объектов не соответствует заявленной")
                .isEqualTo(2);
    }

    @Test
    @DisplayName("Проверка размера List (10 элементов)")
    void numberOfElementsTest10() {
        assertThat(randomuserApiTest(data.getMaleGender(), data.getMyList().get(4),
                        data.getUrl(), 200)
                .getResults().size())
                .as("Количество объектов не соответствует заявленной")
                .isEqualTo(10);
    }
    @Test
    @DisplayName("Проверка пола (мужской)")
    void genderMaleTest() {
        assertThat(randomuserApiTest(data.getMaleGender(), data.getMyList().get(1), data.getUrl(), 200)
                .getResults().stream().map(RootModel::getGender).findFirst())
                .as("Полученный пол не соответствует")
                .contains(data.getMaleGender());
    }
    @Test
    @DisplayName("Проверка пола (женский)")
    void genderFemaleTest() {
        assertThat(randomuserApiTest(data.getFemaleGender(), data.getMyList().get(2), data.getUrl(), 200)
                .getResults().stream().map(RootModel::getGender))
                .as("Полученный пол не соответствует")
                .contains(data.getFemaleGender());
    }
    @Test
    @DisplayName("Проверка ввода некорректного пола")
    void negativeGenderTest() {
        assertThat(randomuserApiTest(data.getUnCorrectGender(), data.getMyList().get(2), data.getUrl(), 200)
                .getResults().stream().map(RootModel::getGender))
                .as("Полученный пол не соответствует")
                .contains(data.getMaleGender());
    }
    @Test
    @DisplayName("Проверка ввода некорректного размера List")
    void negativeListSizeTest() {
        assertThat(randomuserApiTest(data.getFemaleGender(), data.getMyList().get(0),
                        data.getUrl(), 200)
                .getResults().size()).as("Количество объектов должно быть равно 1")
                .isEqualTo(1);
    }

}

