package programmers.greedy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

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
        List<Integer> numbers = Arrays.stream(number.split(""))
                .parallel().map(Integer::parseInt).collect(Collectors.toList());

        Stack<Integer> remainedNumbers = getRemainedNumbers(numbers, k);

        int overLength = remainedNumbers.size() - (numbers.size() - k);

        return getBiggestNumber(remainedNumbers, overLength);
    }

    private Stack<Integer> getRemainedNumbers(List<Integer> numbers, int k) {
        Stack<Integer> remainedNumbers = new Stack<>();

        int count = 0;

        for (int n : numbers) {
            while (k > count && !remainedNumbers.isEmpty()) {
                if (remainedNumbers.peek() >= n) break;

                remainedNumbers.pop();
                count++;
            }

            remainedNumbers.push(n);
        }

        return remainedNumbers;
    }

    private String getBiggestNumber(Stack<Integer> remainedNumbers, int overLength) {
        StringBuilder biggestNumber = new StringBuilder();

        while (!remainedNumbers.isEmpty()) {
            if (overLength != 0) {
                overLength--;
                remainedNumbers.pop();
                continue;
            }

            biggestNumber.append(remainedNumbers.pop());
        }

        return biggestNumber.reverse().toString();
    }
}
