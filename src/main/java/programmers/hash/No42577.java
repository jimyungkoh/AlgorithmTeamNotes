package programmers.hash;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No42577 {
    @Test
    public void testSolutionForCase1() {
        //given
        String[] phone_book = new String[]{"119", "97674223", "1195524421"};

        //when
        boolean result = solution(phone_book);
        boolean answer = false;

        //then
        assertEquals(answer, result);
    }

    @Test
    public void testSolutionForCase2() {
        //given
        String[] phone_book = new String[]{"123", "456", "789"};

        //when
        boolean result = solution(phone_book);
        boolean answer = true;

        //then
        assertEquals(answer, result);
    }

    @Test
    public void testSolutionForCase3() {
        //given
        String[] phone_book = new String[]{"12", "123", "1235", "567", "88"};

        //when
        boolean result = solution(phone_book);
        boolean answer = false;

        //then
        assertEquals(answer, result);
    }

    public boolean solution(String[] phoneBook) {
        boolean isNotDuplicate = true;

        HashMap<String, Integer> phoneBookMap = new HashMap<>();

        Arrays.stream(phoneBook).forEach(phoneNumber -> phoneBookMap.put(phoneNumber, 1));

        verification:
        for (String phoneNumber : phoneBook) {
            for (int nth = 1; nth < phoneNumber.length(); nth++) {
                String prefix = phoneNumber.substring(0, nth);

                if (isDuplicate(phoneBookMap, prefix)) {
                    isNotDuplicate = false;
                    break verification;
                }
            }
        }

        return isNotDuplicate;
    }

    public boolean isDuplicate(HashMap<String, Integer> phoneBookMap, String prefix) {
        return phoneBookMap.containsKey(prefix);
    }
}
