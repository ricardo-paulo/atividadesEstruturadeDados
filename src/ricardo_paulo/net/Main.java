package ricardo_paulo.net;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Bem vindo ao sistema de registro de alunos!");
        System.out.println("Escolha uma operação abaixo: ");

        boolean exit = false;

        do {
            System.out.println("1 - Cadastro\n2 - Consulta\n3 - Edição\n4 - Exclusão\n0 - Sair");
            int option = scan.nextInt();

            switch (option) {
                case 1: register();
                    break;
                case 2: System.out.println(search());
                    break;
                case 3: update();
                    break;
                case 4: delete();
                    break;
                case 0: exit = true;
                    break;

                default: System.out.println("Insira uma opção válida!");
            }
        } while (!exit);

        System.out.println("Programa finalizado.");
    }

    // Paulo
    private static void register () {

    }

    // Paulo
    private static String search () {

        return "";
    }

    // Arthur
    private static void update () {

    }

    // Jackson
    private static void delete () {

    }
}
