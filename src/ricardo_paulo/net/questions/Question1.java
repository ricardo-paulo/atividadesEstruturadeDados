package ricardo_paulo.net.questions;

import java.util.Scanner;

public class Question1 implements Question {

    private final String[] userFruits;

    public Question1 () {
        Scanner scan = new Scanner(System.in);
        System.out.print("Insira o nome de cinco frutas (separadas por espaço): ");
        userFruits = scan.nextLine().split(" ");
    }

    public void showResult() {
        System.out.printf("Fruta da 3ª posição: %s\n", userFruits[2]);
        System.out.printf("Fruta da última posição: %s\n", userFruits[userFruits.length - 1]);
    }
}
