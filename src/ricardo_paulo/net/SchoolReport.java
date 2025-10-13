package ricardo_paulo.net;

import java.security.InvalidParameterException;

public class SchoolReport {

    private final int periods = 4;
    private String[] disciplines;
    private double[][] notes;

    public SchoolReport() {
        this.disciplines = new String[1];
        this.notes = new double[][] {{-1, -1, -1, -1}};
    }

    public SchoolReport(String[] disciplines, double[][] notes) {
        this.disciplines = disciplines;
        this.notes = validateNotes(notes);

    }

    private double[][] validateNotes(double[][] notes) {
        boolean isAllPositive = true;
        boolean isAllValid = true;

        for (double[] disNotes : notes) {
            for (int n = 0; n < periods; n++) {
                if (disNotes[n] < 0)
                    isAllPositive = false;
                if (disNotes[n] > 10)
                    isAllValid = false;
            }
        }

        if (isAllPositive && isAllValid && notes.length == periods) {
            return notes;
        } else {
            throw new InvalidParameterException("Uma ou mais notas inseridas são inválidas!");
        }
    }

    public int getPeriods() {
        return periods;
    }

    public String[] getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(String[] disciplines) {
        this.disciplines = disciplines;
    }

    public double[][] getNotes() {
        return notes;
    }

    public void setNotes(double[][] notes) {
        this.notes = validateNotes(notes);
    }

    public void addNoteSet(String discipline, double[] notes) {
        if (disciplines[0] != null) {
            String[] temp = disciplines.clone();
            disciplines = new String[temp.length + 1];
            for (int d = 0; d < temp.length; d++) {
                disciplines[d] = temp[d];
            }
        }

        if (this.notes[0][0] != -1) {
            double[][] temp = this.notes.clone();
            this.notes = new double[temp.length + 1][periods];
            for (int obj = 0; obj < temp.length; obj++) {
                this.notes[obj] = temp[obj];
            }
        }

        disciplines[disciplines.length - 1] = discipline;
        this.notes[this.notes.length - 1] = notes;
    }

    public void showSchoolReport() {
        System.out.println("Notas:");
        for (int j = 0; j < disciplines.length; j++) {
            System.out.printf("""
                        %s: %.2f, %.2f, %.2f, %.2f
                    
                    """, disciplines[j], notes[j][0], notes[j][1], notes[j][2], notes[j][3]);
        }
    }

    // Arthur Borges:
    public double[] getNotes(String discipline) {
        return null;
    }

    public void updateNotes(String discipline, double[] novaNota) {

    }
}