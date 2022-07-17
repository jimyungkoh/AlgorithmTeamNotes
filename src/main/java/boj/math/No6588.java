package boj.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Solved
public class No6588 {
    boolean[] primeNumbers = new boolean[1000000];
    String wrongMassage = "Goldbach's conjecture is wrong.";
    StringBuilder resultBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        No6588 main = new No6588();

        main.setPrimeNumbers();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                break;
            }

            System.out.println(main.getGoldbachFormula(input));
            main.resultBuilder.setLength(0);
        }
    }

    private String getGoldbachFormula(int input) {
        for (int number = input - 1; number >= input/2; number -= 2) {
            int anotherNumber = input - number;

            if (primeNumbers[number] && primeNumbers[anotherNumber]) {
                resultBuilder.append(input).append(" = ").append(anotherNumber)
                        .append(" + ").append(number);
                break;
            }
        }

        return resultBuilder.length() == 0 ? wrongMassage : resultBuilder.toString();
    }

    private void setPrimeNumbers() {
        for (int i = 2; i < primeNumbers.length; i++) {
            primeNumbers[i] = true;
        }

        for (int i = 2; i < primeNumbers.length; i++) {
            if (!primeNumbers[i]) continue;

            for (int j = 2; i * j < primeNumbers.length; j++) {
                primeNumbers[i * j] = false;
            }
        }
    }
}
