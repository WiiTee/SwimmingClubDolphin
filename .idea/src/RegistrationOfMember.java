import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class RegistrationOfMember {
    Scanner sc = new Scanner(System.in);
    ArrayList<Person> members = new ArrayList<>();

    public void run() {
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
                    registerMember();
                    break;
                case "2":
                    showMembers();
                    break;
                case "3":
                    removeMember();
                    break;
                case "4":
                    runProgram = false;
                    System.out.println("The program has ended.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        sc.close();
    }

    public void registerMember() {
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

        Person newMember = new Person(firstName, lastName, birthDate, phoneNo, address);
        members.add(newMember);

        System.out.println("Member registered with ID: " + newMember.getId());
    }

    public void showMembers() {
        if (members.isEmpty()) {
            System.out.println("No registered members yet.");
        } else {
            System.out.println("\nRegistered members:");
            for (Person m : members) {
                System.out.println(m);
            }
        }
    }

    public void removeMember() {
        System.out.println("Enter the ID of the member to remove:");
        int removeID = Integer.parseInt(sc.nextLine());
        boolean removed = false;

        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId() == removeID) {
                members.remove(i);
                System.out.println("Member with ID " + removeID + " has been removed.");
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("No member found with that ID.");
        }
    }

    public static void main(String[] args) {
        RegistrationOfMember program = new RegistrationOfMember();
        program.run();
    }
}


