package programmers.hash;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No42576 {
    @Test
    public void testSolutionForCase1() {
        //given
        String[] participants = new String[]{"leo", "kiki", "eden"};
        String[] completion = new String[]{"eden", "kiki"};

        //when
        String result = solution(participants, completion);
        String answer = "leo";

        //then
        assertEquals(answer, result);
    }

    @Test
    public void testSolutionForCase2() {
        //given
        String[] participants = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = new String[]{"josipa", "filipa", "marina", "nikola"};

        //when
        String result = solution(participants, completion);
        String answer = "vinko";

        //then
        assertEquals(answer, result);
    }

    @Test
    public void testSolutionForCase3() {
        //given
        String[] participants = new String[]{"mislav", "stanko", "mislav", "ana"};
        String[] completion = new String[]{"stanko", "ana", "mislav"};

        //when
        String result = solution(participants, completion);
        String answer = "mislav";

        //then
        assertEquals(answer, result);
    }

    private String solution(String[] participants, String[] finishers) {
        HashMap<String, Integer> loserMap = new HashMap<>();

        for (String participant : participants) {
            loserMap.put(participant,
                    loserMap.getOrDefault(participant, 0) + 1);
        }

        for (String finisher : finishers) {
            loserMap.put(finisher, loserMap.get(finisher) - 1);
        }

        String loser = "";

        for (String name: loserMap.keySet()){
            if(loserMap.get(name)!=0){
                loser = name;
                break;
            }
        }

        return loser;
    }
}
