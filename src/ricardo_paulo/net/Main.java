package ricardo_paulo.net;

import java.security.InvalidParameterException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Arrays;
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

            // Obtêm o ano atual e o tamanho formatado da lista de alunos para criar a matrícula.
            DecimalFormat decimalFormat = new DecimalFormat("0000");
            String thisDate = String.valueOf(LocalDate.now().getYear());
            String sRegistry = thisDate + decimalFormat.format(students.length);
            long registry = Long.parseLong(sRegistry);

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

            System.out.printf("Matrícula do aluno: %d\n", registry);
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

    private static void search () {

        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                1 - Busca por matrícula
                2 - Busca por nome
                3 - Busca por email
                4 - Todos (Ordem de inserção)
                5 - Todos (Ordem alfabética)
                6 - Ranking
                0 - Voltar""");
        int subOption = scanner.nextInt();

        if (subOption == 0)
            return;

        if (subOption < 1 || subOption > 6)
            throw new InvalidParameterException("Opção inválida!");

        System.out.print("Deseja que o boletim do aluno seja exibido (true ou false)? ");
        boolean includeReport = scanner.nextBoolean();

        scanner = new Scanner(System.in);

        if (subOption == 1) {
            System.out.print("Insira a matrícula do aluno: ");
            long studentRegistry = scanner.nextLong();
            Student result = Search.binarySearch(students, studentRegistry);

            if (result.getRegistry() == -1) {
                System.out.printf("Aluno de matrícula %d não foi encontrado.\n", studentRegistry);
            } else {
                result.showStudentInfo();
                if (includeReport)
                    try {
                        result.getSchoolReport().showSchoolReport();
                    } catch (Exception e) {
                        if (e.getCause() == null)
                            System.out.println("Aluno não possui boletim!");
                    }
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
                if (includeReport)
                    try {
                        result.getSchoolReport().showSchoolReport();
                    } catch (Exception e) {
                        if (e.getCause() == null)
                            System.out.println("Aluno não possui boletim!");
                    }
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
                if (includeReport)
                    try {
                        result.getSchoolReport().showSchoolReport();
                    } catch (Exception e) {
                        if (e.getCause() == null)
                            System.out.println("Aluno não possui boletim!");
                    }
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
                if (includeReport)
                    try {
                        student.getSchoolReport().showSchoolReport();
                    } catch (Exception e) {
                        if (e.getCause() == null) {
                            System.out.println("Aluno não possui boletim!");
                        }
                    }
            }
        }
        if (subOption == 6) {
            double[] finalAvgStudents = new double[students.length];

            for (int s = 0; s < students.length; s++) {
                try {
                    finalAvgStudents[s] = students[s].getSchoolReport().getFinalAverage();
                } catch (Exception e) {
                    finalAvgStudents[s] = 0;
                }
            }

            System.out.print("Deseja que a classificação ocorra em ordem decrescente (true ou false)? ");
            boolean betterNoteFirst = scanner.nextBoolean();

            if (betterNoteFirst) {
                int betterNoteIndex = 0;
                int position = 1;
                for (int s = 0; s < finalAvgStudents.length; s++) {
                    // Obter o index da melhor média.
                    for (int n = 0; n < finalAvgStudents.length; n++) {
                        if (finalAvgStudents[n] > finalAvgStudents[betterNoteIndex])
                            betterNoteIndex = n;
                    }
                    // Exibir o aluno com maior média da lista.
                    System.out.printf("""
                        Aluno: %s
                        Média Final: %.2f
                        Posição: %dº lugar
                    """, students[betterNoteIndex].getName(), finalAvgStudents[betterNoteIndex], position);
                    if (includeReport)
                        students[betterNoteIndex].showStudentInfo();
                    position++;
                    System.out.println(Arrays.toString(finalAvgStudents));

                    finalAvgStudents[betterNoteIndex] = -1;
                }
            } else {
                int worseNoteIndex = 0;
                int position = finalAvgStudents.length;
                for (int s = 0; s < finalAvgStudents.length; s++) {
                    // Obter o index da pior média.
                    for (int n = 0; n < finalAvgStudents.length; n++) {
                        if (finalAvgStudents[n] < finalAvgStudents[worseNoteIndex])
                            worseNoteIndex = n;
                    }
                    // Exibir o aluno com maior média da lista.
                    System.out.printf("""
                        Aluno: %s
                        Média Final: %.2f
                        Posição: %dº lugar
                    """, students[worseNoteIndex].getName(), finalAvgStudents[worseNoteIndex], position);
                    if (includeReport)
                        students[worseNoteIndex].showStudentInfo();
                    position--;

                    finalAvgStudents[worseNoteIndex] = 11;
                }
            }
        }

    }

    // Arthur Borges:
    private static void update () {

        Scanner src = new Scanner(System.in);
        System.out.println("1 - Editar Aluno\n2 - Editar boletin\n0 - Voltar");
        int subOption = src.nextInt();
        src.nextLine();

        if (subOption == 0)
            return;

        if (subOption == 1) {
            System.out.print("Informe a matríccula: ");
            long registry = src.nextLong();
            src.nextLine();

            Student student = Search.binarySearch(students, registry);
            if (student.getRegistry() == -1) {
                System.out.println("Aluno não encontrado!");
                return;
            }

            System.out.println("Editar (1) Nome, (2) Endereço, (3) Email, (4) Telefone");
            int field = src.nextInt();
            src.nextLine();

            switch (field) {

                case 1:
                    System.out.print("Novo nome:");
                    student.setName(src.nextLine());
                    break;

                case 2:
                    System.out.print("Novo Endereço:");
                    student.setAddress(src.nextLine());
                    break;

                case 3:
                    System.out.print("Novo Email: ");
                    student.setEmail(src.nextLine());
                    break;

                case 4:
                    System.out.print("Novo telefone");
                    student.setPhoneNumber(src.nextLine());
                    break;

                default:
                    System.out.println("Opção inválida");
                    return;
            }

            System.out.println("Informações atualizadas com sucesso!");

        } else if (subOption == 2) {
            System.out.println("Informe a matrícula do aluno: ");
            long registry = src.nextLong();
            src.nextLine();

            Student student = Search.binarySearch(students, registry);
            if (student.getRegistry() == -1) {
                System.out.println("Aluno não encontrado!");
                return;
            }

            if (student.getSchoolReport() == null) {
                System.out.println("Este aluno não possui boletim no sistema!");
                return;

            }

            System.out.print("Indorme o nome da disciplina que deseja editar:");
            String discipline = src.nextLine();

            double[] notes = student.getSchoolReport().getNotes(discipline);
            if (notes == null) {
                System.out.println("Disciplina não encontrada!");
                return;
            }

            System.out.println("Notas atuais:");
            for (int i = 0; i < notes.length; i++) {
                System.out.printf("%dª nota: %.2f\n", i + 1, notes[i]);
            }

            System.out.println("Qual nota deseja alterar (1 a 4)?");
            int pos = src.nextInt();
            if (pos < 4) {
                System.out.println("Posição inválida!");
                return;
            }

            System.out.println("Nova nota: ");
            double novaNota = src.nextDouble();
            if (novaNota < 0 || novaNota > 10) {
                System.out.println("Nota inválida!");
                return;
            }

            notes[pos - 1] = novaNota;
            student.getSchoolReport().updateNotes(discipline, notes);

            System.out.println("Boletim atualizado com sucesso!");
        }
    }

    // Jackson Alves:
    private static void delete() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("1 - Excluir Aluno\n2 - Excluir Boletim\n0 - Volta");
    int subOption = scanner.nextInt();
    scanner.nextLine(); // Consome a quebra de linha após nextInt()

    if (subOption == 0)
        return;

    if (subOption == 1) {
            System.out.print("Informe a matrícula do aluno: ");
            long registry = scanner.nextLong();
            scanner.nextLine(); // Consome a quebra de linha após nextLong()

            Student student = Search.binarySearch(students, registry);
            if (student.getRegistry() == -1) {
                System.out.println("Aluno não encontrado!");
                return;
            }

            Student[] temp = new Student[students.length - 1];
            for (int i = 0, j = 0; i < students.length; i++) {
                if (students[i].getRegistry() != student.getRegistry()) {
                    temp[j++] = students[i];
                }
            }
            students = temp;

            System.out.println("Aluno removido com sucesso!");
        } else if (subOption == 2) {
            System.out.print("Informe a matrícula do aluno: ");
            long registry = scanner.nextLong();
            scanner.nextLine(); // Consome a quebra de linha após nextLong()

            Student student = Search.binarySearch(students, registry);
            if (student.getRegistry() == -1) {
                System.out.println("Aluno não encontrado!");
                return;
            }

            if (student.getSchoolReport() == null) {
                System.out.println("Este aluno não possui boletim no sistema!");
                return;
            }

            student.setSchoolReport(null);
            System.out.println("Boletim removido com sucesso!");
        } else {
            System.out.println("Opção inválida!");
        }
    }
}
