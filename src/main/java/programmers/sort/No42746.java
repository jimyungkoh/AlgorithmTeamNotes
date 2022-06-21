package programmers.sort;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No42746 {
    @Test
    public void testSolutionForCase1() {
        //given
        int[] numbers = new int[]{6, 10, 2};

        //when
        String result = solution(numbers);
        String answer = "6210";

        //then
        assertEquals(answer, result);
    }


    @Test
    public void testSolutionForCase2() {
        //given
        int[] numbers = new int[]{3, 30, 34, 5, 9};

        //when
        String result = solution(numbers);
        String answer = "9534330";

        //then
        assertEquals(answer, result);
    }

    private String solution(int[] numbers) {
        List<String> strNumbers = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted(((Comparator<String>) (sNum1, sNum2) ->
                        (sNum1 + sNum2).compareTo(sNum2 + sNum1)).reversed())
                .collect(Collectors.toList());

        String maxNumber = String.join("", strNumbers);

        return maxNumber.startsWith("0") ? "0" : maxNumber;
    }
}
