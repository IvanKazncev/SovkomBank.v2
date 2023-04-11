package me.Randomuser.test;

import me.Randomuser.data.Data;
import me.Randomuser.models.RootModel;
import me.Randomuser.steps.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тестирование Get запроса")
public class RandomuserTest {
    Step step = new Step();
    Data data = new Data();

    @Test
    @DisplayName("Позитивные тесты")
    void apiTest() {
        System.out.println("Проверка размера List");
        assertThat(step.randomuserApiTest(data.getFemaleGender(), data.getMyList().get(1),
                        data.getUrl(), 200)
                .getResults().size()).as("Количество объектов не соответствует заявленной")
                .isEqualTo(1);
        System.out.println("Проверка размера List");
        assertThat(step.randomuserApiTest(data.getFemaleGender(), data.getMyList().get(3),
                        data.getUrl(), 200)
                .getResults().size()).as("Количество объектов не соответствует заявленной")
                .isEqualTo(2);
        System.out.println("Проверка размера List");
        assertThat(step.randomuserApiTest(data.getMaleGender(), data.getMyList().get(4),
                        data.getUrl(), 200)
                .getResults().size())
                .as("Количество объектов не соответствует заявленной")
                .isEqualTo(10);
        System.out.println("Проверка пола");
        assertThat(step.randomuserApiTest(data.getMaleGender(), data.getMyList().get(1), data.getUrl(), 200)
                .getResults().stream().map(RootModel::getGender).findFirst()).contains(data.getMaleGender())
                .as("Полученный пол не соответствует");
        System.out.println("Проверка пола");
        assertThat(step.randomuserApiTest(data.getFemaleGender(), data.getMyList().get(2), data.getUrl(), 200)
                .getResults().stream().map(RootModel::getGender)).contains(data.getFemaleGender())
                .as("Полученный пол не соответствует");
    }


}

