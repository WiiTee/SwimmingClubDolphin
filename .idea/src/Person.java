public class Person {
    private static int næsteID = 1;
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNo;
    private String address;

    public Person(String firstName, String lastName, int age, String phoneNo, String address) {
        this.id = næsteID++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNo = phoneNo;
        this.address = address;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", First Name: " + firstName + ", Last Name: " + lastName + ", Age: " + age + ", Phone Number: " + phoneNo + ", Address: " + address;
    }

    public int getId() {
        return id;
    }
}