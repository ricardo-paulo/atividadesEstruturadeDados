package ricardo_paulo.net.questions;

import java.util.Scanner;

public class Question2 implements Question {

    private final String[] names;

    public Question2 () {
        Scanner scan = new Scanner(System.in);
        System.out.print("Insira 8 nomes (separados por espaço): ");
        names = scan.nextLine().split(" ");
    }

    public void showResult() {
        for (int n = names.length - 1; n >= 0; n--) {
            System.out.printf("%s\n", names[n]);
        }
    }
}
