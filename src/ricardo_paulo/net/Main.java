package ricardo_paulo.net;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] values = {8, 9, 5, 1, 88, 9, 51, 3};
        String name = "Paulo Ricardo";
        char[] splitName = name.replace(" ", "")
                .toLowerCase()
                .toCharArray();

        System.out.println("----- MÉTODO DE INSERÇÃO -----");
        System.out.println(Arrays.toString(insertionSort(values)));
        System.out.println(Arrays.toString(insertionSort(splitName)));

        System.out.println("----- MÉTODO DE SELEÇÃO -----");
        System.out.println(Arrays.toString(selectionSort(values)));
        System.out.println(Arrays.toString(selectionSort(splitName)));
    }

    public static int[] insertionSort(int[] values) {
        int[] arr = values.clone();

        for (int i = 1; i < arr.length; i++) {
            int j = i;

            while (j > 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j -= 1;
            }
        }

        return arr;
    }

    public static char[] insertionSort(char[] values) {
        char[] arr = values.clone();

        for (int i = 1; i < arr.length; i++) {
            int j = i;

            while (j > 0 && arr[j] < arr[j - 1]) {
                char temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j -= 1;
            }
        }

        return arr;
    }

    public static int[] selectionSort(int[] values) {
        int[] arr = values.clone();
        int n = arr.length;

        // Percorre o array e é responsável por ordená-lo completamente.
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Percorre a parte não ordenada em busca do índice do menor elemento.
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }

    public static char[] selectionSort(char[] values) {
        char[] arr = values.clone();
        int n = arr.length;

        // Percorre o array e é responsável por ordená-lo completamente.
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Percorre a parte não ordenada em busca do índice do menor elemento.
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }

            char temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }
}