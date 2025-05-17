import java.time.LocalDate;
import java.time.Period;

public class Person {
    private static int næsteID = 1;
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String phoneNo;
    private String address;

    public Person(String firstName, String lastName, LocalDate birthDate, String phoneNo, String address) {
        this.id = næsteID++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phoneNo = phoneNo;
        this.address = address;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", First Name: " + firstName + ", Last Name: " + lastName + ", Age: " + getAge() + ", Phone Number: " + phoneNo + ", Address: " + address;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}