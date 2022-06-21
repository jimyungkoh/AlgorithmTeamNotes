package programmers.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No42883 {
    @Test
    public void testSolutionForCase1() {
        //given
        String number = "1924";
        int k = 2;

        //when
        String result = solution(number, k);
        String answer = "94";

        //then
        assertEquals(answer, result);
    }

    @Test
    public void testSolutionForCase2() {
        //given
        String number = "1231234";
        int k = 3;

        //when
        String result = solution(number, k);
        String answer = "3234";

        //then
        assertEquals(answer, result);
    }

    @Test
    public void testSolutionForCase3() {
        //given
        String number = "4177252841";
        int k = 4;

        //when
        String result = solution(number, k);
        String answer = "775841";

        //then
        assertEquals(answer, result);
    }

    public String solution(String number, int k) {

        int max = getMaxNumber(number, number.length() - k, "", 0);

        return String.valueOf(max);
    }

    public int max = Integer.MIN_VALUE;

    public int getMaxNumber(String number, int limitDigit, String candidate, int idx) {
        if (candidate.length() == limitDigit || idx == number.length()) {
            if (candidate.length()==0) return max;

            return max = Math.max(max, Integer.parseInt(candidate));
        }

        getMaxNumber(number, limitDigit, candidate + number.charAt(idx), idx + 1);
        getMaxNumber(number, limitDigit, candidate, idx + 1);

        return max;
    }
}
