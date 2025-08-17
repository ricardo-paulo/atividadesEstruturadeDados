package ricardo_paulo.net;

import ricardo_paulo.net.questions.Question;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {

    private static int questionNumber;

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        solicitQuestionNumber();
        Class<?> RefClass = Class.forName("ricardo_paulo.net.questions.Question" + questionNumber);
        Question question = (Question) RefClass.getConstructor().newInstance();
        question.showResult();
    }

    private static void solicitQuestionNumber() {
        boolean validQuestion = false;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.print("Escolha uma questão (1 - 10): ");
            questionNumber = scan.nextInt();
            if (questionNumber > 0 && questionNumber <= 10) validQuestion = true;
        } while (!validQuestion);
    }
}