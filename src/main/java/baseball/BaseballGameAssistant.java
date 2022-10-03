package baseball;

import java.util.List;

/**
 * @author SeongRok.Oh
 * @since 2022/10/03
 */
public class BaseballGameAssistant {

    private final List<Integer> answer;

    private BaseballGameAssistant(List<Integer> answer) {
        this.answer = answer;
    }

    public static BaseballGameAssistant fromAnswer(List<Integer> answer) {
        return new BaseballGameAssistant(answer);
    }

    public BaseballResult verify(int index, int number) {
        if (answer.get(index) == number) {
            return BaseballResult.STRIKE;
        }
        if (answer.contains(number)) {
            return BaseballResult.BALL;
        }
        return null;
    }
}
