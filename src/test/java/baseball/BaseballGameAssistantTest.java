package baseball;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author SeongRok.Oh
 * @since 2022/10/03
 */
public class BaseballGameAssistantTest {

    @DisplayName("스트라이크, 볼을 판별해주는 기능 테스트")
    @Test
    void verify() {

        final String answerStr = "123";
        List<Integer> answer = BaseballNumbers.generateOnString(answerStr);

        BaseballGameAssistant assistant = BaseballGameAssistant.fromAnswer(answer);

        assertThat(assistant.verify(0, 2)).isEqualTo(BaseballResult.BALL);
        assertThat(assistant.verify(1, 4)).isEqualTo(null);
        assertThat(assistant.verify(2, 3)).isEqualTo(BaseballResult.STRIKE);
    }
}
