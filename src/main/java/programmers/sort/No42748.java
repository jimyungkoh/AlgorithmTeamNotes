package programmers.sort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class No42748 {
    @Test
    public void testSolutionForCase1() {
        //given
        int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        //when
        int[] result = solution(array, commands);
        int[] answer = new int[]{5, 6, 3};

        //then
        assertArrayEquals(answer, result);
    }

    private int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];

        List<Integer> list = Arrays.stream(array)
                .boxed().collect(Collectors.toList());

        for (int rowIdx = 0; rowIdx < commands.length; rowIdx++) {
            int from = commands[rowIdx][0] - 1;
            int to = commands[rowIdx][1];
            int nth = commands[rowIdx][2] - 1;

            List<Integer> subList = getSortedSubList(list, from, to);

            result[rowIdx] = subList.get(nth);
        }

        return result;
    }

    private List<Integer> getSortedSubList(List<Integer> list, int from, int to) {
        List<Integer> subList = new ArrayList<>(list).subList(from, to);

        subList.sort(Comparator.comparing(n -> n));

        return subList;
    }
}



/* 모범답안
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] - 1];
        }

        return answer;
    }
}
*/
