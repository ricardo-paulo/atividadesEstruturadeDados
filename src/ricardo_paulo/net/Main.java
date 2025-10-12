package ricardo_paulo.net;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class Main {

    private static Student[] students = new Student[1];

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

        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - Aluno\n2 - Boletim");
        int subOption = scanner.nextInt();

        if (subOption != 1 && subOption != 2)
            throw new InvalidParameterException("Opção inválida!");

        if (subOption == 1) {
            if (students[0] != null) {
                Student[] temp = students.clone();
                students = new Student[temp.length + 1];
                for (int obj = 0; obj < temp.length; obj++) {
                    students[obj] = temp[obj];
                }
            }

            System.out.print("Insira a matrícula do aluno: ");
            long registry = scanner.nextLong();
            scanner = new Scanner(System.in);
            System.out.print("Insira o nome do aluno: ");
            String name = scanner.nextLine();
            System.out.print("Insira o endereço completo: ");
            String address = scanner.nextLine();
            System.out.print("Insira o email: ");
            String email = scanner.nextLine();
            System.out.print("Insira o número de telefone (com DDD): ");
            String phoneNumber = scanner.nextLine();

            students[students.length - 1] = new Student(registry, name, address, email, phoneNumber);
        } else {
            System.out.print("Insira a matrícula do aluno: ");
            long studentRegistry = scanner.nextLong();
            double[] english = SchoolReport.requestNotes("Inglês");
            double[] math = SchoolReport.requestNotes("Matemática");
            double[] history = SchoolReport.requestNotes("História");
            double[] geography = SchoolReport.requestNotes("Geografia");
            double[] physics = SchoolReport.requestNotes("Física");
            double[] chemistry = SchoolReport.requestNotes("Química");
            double[] biology = SchoolReport.requestNotes("Biologia");
            double[] science = SchoolReport.requestNotes("Ciências");
            double[] philosophy = SchoolReport.requestNotes("Filosofia");
            double[] physicalEducation = SchoolReport.requestNotes("Educação Física");
            SchoolReport studentSchoolReport = new SchoolReport(english, math, history, geography, physics,
                    chemistry, biology, science, philosophy, physicalEducation);

            Student student = Search.binarySearch(students, studentRegistry);
            student.setNotes(studentSchoolReport);
        }
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
