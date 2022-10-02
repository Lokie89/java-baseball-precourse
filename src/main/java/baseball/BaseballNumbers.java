package baseball;

import baseball.util.StringParser;

import java.util.*;

/**
 * @author SeongRok.Oh
 * @since 2022/10/02
 */
public class BaseballNumbers {

    private final static int BASEBALL_NUMBER_CAPACITY = 3;
    private final static int MINIMUM_NUMBER = 1;
    private final static int MAXIMUM_NUMBER = 9;
    private final List<Integer> baseballNumbers;

    private BaseballNumbers(Set<Integer> numbers) {
        validateSize(numbers);
        validateNumbers(numbers);
        this.baseballNumbers = new ArrayList<>(numbers);
    }

    public static BaseballNumbers generateOnCapacity() {
        Set<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() < BASEBALL_NUMBER_CAPACITY) {
            numbers.add(BaseballRandomNumberGenerator.generate());
        }
        return new BaseballNumbers(numbers);
    }

    public static BaseballNumbers generateOnString(String s) {
        validateLength(s);
        List<Integer> parsedList;
        try {
            parsedList = StringParser.convertIntegerList(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        Set<Integer> numbers = new LinkedHashSet<>(parsedList);
        return new BaseballNumbers(numbers);
    }

    private static void validateLength(String s) {
        if (s.length() != BASEBALL_NUMBER_CAPACITY) {
            throw new IllegalArgumentException();
        }
    }

    private void validateSize(Collection<Integer> numbers) {
        if (numbers.size() != BASEBALL_NUMBER_CAPACITY) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbers(Set<Integer> numbers) {
        for (Integer num : numbers) {
            validRange(num);
        }
    }

    private void validRange(Integer num) {
        if (num < MINIMUM_NUMBER
                || num > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

}
