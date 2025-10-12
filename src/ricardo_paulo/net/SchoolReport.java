package ricardo_paulo.net;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class SchoolReport {

    private final int periods = 4;
    private double[] english;
    private double[] math;
    private double[] history;
    private double[] geography;
    private double[] physics;
    private double[] chemistry;
    private double[] biology;
    private double[] science;
    private double[] philosophy;
    private double[] physicalEducation;

    public SchoolReport() {
        this.english = new double[]{};
        this.math = new double[]{};
        this.history = new double[]{};
        this.geography = new double[]{};
        this.physics = new double[]{};
        this.chemistry = new double[]{};
        this.biology = new double[]{};
        this.science = new double[]{};
        this.philosophy = new double[]{};
        this.physicalEducation = new double[]{};
    }

    public SchoolReport(double[] english, double[] math, double[] history, double[] geography,
                        double[] physics, double[] chemistry, double[] biology, double[] science,
                        double[] philosophy, double[] physicalEducation) {
        this.english = validateNotes(english);
        this.math = validateNotes(math);
        this.history = validateNotes(history);
        this.geography = validateNotes(geography);
        this.physics = validateNotes(physics);
        this.chemistry = validateNotes(chemistry);
        this.biology = validateNotes(biology);
        this.science = validateNotes(science);
        this.philosophy = validateNotes(philosophy);
        this.physicalEducation = validateNotes(physicalEducation);
    }

    private double[] validateNotes (double[] notes) {
        boolean isAllPositive = true;
        boolean isAllValid = true;

        for (int n = 0; n < periods; n++) {
            if (notes[n] < 0)
                isAllPositive = false;
            if (notes[n] > 10)
                isAllValid = false;
        }

        if (isAllPositive && isAllValid && notes.length == periods) {
            return notes;
        } else {
            throw new InvalidParameterException("Uma ou mais notas inseridas são inválidas!");
        }
    }

    public static double[] requestNotes (String schoolSubject) {
        Scanner scan = new Scanner(System.in);
        double[] notes = new double[4];

        for (int n = 1; n <= notes.length; n++) {
            System.out.printf("Insira a %dª nota da disciplina %s: ", n, schoolSubject);
            notes[n] = scan.nextDouble();
        }

        return notes;
    }

    public int getPeriods() {
        return periods;
    }

    public double[] getEnglish() {
        return english;
    }

    public void setEnglish(double[] english) {
        this.english = validateNotes(english);
    }

    public double[] getMath() {
        return math;
    }

    public void setMath(double[] math) {
        this.math = validateNotes(math);
    }

    public double[] getHistory() {
        return history;
    }

    public void setHistory(double[] history) {
        this.history = validateNotes(history);
    }

    public double[] getGeography() {
        return geography;
    }

    public void setGeography(double[] geography) {
        this.geography = validateNotes(geography);
    }

    public double[] getPhysics() {
        return physics;
    }

    public void setPhysics(double[] physics) {
        this.physics = validateNotes(physics);
    }

    public double[] getChemistry() {
        return chemistry;
    }

    public void setChemistry(double[] chemistry) {
        this.chemistry = validateNotes(chemistry);
    }

    public double[] getBiology() {
        return biology;
    }

    public void setBiology(double[] biology) {
        this.biology = validateNotes(biology);
    }

    public double[] getScience() {
        return science;
    }

    public void setScience(double[] science) {
        this.science = validateNotes(science);
    }

    public double[] getPhilosophy() {
        return philosophy;
    }

    public void setPhilosophy(double[] philosophy) {
        this.philosophy = validateNotes(philosophy);
    }

    public double[] getPhysicalEducation() {
        return physicalEducation;
    }

    public void setPhysicalEducation(double[] physicalEducation) {
        this.physicalEducation = validateNotes(physicalEducation);
    }
}
