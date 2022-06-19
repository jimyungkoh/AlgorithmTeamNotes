package programmers.stackAndQueue;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No42587 {

    @Test
    public void testSolutionForCase1() {
        //given
        int[] priorities = new int[]{2, 1, 3, 2};
        int location = 2;

        //when
        int result = solution(priorities, location);
        int answer = 1;

        //then
        assertEquals(answer, result);
    }

    @Test
    public void testSolutionForCase2() {
        //given
        int[] priorities = new int[]{1, 1, 9, 1, 1, 1};
        int location = 0;

        //when
        int result = solution(priorities, location);
        int answer = 5;

        //then
        assertEquals(answer, result);
    }

    private int solution(int[] priorities, int location) {
        Queue<Integer> priorityQueue = new LinkedList<>();
        Queue<Integer> locationQueue = new LinkedList<>();

        for (int currentLocation = 0; currentLocation < priorities.length; currentLocation++) {
            priorityQueue.offer(priorities[currentLocation]);
            locationQueue.offer(currentLocation);
        }

        int nth = 1;
        int currentPriority;
        int currentLocation;
        int topPriority;

        while (true) {
            topPriority = Collections.max(priorityQueue);

            currentPriority = priorityQueue.poll();
            currentLocation = locationQueue.poll();

            if (priorityQueue.isEmpty()) {
                return nth;
            }

            if (topPriority > currentPriority) {
                priorityQueue.offer(currentPriority);
                locationQueue.offer(currentLocation);
            } else if (currentLocation == location) {
                return nth;
            } else {
                nth++;
            }
        }
    }
}
