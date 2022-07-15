package boj.stack;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No10828 {
    private static List<Integer> result = new ArrayList<>();
    private static Stack<Integer> numbers = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfCommands = Integer.parseInt(br.readLine());

        for (int idx = 0; idx < numberOfCommands; idx++) {
            commandProcessor(br.readLine());
        }

        result.forEach(System.out::println);
    }

    private static void commandProcessor(String command) {
        int number = 0;

        if (command.contains("push")) {
            number = Integer.parseInt(command.split(" ")[1].trim());
            numbers.push(number);
            return;
        }

        if (command.contains("pop")) {
            number = numbers.isEmpty() ? -1 : numbers.pop();
        } else if (command.contains("size")) {
            number = numbers.size();
        } else if (command.contains("empty")) {
            number = numbers.isEmpty() ? 1 : 0;
        } else if (command.contains("top")) {
            number = numbers.isEmpty() ? -1 : numbers.peek();
        } else {
            return;
        }

        result.add(number);
    }

    @Test
    void testCase1() {
        result = new ArrayList<>();
        numbers = new Stack<>();

        int numberOfCommands = 14;
        String[] commands = new String[]{
                "push 1", "push 2", "top", "size",
                "empty", "pop", "pop", "pop", "size",
                "empty", "pop", "push 3", "empty", "top"
        };

        for (String command : commands) {
            commandProcessor(command);
        }
        List<Integer> answer = Arrays.asList(2, 2, 0, 2, 1, -1, 0, 1, -1, 0, 3);

        assertEquals(answer, result);
    }

    @Test
    void testCase2() {
        result = new ArrayList<>();
        numbers = new Stack<>();

        int numberOfCommands = 7;
        String[] commands = new String[]{
                "pop", "top", "push 123", "top", "pop", "top", "pop"};


        for (String command : commands) {
            commandProcessor(command);
        }

        List<Integer> answer = Arrays.asList(-1, -1, 123, 123, -1, -1);

        assertEquals(answer, result);
    }
}
