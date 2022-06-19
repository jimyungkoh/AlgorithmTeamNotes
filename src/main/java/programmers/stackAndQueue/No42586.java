package programmers.stackAndQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class No42586 {
    @Test
    private void testSolution() {
        //given
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        //when
        int[] result = solution(progresses, speeds);
        int[] answer = new int[]{2, 1};

        //then
        Assertions.assertArrayEquals(answer, result);
    }

    private int[] solution(int[] progresses, int[] speeds) {
        List<Integer> remainedDays = new ArrayList<>();

        for (int idx = 0; idx<progresses.length; idx++){
            remainedDays.add((int)Math.ceil((100-progresses[idx])/speeds[idx]));
        }

        remainedDays.forEach(System.out::println);

        return new int[0];
    }
}
