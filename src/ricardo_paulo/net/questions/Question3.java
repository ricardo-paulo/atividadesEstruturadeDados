package ricardo_paulo.net.questions;

import java.util.Arrays;
import java.util.Scanner;

public class Question3 implements Question {

    private final int numbsSum;

    public Question3() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Insira 5 números inteiros: ");
        String[] rawInput = scan.nextLine().split(" ");
        int[] numbs = new int[5];
        for (int i = 0; i < numbs.length; i++) {
            numbs[i] = Integer.parseInt(rawInput[i]);
        }

        numbsSum = Arrays.stream(numbs).sum();
    }


    public void showResult() {
        System.out.printf("A soma dos números acima é %d\n", numbsSum);
    }
}
