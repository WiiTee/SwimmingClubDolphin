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

    public void setId(String id) {
        this.id = id;
    }

    public String constructID(String firstName, String lastName){
        String subFirst = firstName.substring(0, 2);
        String subLast = lastName.substring(0, 2);

        Random ran = new Random();
        int conInt = ran.nextInt(1000, 9999);
        String convertInt = String.valueOf(conInt);

        return subFirst + subLast + convertInt;
    }

    public String constructAccessID(){
        return UUID.randomUUID().toString();
    }
}
