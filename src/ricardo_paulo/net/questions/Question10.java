package ricardo_paulo.net.questions;

import java.util.Arrays;

public class Question10 implements Question {

    private final int maxValueOnArray;

    public Question10() {
        Question9 question9 = new Question9();
        int[] values = Arrays.stream(question9.getRandomValues())
                .flatMapToInt(Arrays::stream)
                .sorted().toArray();
        maxValueOnArray = values[values.length - 1];
    }

    public void showResult() {
        System.out.printf("O maior valor da matriz é %d\n", maxValueOnArray);
    }
}
