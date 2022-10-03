package baseball;

import java.util.*;

/**
 * @author SeongRok.Oh
 * @since 2022/10/03
 */
public class BaseballGameReferee {

    private final BaseballGameAssistant assistant;

    private BaseballGameReferee(List<Integer> answer) {
        this.assistant = BaseballGameAssistant.fromAnswer(answer);
    }

    public static BaseballGameReferee ofAnswer(List<Integer> answer) {
        return new BaseballGameReferee(BaseballNumbers.generateOnCollection(answer));
    }

    public boolean judge(List<Integer> report) {
        List<BaseballResult> results = new ArrayList<>();

        for (int i = 0; i < report.size(); i++) {
            results.add(assistant.verify(i, report.get(i)));
        }

        print(results);

        boolean end = isFinished(results);
        if (end) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        return end;
    }

    private boolean isFinished(List<BaseballResult> results) {
        Set<BaseballResult> distinct = new HashSet<>(results);

        return results.size() == 3
                && distinct.size() == 1
                && distinct.contains(BaseballResult.STRIKE);
    }

    private void print(List<BaseballResult> results) {
        Map<BaseballResult, Integer> countMap = new TreeMap<>();
        for (BaseballResult result : results) {
            counting(countMap, result);
        }
        printCountMap(countMap);
    }

    private void counting(Map<BaseballResult, Integer> countMap, BaseballResult result) {
        if (result == null) {
            return;
        }
        if (countMap.get(result) == null) {
            countMap.put(result, 1);
            return;
        }
        countMap.put(result, countMap.get(result) + 1);
    }

    private void printCountMap(Map<BaseballResult, Integer> countMap) {

        for (BaseballResult baseballResult : countMap.keySet()) {
            System.out.print(countMap.get(baseballResult) + baseballResult.getDescription() + " ");
        }
        if (countMap.isEmpty()) {
            System.out.print("낫싱");
        }
        System.out.println();
    }
}
