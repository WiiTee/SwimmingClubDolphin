import lib.persons.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class PersonTest {

    @Test
    void registerPersonTest() {
        var firstName = "First Name";
        var lastName = "Last Name";
        var age = 12;
        var phoneNumber = 123456789;
        var address = "address";
        var mockId = 1;

        var person = new Person(firstName, lastName, age,  phoneNumber, address, mockId);
        person.registerPerson();
    }
    @Test
    void getPersonsTest() {
        var person = new Person();
        var out = person.getPersons();
        var firstEle =  out.getFirst();
        var firstName = firstEle[0];
        System.out.println(firstName);
    }
}