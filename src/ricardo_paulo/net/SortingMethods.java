package ricardo_paulo.net;

public class SortingMethods {

    public static Student[] selectionSort(Student[] students) {
        Student[] arr = students.clone();
        int n = arr.length;

        try {
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;

                for (int j = i + 1; j < n; j++) {
                    if (arr[j].getRegistry() < arr[minIndex].getRegistry())
                        minIndex = j;
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
