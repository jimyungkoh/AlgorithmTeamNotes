package boj.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No1158 {
    public static void main(String[] args) throws IOException {
        No1158 main = new No1158();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        Queue<Integer> people = main.getPeople(n);

        System.out.println(main.getJosephusPermutation(people, k));
    }

    private Queue<Integer> getPeople(int n) {
        Queue<Integer> people = new LinkedList<>();

        for (int personNumber = 1; personNumber <= n; personNumber++) {
            people.offer(personNumber);
        }

        return people;
    }

    private StringBuilder getJosephusPermutation(Queue<Integer> people, int k) {
        int count = 1;

        StringBuilder josephusPermutation = new StringBuilder().append("<");

        while (!people.isEmpty()) {
            if (count == k) {
                josephusPermutation.append(people.poll()).append(", ");

                count = 1;

                continue;
            }

            people.offer(people.poll());
            count++;
        }

        josephusPermutation.setLength(josephusPermutation.length()-2);
        josephusPermutation.append(">");

        return josephusPermutation;
    }
}
