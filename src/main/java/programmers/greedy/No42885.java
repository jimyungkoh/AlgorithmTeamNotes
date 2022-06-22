package programmers.greedy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No42885 {
    @Test
    public void testSolutionForCase1() {
        //given
        int[] people = new int[]{70, 50, 80, 50};
        int limit = 100;

        //when
        int result = solution(people, limit);
        int answer = 3;

        //then
        assertEquals(answer, result);
    }

    @Test
    public void testSolutionForCase2() {
        //given
        int[] people = {70, 80, 50};
        int limit = 100;

        //when
        int result = solution(people, limit);
        int answer = 3;

        //then
        assertEquals(answer, result);
    }

    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int lighterIdx = 0;
        int heavierIdx = people.length - 1;
        int minLifeBoats = 0;

        while (lighterIdx <= heavierIdx) {
            boolean justOneRemained = (lighterIdx == heavierIdx);

            if (justOneRemained) {
                minLifeBoats++;
                break;
            }

            if (doesntSink(limit, people[lighterIdx], people[heavierIdx])) {
                lighterIdx++;
            }

            heavierIdx--;

            minLifeBoats++;
        }

        return minLifeBoats;
    }

    public boolean doesntSink(int limit, int lighterWeight, int heavierWeight) {
        return lighterWeight + heavierWeight <= limit;
    }
}