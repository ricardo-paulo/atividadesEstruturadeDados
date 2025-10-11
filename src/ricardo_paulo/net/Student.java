package ricardo_paulo.net;

import java.security.InvalidParameterException;

public class Student {

    private final long registry;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private double[] notes;

    public Student() {
        this.registry = -1;
        this.name = "";
        this.address = "";
        email = "";
        phoneNumber = "";
        this.notes = new double[]{};
    }

    public Student(long registry, String name, String address, String email, String phoneNumber, double[] notes) {
        this.registry = registry;
        this.name = name;
        this.address = address;
        setEmail(email);
        setPhoneNumber(phoneNumber);
        this.notes = notes;
    }

    public long getRegistry() {
        return registry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        boolean containsAt = false;
        boolean containsPoint = false;

        for (int c = 0; c < email.length(); c++) {
            if (email.charAt(c) == '@')
                containsAt = true;

            if (email.charAt(c) == '.')
                containsPoint = true;
        }

        if (containsAt && containsPoint) {
            this.email = email;
        } else {
            throw new InvalidParameterException("Insira um endereço de email válido!");
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() == 11) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new InvalidParameterException("Insira um número de telefone válido!");
        }
    }

    public double[] getNotes() {
        return notes;
    }

    public void setNotes(double[] notes) {

        boolean isAllPositive = true;

        for (int n = 0; n < notes.length; n++) {
            if (notes[n] < 0)
                isAllPositive = false;
        }

        if (isAllPositive) {
            this.notes = notes;
        } else {
            throw new InvalidParameterException("Uma ou mais notas inseridas são inválidas!");
        }

    }
}
