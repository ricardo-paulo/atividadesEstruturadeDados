package ricardo_paulo.net;

import java.util.Objects;

public class Search {

    public static Student sequentialSearch (Student[] students, long registry) {

        for (int i = 0; i < students.length; i++) {
            if (students[i].getRegistry() == registry)
                return students[i];
        }

        return new Student();
    }

    public static Student sequentialSearch (Student[] students, String email) {

        for (int i = 0; i < students.length; i++) {
            if (students[i].getEmail().equals(email))
                return students[i];
        }

        return new Student();
    }

    public static Student binarySearch (Student[] students, long registry) {
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
