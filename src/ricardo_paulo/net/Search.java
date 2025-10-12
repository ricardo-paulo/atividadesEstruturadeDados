package ricardo_paulo.net;

public class Search {

    public static Student sequentialSearch (Student[] students, long target) {

        for (int i = 0; i < students.length; i++) {
            if (students[i].getRegistry() == target)
                return students[i];
        }

        return new Student();
    }

    public static Student binarySearch (Student[] students, long target) {
        int start = 0;
        int finish = students.length - 1;

        while (start <= finish) {
            int middle = (finish + start) / 2;

            if (students[middle].getRegistry() == target) {
                return students[middle];
            } else if (students[middle].getRegistry() < target) {
                start = middle + 1;
            } else {
                finish = middle - 1;
            }
        }

        return new Student();
    }

}
