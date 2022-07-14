package programmers.hash;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No1845 {
    private int solution(int[] nums) {
        HashSet<Integer> phoneketMons = new HashSet<>();

        for (int phoneketMon : nums) {
            phoneketMons.add(phoneketMon);
        }

        return Math.min(phoneketMons.size(), nums.length / 2);
    }

    @Test
    public void testSolutionForCase1() {
        //given
        int[] nums = new int[]{3, 1, 2, 3};

        //when
        int result = solution(nums);
        int answer = 2;

        //then
        assertEquals(answer, result);
    }


    @Test
    public void testSolutionForCase2() {
        //given
        int[] nums = new int[]{3, 3, 3, 2, 2, 4};

        //when
        int result = solution(nums);
        int answer = 3;

        //then
        assertEquals(answer, result);
    }

    @Test
    public void testSolutionForCase3() {
        //given
        int[] nums = new int[]{3, 3, 3, 2, 2, 2};

        //when
        int result = solution(nums);
        int answer = 2;

        //then
        assertEquals(answer, result);
    }
}
