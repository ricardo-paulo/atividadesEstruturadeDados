package ricardo_paulo.net;

public class Search {

    public static Student sequentialSearch (Student[] students, long registry) {

        for (Student student : students) {
            try {
                if (student.getRegistry() == registry)
                    return student;
            } catch (Exception e) {
                if (e.getCause() == null) {
                    return new Student();
                }
            }
        }

        return new Student();
    }

    public static Student sequentialSearch (Student[] students, String email) {

        for (Student student : students) {
            try {
                if (student.getEmail().equals(email))
                    return student;
            } catch (Exception e) {
                if (e.getCause() == null) {
                    return new Student();
                }
            }
        }

        return new Student();
    }

    public static Student sequentialSearch (Student[] students, String name, boolean strict) {

        for (Student student : students) {
            try {
                if (strict) {
                    if (student.getName().equals(name))
                        return student;
                } else {
                    if (student.getName().contains(name))
                        return student;
                }
            } catch (Exception e) {
                if (e.getCause() == null) {
                    return new Student();
                }
            }
        }

        return new Student();
    }

    public static Student binarySearch (Student[] students, long registry) {
        int start = 0;
        int finish = students.length - 1;

        while (start <= finish) {
            int middle = (finish + start) / 2;

            try {
                if (students[middle].getRegistry() == registry) {
                    return students[middle];
                } else if (students[middle].getRegistry() < registry) {
                    start = middle + 1;
                } else {
                    finish = middle - 1;
                }
            } catch (Exception e) {
                if (e.getCause() == null) {
                    return new Student();
                }
            }
        }

        return new Student();
    }

}
