package ricardo_paulo.net;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        int[] values = {64, 34, 25, 12, 99, 22, 11, 9};
        int[] values2 = {38, 27, 1, 102, 43, 3, 9, 82, 10, 7};

        String name = "Paulo Ricardo";
        char[] splitName = name.replace(" ", "")
                .toLowerCase()
                .toCharArray();

        System.out.println("----- MÉTODO BUBBLE -----");
        System.out.println(Arrays.toString(bubbleSort(values)));
        System.out.println(Arrays.toString(bubbleSort(splitName)));

        System.out.println("----- MÉTODO MERGE ITERATIVO -----");
        System.out.println(Arrays.toString(iterativeMergeSort(values2)));
//        System.out.println(Arrays.toString(bubbleSort(splitName)));
    }

    public static int[] bubbleSort (int[] values) {
        int[] arr = values.clone();
        int l = arr.length;
        boolean switched;

        do {
            switched = false;

            for (int i = 0; i < l - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    switched = true;
                }
            }
            l--;
        } while (switched);

        return arr;
    }

    public static char[] bubbleSort (char[] values) {
        char[] arr = values.clone();
        int l = arr.length;
        boolean switched;

        do {
            switched = false;

            for (int i = 0; i < l - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    char temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    switched = true;
                }
            }
            l--;
        } while (switched);

        return arr;
    }

    public static int[] merge (int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }

    public static int[] iterativeMergeSort(int[] values) {
        int[] arr = values.clone();
        int n = arr.length;

        for (int l = 1; l < n; l *= 2) {
            for (int i = 0; i < n; i += 2 * l) {
                int middle = Math.min(i + l, n);
                int end = Math.min(i + 2 * l, n);

                int[] left = Arrays.copyOfRange(arr, i, middle);
                int[] right = Arrays.copyOfRange(arr, middle, end);

                int[] combined = merge(left, right);

                for (int j = 0; j < combined.length; j++) {
                    arr[i + j] = combined[j];
                }
            }
        }

        return arr;
    }
}
