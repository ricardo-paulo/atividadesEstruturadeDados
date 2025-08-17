package ricardo_paulo.net.questions;

import java.util.Scanner;

public class Question6 implements Question {

    private final int[] values;

    public Question6() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Insira 7 valores inteiros: ");
        String[] rawValues = scan.nextLine().split(" ");
        values = new int[rawValues.length];
        for (int v = 0; v < rawValues.length; v++) {
            values[v] = Integer.parseInt(rawValues[v]);
        }
    }

    public void showResult() {
        System.out.println("Resultados:");
        for (int numb : values) {
            boolean pair = (numb % 2) == 0;
            if (pair) {
                System.out.printf("%d - Par\n", numb);
            } else {
                System.out.printf("%d - Ímpar\n", numb);
            }
        }
    }
}
