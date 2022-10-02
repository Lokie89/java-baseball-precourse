package baseball.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

/**
 * @author SeongRok.Oh
 * @since 2022/10/02
 */
public class StringParserTest {

    @DisplayName("String 을 Integer List 로 변환")
    @ValueSource(strings = {"123", "456", "125435"})
    @ParameterizedTest
    void convertIntegerList(String input) {
        List<Integer> integerList = StringParser.convertIntegerList(input);
        assertThat(integerList.size()).isEqualTo(input.length());
        assertThat(integerList.get(0)).isEqualTo(Integer.parseInt(input.substring(0, 1)));
    }

    @DisplayName("String 을 Integer List 로 변환 Exception")
    @ValueSource(strings = {"abc", "a12", "341agbd313"})
    @ParameterizedTest
    void convertIntegerListException(String input) {
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> StringParser.convertIntegerList(input))
                .withMessageContaining("For input string:");
    }
}
