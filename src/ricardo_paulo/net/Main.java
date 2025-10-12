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
                case 2: search();
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
        System.out.println("1 - Aluno\n2 - Boletim\n0 - Voltar");
        int subOption = scanner.nextInt();

        if (subOption == 0)
            return;

        if (subOption != 1 && subOption != 2)
            throw new InvalidParameterException("Opção inválida!");

        if (subOption == 1) {
            // Incrementa o tamanho da lista de estudantes.
            if (students[0] != null) {
                Student[] temp = students.clone();
                students = new Student[temp.length + 1];
                for (int obj = 0; obj < temp.length; obj++) {
                    students[obj] = temp[obj];
                }
            }

            // TODO Substituir a inserção da matrícula manual por uma criação automática da matrícula
            //  pelo sistema (novo registro = ano atual + students.length). students.length terá a formatação
            //  de quatro dígitos, caso o número de estudantes não alcance 4 dígitos o restante deverá ser preenchido.
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

            Student newStudent = new Student(registry, name, address, email, phoneNumber);

            // Busca por registros de matrícula e email duplicados.
            if (Search.binarySearch(students, registry).getRegistry() != -1) {
                throw new InvalidParameterException("A matrícula já existe!");
            }
            if (Search.sequentialSearch(students, email).getRegistry() != -1) {
                throw new InvalidParameterException("O email inserido já existe!");
            }

            students[students.length - 1] = newStudent;
        } else {
            System.out.print("Insira a matrícula do aluno: ");
            long studentRegistry = scanner.nextLong();
            Student student = Search.binarySearch(students, studentRegistry);
            if (student.getRegistry() == -1) {
                throw new InvalidParameterException("A matrícula inserida não está registrada!");
            }
            // Busca por boletins duplicados.
            if (student.getSchoolReport() != null) {
                throw new InvalidParameterException("O aluno já possui um boletim vinculado!");
            }

            SchoolReport studentSchoolReport = new SchoolReport();
            System.out.println("Deixe a linha vazia para encerrar a coleta de notas.");

            do {
                Scanner notesScanner = new Scanner(System.in);
                double[] notes = new double[4];

                System.out.println("Insira a disciplina:");
                String discipline = notesScanner.nextLine();

                if (discipline.isEmpty()) {
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    System.out.printf("Insira a %dª nota da disciplina %s: ", i + 1, discipline);
                    double note = notesScanner.nextDouble();
                    if (note < 0 || note > 10)
                        throw new InvalidParameterException("A nova inserida é inválida!");
                    notes[i] = note;
                }

                studentSchoolReport.addNoteSet(discipline, notes);
            } while (true);

            student.setSchoolReport(studentSchoolReport);
        }
    }

    // Paulo
    private static void search () {

        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                1 - Busca por matrícula
                2 - Busca por nome
                3 - Busca por email
                4 - Todos (Ordem de inserção)
                5 - Todos (Ordem alfabética)
                0 - Voltar""");
        int subOption = scanner.nextInt();

        if (subOption == 0)
            return;

        // TODO Perguntar ao usuário se deseja incluir o boletim ou não.

        if (subOption < 1 || subOption > 6)
            throw new InvalidParameterException("Opção inválida!");

        scanner = new Scanner(System.in);

        if (subOption == 1) {
            System.out.print("Insira a matrícula do aluno: ");
            long studentRegistry = scanner.nextLong();
            Student result = Search.binarySearch(students, studentRegistry);

            if (result.getRegistry() == -1) {
                System.out.printf("Aluno de matrícula %d não foi encontrado.\n", studentRegistry);
            } else {
                result.showStudentInfo();
            }
        }

        if (subOption == 2){
            System.out.print("Insira o nome completo do aluno: ");
            String studentName = scanner.nextLine();
            System.out.print("""
                    Deseja uma comparação estrita (true ou false)?
                    Utilizando comparação estrita a pesquisa será realizada para um nome exatamente igual ao inserido.
                    """);
            boolean strict = scanner.nextBoolean();
            Student result = Search.sequentialSearch(students, studentName, strict);

            if (result.getRegistry() == -1) {
                System.out.printf("Aluno de nome %s não foi encontrado.\n", studentName);
            } else {
                result.showStudentInfo();
            }
        }

        if (subOption == 3) {
            System.out.print("Insira o email do aluno: ");
            String studentEmail = scanner.nextLine();
            Student result = Search.sequentialSearch(students, studentEmail);

            if (result.getRegistry() == -1) {
                System.out.printf("Aluno de email %s não foi encontrado.\n", studentEmail);
            } else {
                result.showStudentInfo();
            }
        }

        if (subOption == 4) {
            for (Student student : students) {
                student.showStudentInfo();
            }
        }

        if (subOption == 5) {
            System.out.print("Ordem alfabética invérsa (true ou false)? ");
            boolean reverseAlphabetical = scanner.nextBoolean();

            Student[] orderedStudents = SortingMethods.selectionSort(students, reverseAlphabetical);
            for (Student student : orderedStudents) {
                student.showStudentInfo();
            }
        }
    }

    // Arthur
    private static void update () {

    }

    // Jackson
    private static void delete () {

    }
}
