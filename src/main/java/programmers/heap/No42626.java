package programmers.heap;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No42626 {
    @Test
    public void testSolutionForCase1() {
        //given
        int[] scoville = new int[]{1, 2, 3, 9, 10, 12};
        int k = 7;

        //when
        int result = solution(scoville, k);
        int answer = 2;

        //then
        assertEquals(answer, result);
    }

    /*
    성능 최적화에 실패한 코드
    public int solution(int[] scoville, int k) {
         List<Integer> scovilleList = Arrays.stream(scoville)
                 .boxed().collect(Collectors.toList());

         int count = 0;

         while (true) {
             scovilleList = scovilleList.stream().parallel().sorted().collect(Collectors.toList());

             if (scovilleList.get(0) >= k) return count;

             int lowestElement = scovilleList.get(0);
             scovilleList.remove(0);

             if (scovilleList.isEmpty()) return -1;

             int secondLowestElement = scovilleList.get(0);
             scovilleList.remove(0);

             scovilleList.add(
                     calculateScoville(lowestElement, secondLowestElement)
             );

             count++;
         }
     }*/
    public int solution(int[] scoville, int k) {
        PriorityQueue<Integer> heapScoville = new PriorityQueue<>();
        Arrays.stream(scoville).sorted().forEach(s -> heapScoville.offer(s));

        int count = 0;

        while (true) {
            if (heapScoville.peek() >= k) return count;

            int lowestScoville = heapScoville.poll();

            if (heapScoville.isEmpty()) return -1;

            int secondLowestScoville = heapScoville.poll();

            heapScoville.offer(getNewScoville(lowestScoville, secondLowestScoville));

            count++;
        }
    }

    public int getNewScoville(int lowestElement, int secondLowestScoville) {
        return lowestElement + (secondLowestScoville * 2);
    }
}
