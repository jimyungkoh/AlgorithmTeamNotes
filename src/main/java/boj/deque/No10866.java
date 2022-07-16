package boj.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class No10866 {

    private Deque<Integer> numberDeque = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        No10866 main = new No10866();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfCommands = Integer.parseInt(br.readLine());

        for (int nthCommand = 0; nthCommand < numberOfCommands; nthCommand++) {
            main.commandProcessor(br.readLine());
        }
    }

    private void commandProcessor(String command) {
        int number = -1;

        if (command.contains("push_front") || command.contains("push_back")) {
            number = Integer.parseInt(command.split(" ")[1].trim());

            if (command.contains("push_front")) {
                numberDeque.offerFirst(number);
            } else if (command.contains("push_back")) {
                numberDeque.offerLast(number);
            }

            return;
        }

        if (command.contains("pop_front")) {
            number = numberDeque.isEmpty() ? number : numberDeque.pollFirst();
        } else if (command.contains("pop_back")) {
            number = numberDeque.isEmpty() ? number : numberDeque.pollLast();
        } else if (command.contains("size")) {
            number = numberDeque.size();
        } else if (command.contains("empty")) {
            number = numberDeque.isEmpty() ? 1 : 0;
        } else if (command.contains("front")) {
            number = numberDeque.isEmpty() ? number : numberDeque.getFirst();
        } else if (command.contains("back")) {
            number = numberDeque.isEmpty() ? number : numberDeque.getLast();
        }

        System.out.println(number);
    }
}
