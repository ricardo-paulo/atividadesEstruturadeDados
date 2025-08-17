package ricardo_paulo.net.questions;

import java.util.Arrays;
import java.util.Scanner;

public class Question7 implements Question {

    private final int[][] values = new int[3][3];
    private final Scanner scan = new Scanner(System.in);

    public Question7() {
        fillArray3();
    }

    public void showResult() {
        for (int[] v : values) {
                System.out.println(Arrays.toString(v));
        }
    }

    public int[][] getValues() {
        return values;
    }

    public void fillArray3() {
        for (int i = 0; i < 3; i++) {
                System.out.print("Insira 3 números inteiros: ");
                String[] rawInput = scan.nextLine().split(" ");
                values[i][0] = Integer.parseInt(rawInput[0]);
                values[i][1] = Integer.parseInt(rawInput[1]);
                values[i][2] = Integer.parseInt(rawInput[2]);
        }
    }
}
