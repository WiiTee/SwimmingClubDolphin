package lib.persons;

import java.util.ArrayList;
import utils.FileHandler;

/**
 * TODO: Implement data validation!
 */
public class Person {
    String firstName;
    String lastName;
    int age;
    int phoneNumber;
    String address;
    int id;
    String[] personRecord;

    public Person() {
    }

    public Person(String firstName, String lastName, int age, int phoneNumber, String address, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    private void populatePersonRecord() {
        this.personRecord = new String[]{
                this.firstName
                , this.lastName
                , String.valueOf(this.age)
                , String.valueOf(this.phoneNumber)
                , this.address
                , String.valueOf(this.id)};

    }

    public void registerPerson() {
        var fh = new FileHandler();
        var recordContainer = new ArrayList<String[]>();
        this.populatePersonRecord();
        recordContainer.add(personRecord);
        fh.save(recordContainer, "persons.csv");
    }

    public ArrayList<String[]> getPersons() {
        var fh = new FileHandler();
        return fh.load("persons.csv");
    }
}
