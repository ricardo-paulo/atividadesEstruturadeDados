public class Question5 {
    public static void main(String[] args) {
        Student[] students = {
                new Student(20001, "Jéssica", "21/07/1989", "ela@email.com",
                        "Rua Nunca Vista, SN, Belo Universo", "(99) 99999-9999"),

                new Student(20002, "Paulo", "05/03/1995", "paulo123@email.com",
                        "Av. dos Ventos, 100, Jardim Azul", "(11) 91234-5678"),

                new Student(20003, "Mariana", "14/11/1992", "mariana92@email.com",
                        "Rua das Flores, 45, Centro", "(21) 99876-5432"),

                new Student(20004, "Ricardo", "30/08/1990", "ricardo_rj@email.com",
                        "Travessa Sol Nascente, 12, Vila Nova", "(31) 98765-4321"),

                new Student(20005, "Fernanda", "09/01/1998", "fernandinha98@email.com",
                        "Alameda das Palmeiras, 500, Campo Verde", "(41) 97654-3210")
        };
        int target = 20005;

        System.out.printf("Índex do estudante: %d", searchStudent(students, target));
    }

    private static int searchStudent(Student[] students, int target) {
        int start = 0;
        int finish = students.length - 1;

        while (start <= finish) {
            int middle = (finish + start) / 2;
            Student refStudent = students[middle];

            if (refStudent.getRegistry() == target) {
                return middle;
            } else if (refStudent.getRegistry() < target) {
                start = middle + 1;
            } else {
                finish = middle - 1;
            }
        }

        return -1;
    }
}
