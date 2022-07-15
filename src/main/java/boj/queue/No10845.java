package boj.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No10845 {
    private static Queue<Integer> numbers = new LinkedList<>();
    private static List<Integer> results = new ArrayList<>();
    private static int lastNumber = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int commandSize = Integer.parseInt(br.readLine());

        for (int commandIdx = 0; commandIdx < commandSize; commandIdx++) {
            commandProcessor(br.readLine());
        }

        results.forEach(System.out::println);
    }

    private static void commandProcessor(String command) {
        int number = -1;

        if (command.contains("push")) {
            number = Integer.parseInt(command.split(" ")[1].trim());
            numbers.offer(number);
            lastNumber = number;
            return;
        }

        if (command.contains("pop")) {
            number = numbers.isEmpty() ? -1 : numbers.poll();
        } else if (command.contains("size")) {
            number = numbers.size();
        } else if (command.contains("empty")) {
            number = numbers.isEmpty() ? 1 : 0;
        } else if (command.contains("front")) {
            number = numbers.isEmpty() ? number : numbers.peek();
        } else if (command.contains("back")) {
            number = numbers.isEmpty() ? number : lastNumber;
        } else {
            return;
        }

        results.add(number);
    }
}
