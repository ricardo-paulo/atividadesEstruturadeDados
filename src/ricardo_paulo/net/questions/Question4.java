package ricardo_paulo.net.questions;

import java.util.Arrays;
import java.util.Scanner;

public class Question4 implements Question {

    private final int[] C = new int[6];

    public Question4() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Insira 6 valores para o primeiro vetor: ");
        String[] rawA = scan.nextLine().split(" ");
        System.out.print("Insira 6 valores para o segundo vetor: ");
        String[] rawB = scan.nextLine().split(" ");
        int[] A = new int[6];
        int[] B = new int[6];

        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(rawA[i]);
            B[i] = Integer.parseInt(rawB[i]);
            C[i] = A[i] + B[i];
        }
    }

    public void showResult() {
        System.out.printf("Soma dos dois vetores: %s\n", Arrays.toString(C));
    }
}
