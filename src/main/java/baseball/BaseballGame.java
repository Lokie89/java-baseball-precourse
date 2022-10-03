package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

/**
 * @author SeongRok.Oh
 * @since 2022/10/03
 */
public class BaseballGame {

    private BaseballGameReferee referee;

    public BaseballGame() {
        initGame();
    }

    private void initGame() {
        List<Integer> answer = BaseballNumbers.generateOnCapacity();
        this.referee = BaseballGameReferee.ofAnswer(answer);
    }

    public void start() {
        while (!ask() || restart());
    }

    private boolean ask() {
        System.out.print("숫자를 입력해주세요 : ");
        return referee.judge(BaseballNumbers.generateOnString(Console.readLine()));
    }

    private boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        boolean restart = Integer.parseInt(Console.readLine()) == 1;
        if (restart) {
            initGame();
        }
        return restart;
    }
}
