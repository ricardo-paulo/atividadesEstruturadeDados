public class Question4 {
    public static void main(String[] args) {
        String[] strings = {"Arlan", "Bruna", "Lara", "Morgana", "Patrik", "Victor"};
        String target = "Morgana";

        System.out.printf("Index da string: %d", searchStringIndex(strings, target));
    }

    private static int searchStringIndex(String[] strings, String target) {
        int start = 0;
        int finish = strings.length - 1;

        while (start <= finish) {
            int middle = (start + finish) / 2;
            int compareReferente = target.compareTo(strings[middle]);

            if (compareReferente == 0) {
                return middle;
            } else if (compareReferente > 0) {
                start = middle + 1;
            } else {
                finish = middle - 1;
            }
        }

        return -1;
    }
}
