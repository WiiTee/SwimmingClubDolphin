import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class RegistrationOfMember {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Person> member = new ArrayList<>();

        boolean runProgram = true;

        while (runProgram) {
            System.out.println("\nChoose an option:");
            System.out.println("1: Register new member");
            System.out.println("2: Show all members");
            System.out.println("3: Remove a member");
            System.out.println("4: End");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    registerMember(member, sc);
                    break;
                case "2":
                    showMembers(member);
                    break;
                case "3":
                    removeMember(member, sc);
                    break;
                case "4":
                    runProgram = false;
                    System.out.println("The program has ended.");
                    break;
                default:
                    System.out.println("Ugyldigt valg. Try again.");
            }
        }

        sc.close();
    }

    public static void registerMember(ArrayList<Person> member, Scanner sc) {

        System.out.println("Enter your first name: ");
        String firstName = sc.nextLine();

        System.out.println("Enter your last name: ");
        String lastName = sc.nextLine();

        System.out.println("Enter your birthdate (YYYY-MM-DD): ");
        LocalDate birthDate = LocalDate.parse(sc.nextLine());

        System.out.println("Enter your phone number: ");
        String phoneNo = sc.nextLine();

        System.out.println("Enter your address: ");
        String address = sc.nextLine();

        Person members = new Person(firstName, lastName, birthDate, phoneNo, address);
        member.add(members);

        System.out.println("Member registrered with ID: " + members.getId());
    }

    public static void showMembers(ArrayList<Person> member) {
        if (member.isEmpty()) {
            System.out.println("No registered members yet.");
        } else {
            System.out.println("\nRegistered members:");
            for (Person members : member) {
                System.out.println(members);
            }
        }
    }

    public static void removeMember(ArrayList<Person> member, Scanner sc) {
        System.out.println("Enter the ID of the member to remove:");
        int removeID = Integer.parseInt(sc.nextLine());
        boolean removed = false;

        for (int i = 0; i < member.size(); i++) {
            if (member.get(i).getId() == removeID) {
                member.remove(i);
                System.out.println("Member with ID " + removeID + " has been removed.");
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("No member found with that ID.");
        }
    }
}