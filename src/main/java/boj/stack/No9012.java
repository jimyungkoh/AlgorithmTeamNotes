package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- != 0) {
            System.out.println(yesOrNo(br.readLine().toCharArray()));
        }
    }

    private static Result yesOrNo(char[] brackets) {
        int checkSum = 0;

        for (char bracket : brackets) {
            checkSum += bracket == '(' ? 1 : -1;

            if (checkSum < 0) return Result.NO;
        }

        if (checkSum != 0) return Result.NO;

        return Result.YES;
    }

    public enum Result {
        YES, NO;
    }
}
