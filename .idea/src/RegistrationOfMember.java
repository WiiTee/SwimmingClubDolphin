import lib.persons.Member;
import lib.membership.Membership;
import lib.membership.Payment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class RegistrationOfMember {
    Scanner sc = new Scanner(System.in);
    ArrayList<Member> members = new ArrayList<>();

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
        String phoneNumber = sc.nextLine().trim();

        System.out.println("Enter your address: ");
        String address = sc.nextLine();

        Membership.MembershipType membershipType = null;
        while (membershipType == null) {
            System.out.println("Enter membership type ('motionist' or 'konkurrence'): ");
            String input = sc.nextLine().trim().toLowerCase();

            switch (input) {
                case "motionist":
                    membershipType = Membership.MembershipType.MOTIONIST;
                    break;
                case "konkurrence":
                    membershipType = Membership.MembershipType.KONKURRENCE;
                    break;
                default:
                    System.out.println("Invalid input. Please enter 'motionist' or 'konkurrence'.");
            }
        }

        Member newMember = new Member(firstName, lastName, birthDate, phoneNumber, address, membershipType);
        members.add(newMember);

        System.out.println("Member registered with ID: " + newMember.getId());
        System.out.println("Payment amount: " + newMember.getPayment().getPaymentAmount());
        System.out.println("Membership type: " + newMember.getMembership().getMembershipType());
    }


    public void showMembers() {
        if (members.isEmpty()) {
            System.out.println("No registered members yet.");
        } else {
            System.out.println("\nRegistered members:");
            for (Member m : members) {
                System.out.println("ID: " + m.getId());
                System.out.println("Name: " + m.getFirstName() + " " + m.getLastName());
                System.out.println("Phone: " + m.getPhoneNumber());
                System.out.println("Address: " + m.getAddress());
                System.out.println("Membership: " + m.getMembership().getMembershipType());
                System.out.println("Payment: " + m.getPayment().getPaymentAmount() + " DKK");
                System.out.println("Has Paid: " + m.getPayment().getHasPaid());
                System.out.println("Subscription Date: " + m.getPayment().getSubscriptionDate());
            }
        }
    }

    public void removeMember() {
        System.out.println("Enter the ID of the member to remove:");
        String removeID = sc.nextLine();
        boolean removed = false;

        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId().equals(removeID)) {
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