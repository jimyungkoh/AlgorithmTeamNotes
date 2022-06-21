package programmers.heap;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class No42628 {
    @Test
    public void testSolutionForCase1() {
        //given
        String[] operations = new String[]{"I 16", "D 1"};

        //when
        int[] result = solution(operations);
        int[] answer = new int[]{0, 0};

        //then
        assertArrayEquals(answer, result);
    }


    @Test
    public void testSolutionForCase2() {
        //given
        String[] operations = new String[]{"I 7", "I 5", "I -5", "D -1"};

        //when
        int[] result = solution(operations);
        int[] answer = new int[]{7, 5};

        //then
        assertArrayEquals(answer, result);
    }

    @Test
    public void testSolutionForCase3() {
        //given
        String[] operations = new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};

        //when
        int[] result = solution(operations);
        int[] answer = new int[]{0, 0};

        //then
        assertArrayEquals(answer, result);
    }

    @Test
    public void testSolutionForCase4() {
        //given
        String[] operations = new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        //when
        int[] result = solution(operations);
        int[] answer = new int[]{333, -45};

        //then
        assertArrayEquals(answer, result);
    }

    public int[] solution(String[] operations) {
        String deleteMax = "D 1";
        String deleteMin = "D -1";

        PriorityQueue<Integer> ascNumbers = new PriorityQueue<>();
        PriorityQueue<Integer> descNumbers = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            if (operation.startsWith("I")) {
                int pureNumber = Integer.parseInt(operation.substring(1).trim());
                ascNumbers.offer(pureNumber);
                descNumbers.offer(pureNumber);
            }

            if (ascNumbers.isEmpty()) continue;

            if (operation.equals(deleteMax)) {
                ascNumbers.remove(descNumbers.poll());
            } else if (operation.equals(deleteMin)) {
                descNumbers.remove(ascNumbers.poll());
            }
        }

        return getResult(ascNumbers, descNumbers);
    }

    private int[] getResult(PriorityQueue<Integer> ascNumbers, PriorityQueue<Integer> descNumbers) {
        return ascNumbers.isEmpty() ?
                new int[]{0, 0} : new int[]{descNumbers.poll(), ascNumbers.poll()};
    }
}
