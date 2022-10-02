package baseball;

import java.util.*;

/**
 * @author SeongRok.Oh
 * @since 2022/10/02
 */
public class BaseballNumbers {

    private final static int BASEBALL_NUMBER_CAPACITY = 3;
    private final List<Integer> baseballNumbers;

    private BaseballNumbers(Collection<Integer> numbers) {
        this.baseballNumbers = new ArrayList<>(numbers);
    }

    public static BaseballNumbers generateOnCapacity() {
        Set<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() < BASEBALL_NUMBER_CAPACITY) {
            numbers.add(BaseballRandomNumberGenerator.generate());
        }
        return new BaseballNumbers(numbers);
    }

}
