package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;

/**
 * @author SeongRok.Oh
 * @since 2022/10/02
 */
public class BaseballNumbersTest {

    @DisplayName("랜덤 야구 게임 숫자의 크기가 3인지 판별")
    @Test
    void validateNumbersSize() throws NoSuchFieldException, IllegalAccessException {
        BaseballNumbers baseballNumbers = BaseballNumbers.generateOnCapacity();
        Field field = baseballNumbers.getClass().getDeclaredField("baseballNumbers");
        field.setAccessible(true);

        List<Integer> numbers = (List<Integer>) field.get(baseballNumbers);
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("랜덤 야구 게임 숫자가 서로 다른 숫자인지 판별")
    @Test
    void validateUniqueNumbers() throws NoSuchFieldException, IllegalAccessException {
        BaseballNumbers baseballNumbers = BaseballNumbers.generateOnCapacity();
        Field field = baseballNumbers.getClass().getDeclaredField("baseballNumbers");
        field.setAccessible(true);

        List<Integer> numbers = (List<Integer>) field.get(baseballNumbers);
        assertThat(numbers.size()).isEqualTo(new HashSet<>(numbers).size());
    }

    @DisplayName("입력 받은 야구 게임 숫자 생성")
    @ValueSource(strings = {"123", "562", "837"})
    @ParameterizedTest
    void generateOnString(String input) throws NoSuchFieldException, IllegalAccessException {
        BaseballNumbers baseballNumbers = BaseballNumbers.generateOnString(input);
        Field field = baseballNumbers.getClass().getDeclaredField("baseballNumbers");
        field.setAccessible(true);

        List<Integer> numbers = (List<Integer>) field.get(baseballNumbers);
        assertThat(numbers.size()).isEqualTo(new HashSet<>(numbers).size());
    }

    @DisplayName("입력 받은 야구 게임 숫자 생성 Exception")
    @ValueSource(strings = {"abc", "1234", "113", "930"})
    @ParameterizedTest
    void generateOnStringException(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> BaseballNumbers.generateOnString(input));
    }
}
