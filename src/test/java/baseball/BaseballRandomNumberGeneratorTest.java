package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author SeongRok.Oh
 * @since 2022/10/02
 */
public class BaseballRandomNumberGeneratorTest {

    @DisplayName("랜덤 넘버 생성 시 1 ~ 9 까지의 숫자인지")
    @RepeatedTest(value = 10)
    void generate() {
        int baseballGameRandomNumber = BaseballRandomNumberGenerator.generate();
        assertThat(baseballGameRandomNumber)
                .isGreaterThan(0)
                .isLessThan(10);
    }
}
