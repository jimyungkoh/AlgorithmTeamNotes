package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No9093 {
    private static StringBuilder sentence = new StringBuilder();
    private static StringBuilder reversedWord = new StringBuilder();

    private static List<String> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- != 0) {
            String[] words = br.readLine().split(" ");

            reverseProcessor(words);
        }

        results.forEach(System.out::println);
    }

    private static void reverseProcessor(String[] words) {
        for (String word : words) {
            sentence.append(reversedWord.append(word).reverse());
            sentence.append(" ");
            reversedWord.setLength(0);
        }

        results.add(sentence.toString().trim());
        sentence.setLength(0);
    }
}
