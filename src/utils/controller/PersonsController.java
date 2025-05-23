package utils.controller;

import lib.membership.Membership;
import lib.membership.Payment;
import lib.persons.Accountant;
import lib.persons.Member;
import utils.interfaces.IScannerInput;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class PersonsController implements IScannerInput{

    //Indeholder alle metoder der ikke direkte manipulere data i Trainer, Member og Accountant objekter!
    private String stringInput;
    private int intInput;

    public void registerMember(){
        String answer;
        boolean checkAnswers = true;
        boolean isRunning = true;

    public void registerMember(ArrayList<Member> members) {
        System.out.println("Enter your first name: ");
        stringInput = stringInput();
        String firstName = stringInput;

        System.out.println("Enter your last name: ");
        stringInput = stringInput();
        String lastName = stringInput;

        System.out.println("Enter your birthdate (YYYY-MM-DD): ");
        stringInput = stringInput();
        LocalDate age = LocalDate.parse(stringInput);

        System.out.println("Enter your phone number: ");
        intInput = intInput();
        int phoneNumber = intInput;

        System.out.println("Enter your address: ");
        stringInput = stringInput();
        String address = stringInput;

        Membership.MembershipType membershipType = null;
        while (membershipType == null) {
            System.out.println("Enter membership type ('motionist' or 'konkurrence'): ");
            stringInput = stringInput();
            String input = stringInput.trim().toLowerCase();

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

        Member newMember = new Member(firstName, lastName, phoneNumber, address, age);
        Membership newMembership = new Membership(membershipType, newMember.getId());
        Payment newPayment = new Payment(LocalDate.now(), newMember.getId());

        newMember.setMembership(newMembership);
        newMember.setPayment(newPayment);
        newMember.getPayment().setPaymentAmount(newMember);

        members.add(newMember);

        System.out.println("Member registered with ID: " + newMember.getId());
        System.out.println("Payment amount: " + newMember.getPayment().getPaymentAmount());
        System.out.println("Membership type: " + newMember.getMembership().getMembershipType().getType());
    }

    @Override
    public String stringInput(){
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextLine();

        } catch (Exception e) {
            return "Error: No input was found! " + e;
        }
    }

    @Override
    public int intInput(){
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextInt();

        } catch (Exception e) {
            System.out.println("Error: Not an int input! " + e);
            return -1;
        }
    }
}
