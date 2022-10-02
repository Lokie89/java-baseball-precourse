package baseball.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SeongRok.Oh
 * @since 2022/10/02
 */
public class StringParser {

    public static List<Integer> convertIntegerList(String s) {
        List<Integer> integerList = new ArrayList<>();
        String[] splitStr = s.split("");
        for (String str : splitStr) {
            integerList.add(Integer.parseInt(str));
        }
        return integerList;
    }
}
