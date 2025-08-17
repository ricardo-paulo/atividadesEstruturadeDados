package ricardo_paulo.net.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Question5 implements Question{

    private final int numberOfElements = 8;
    private final ArrayList<Integer> A = new ArrayList<>();
    private final ArrayList<Integer> B = new ArrayList<>();
    private final ArrayList<Integer> C = new ArrayList<>();

    public Question5() {

        fillArrays();
        Collections.sort(A);
        Collections.sort(B);

        for (int i = 0; i < numberOfElements; i++) {
            C.add(A.get(0) - B.get(0));
            A.remove(0);
            B.remove(0);
        }
    }

    private void fillArrays() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Insira 8 valores inteiros: ");
        String[] rawA = scan.nextLine().split(" ");
        System.out.print("Insira 8 valores inteiros: ");
        String[] rawB = scan.nextLine().split(" ");

        for (int i = 0; i < numberOfElements; i++) {
            A.add(Integer.parseInt(rawA[i]));
            B.add(Integer.parseInt(rawB[i]));
        }
    }

    public void showResult() {
        System.out.printf("O resultado da operação é: %s\n", C);
    }
}
