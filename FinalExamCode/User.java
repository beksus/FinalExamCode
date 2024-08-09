package FinalExamCode;

public class User {
    private String name;
    private String email;
    private String password;
    private String contactNumber;

    public User(String name, String email, String password, String contactNumber) {
        setName(name);
        setEmail(email);
        setPassword(password);
        setContactNumber(contactNumber);
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

}
