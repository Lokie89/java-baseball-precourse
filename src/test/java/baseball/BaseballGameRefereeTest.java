package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author SeongRok.Oh
 * @since 2022/10/03
 */
public class BaseballGameRefereeTest {

    @DisplayName("야구 게임 심판의 판별")
    @Test
    void judge() {

        final String answerStr = "135";
        List<Integer> answer = BaseballNumbers.generateOnString(answerStr);

        BaseballGameReferee referee = BaseballGameReferee.ofAnswer(answer);

        final String reportStr = "135";
        List<Integer> report = BaseballNumbers.generateOnString(reportStr);

        referee.judge(report);

        Assertions.assertThat(referee.judge(report)).isEqualTo(true);

    }
}
