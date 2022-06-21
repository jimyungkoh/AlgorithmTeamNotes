package programmers.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No42747 {
    @Test
    public void testSolutionForCase1() {
        //given
        int[] citations = new int[]{3, 0, 6, 1, 5};

        //when
        int result = solution(citations);
        int answer = 3;

        //then
        assertEquals(answer, result);
    }

    /*private int solution(int[] citations) {
        int hIndex = Integer.MIN_VALUE;
        int maxLength = Integer.MIN_VALUE;
        Arrays.sort(citations);
        Arrays.stream(citations).forEach(System.out::println);

        for (int idx = 0; idx < citations.length; idx++) {
            int subCitationsLength = Arrays.copyOfRange(
                    citations, idx, citations.length).length;
            System.out.println("subCitationsLength = " + subCitationsLength);
            hIndex = subCitationsLength > maxLength ? citations[idx] : hIndex;
        }

        return hIndex;
    }*/
    int solution(int[] citations) {
        Arrays.sort(citations);

        int hIndex = citations[citations.length-1];

        while (hIndex >= 0) {
            int upperCnt = 0;
            int lowerCnt = 0;

            for (int citation : citations) {
                if (citation >= hIndex) upperCnt++;
                if (citation < hIndex) lowerCnt++;
            }

            if (upperCnt >= hIndex && lowerCnt <= hIndex) break;

            hIndex--;
        }

        return hIndex;
    }
}
