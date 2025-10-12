package ricardo_paulo.net;

import java.security.InvalidParameterException;

public class Student {

    private final long registry;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private SchoolReport schoolReport;

    public Student() {
        this.registry = -1;
        this.name = "";
        this.address = "";
        this.email = "";
        this.phoneNumber = "";
        this.schoolReport = new SchoolReport();
    }

    public Student(long registry, String name, String address, String email, String phoneNumber) {
        this.registry = registry;
        this.name = name;
        this.address = address;
        setEmail(email);
        setPhoneNumber(phoneNumber);
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

    public SchoolReport getSchoolReport() {
        return schoolReport;
    }

    public void setSchoolReport(SchoolReport report) {
        this.schoolReport = report;
    }
}
