package lib.persons;

public class Accountant extends Person{
    private String accountantID;
    private String AccessLevel;

    public Accountant(String firstName, String lastName, int phoneNumber){
        super(firstName, lastName, phoneNumber);
        super.constructID(firstName, lastName);
        this.accountantID = super.constructAccessID();
    }
}
