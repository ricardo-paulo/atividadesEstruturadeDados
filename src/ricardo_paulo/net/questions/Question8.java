package ricardo_paulo.net.questions;

import java.util.Arrays;

public class Question8 implements Question {

    private int valuesSum = 0;

    public Question8() {
        Question7 question7 = new Question7();
        int[][] values = question7.getValues();
        for (int[] line : values) {
            for (int column : line) {
                    valuesSum += column;
            }
        }
    }

    public void showResult() {
        System.out.printf("A soma dos valores da matriz é: %d\n", valuesSum);
    }
}
