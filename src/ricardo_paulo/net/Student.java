package ricardo_paulo.net;

import java.security.InvalidParameterException;

public class Student {

    private final long registry;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private double[] notes;

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
        if (email.contains("@") && email.contains(".")) {
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


//        if () {
//            this.notes = notes;
//        }
    }
}
