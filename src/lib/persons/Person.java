package lib.persons;

import java.util.Random;
import java.util.UUID;

public class Person {
    public enum AccessLevel{
        MEMBER,
        TRAINER,
        ACCOUNTANT,
        ADMIN
    }

    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String id;

    public Person(String firstName, String lastName, int phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.id = constructID(firstName, lastName);
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String constructID(String firstName, String lastName){
        String subFirst = firstName.substring(0, 2);
        String subLast = lastName.substring(0, 2);

        Random ran = new Random();
        int conInt = ran.nextInt(1000, 9999);
        String convertInt = String.valueOf(conInt);

        String constructedID;

        return constructedID = subFirst + subLast + convertInt;
    }

    public String constructAccessID(){
        String constructID;
        return constructID = UUID.randomUUID().toString();
    }
}
