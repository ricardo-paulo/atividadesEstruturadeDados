package ricardo_paulo.net.questions;

import java.util.ArrayList;
import java.util.Arrays;

public class Question9 implements Question {

    int arrayLength = 4;

    int[][] randomValues = new int[arrayLength][arrayLength];

    ArrayList<Integer> linesSum = new ArrayList<>();
    public Question9() {
        for (int l = 0; l < arrayLength; l++) {
            for (int c = 0; c < arrayLength; c++) {
                randomValues[l][c] = (int) (Math.random() * 100);
            }
        }

        for (int[] i : randomValues) {
            int result = Arrays.stream(i)
                    .reduce(0, Integer::sum);
            linesSum.add(result);
        }
    }

    public int[][] getRandomValues() {
        return randomValues;
    }

    public void showResult() {
        for (int i = 0; i < arrayLength; i++) {
            System.out.printf("Soma da linha %d: %d\n", i, linesSum.get(i));
        }
    }
}
