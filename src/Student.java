public class Student {

    private int registry;
    private String name;
    private String bornDate;
    private String email;
    private String address;
    private String phoneNumber;

    public Student(int registry, String name, String bornDate, String email, String address, String phoneNumber) {
        this.registry = registry;
        this.name = name;
        this.bornDate = bornDate;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getRegistry() {
        return registry;
    }

    public void setRegistry(int registry) {
        this.registry = registry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
