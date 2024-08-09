package FinalExamCode;

public class Organizer extends User{
    private int crn;

    public Organizer(String name, String email, String password, String contactNumber) {
        super(name, email, password, contactNumber);
    }


    public void setCrn(int crn) {
        this.crn = crn;
    }
    public int getCrn() {
        return crn;
    }

}
