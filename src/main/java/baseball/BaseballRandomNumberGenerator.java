package baseball;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * @author SeongRok.Oh
 * @since 2022/10/02
 */
public class BaseballRandomNumberGenerator {

    private BaseballRandomNumberGenerator() {
    }

    public static int generate() {
        return Randoms.pickNumberInRange(1, 9);
    }

}
