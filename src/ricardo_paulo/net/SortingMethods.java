package ricardo_paulo.net;

public class SortingMethods {

    public static Student[] selectionSort(Student[] students, boolean reverseAlphabetical) {
        Student[] arr = students.clone();
        int n = arr.length;

        try {
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;

                for (int j = i + 1; j < n; j++) {
                    if (!reverseAlphabetical) {
                        if (arr[j].getName().charAt(0) < arr[minIndex].getName().charAt(0))
                            minIndex = j;
                    } else {
                        if (arr[j].getName().charAt(0) > arr[minIndex].getName().charAt(0))
                            minIndex = j;
                    }
                }

                Student temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        } catch (Exception e) {
            if (e.getCause() == null) {
                return arr;
            }
        }

        return arr;
    }

}
