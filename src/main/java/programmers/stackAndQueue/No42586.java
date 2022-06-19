package programmers.stackAndQueue;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class No42586 {

    @Test
    public void testSolutionForCase1() {
        //given
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        //when
        int[] result = solution(progresses, speeds);
        int[] answer = new int[]{2, 1};

        //then
        assertArrayEquals(answer, result);
    }

    @Test
    public void testSolutionForCase2() {
        //given
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        //when
        int[] result = solution(progresses, speeds);
        int[] answer = new int[]{1, 3, 2};

        //then
        assertArrayEquals(answer, result);
    }

    private int[] solution(int[] progresses, int[] speeds) {
        List<Integer> remainedDays = new ArrayList<>();

        for (int idx = 0; idx < progresses.length; idx++) {
            int remainedDay = (int) Math.ceil((100 - progresses[idx]) / (double)speeds[idx]);
            remainedDays.add(remainedDay);
        }

        Stack<Integer> functionStack = new Stack<>();
        int max = Integer.MIN_VALUE;

        for (int remainedDay : remainedDays) {
            if (remainedDay > max || functionStack.isEmpty()) {
                max = remainedDay;
                functionStack.push(1);
            } else {
                functionStack.push(functionStack.pop() + 1);
            }
        }

        int[] functionsByDeployment = new int[functionStack.size()];
        int functionsByDeploymentIdx = functionsByDeployment.length-1;

        while (!functionStack.isEmpty()){
            functionsByDeployment[functionsByDeploymentIdx--] = functionStack.pop();
        }

        return functionsByDeployment;
    }
}
