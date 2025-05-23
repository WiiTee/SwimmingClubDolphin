package utils.controller;

import lib.membership.Membership;
import lib.membership.Payment;
import lib.persons.Accountant;
import lib.persons.Member;
import lib.persons.Trainer;
import utils.interfaces.IScannerInput;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class PersonsController implements IScannerInput{

    //Indeholder alle metoder der ikke direkte manipulere data i Trainer, Member og Accountant objekter!
    private String stringInput;
    private int intInput;

    //Registrerer en bogholder
    public void registerAccountant(ArrayList<Accountant> arrayList){
        String answer;
        boolean checkAnswers = true;
        boolean isRunning = true;

        System.out.println("""
                #######################
                # Registrer Bogholder #
                #######################
                """);

        while(isRunning) {
            System.out.println("Indtast fornavn: ");
            stringInput = stringInput();
            String firstName = stringInput;

            System.out.println("Indtast efternavn");
            stringInput = stringInput();
            String lastName = stringInput;

            System.out.println("Indtast telefon nummer");
            intInput = intInput();
            int phoneNo = intInput;

            //Validering inden den opretter objektet
            while(checkAnswers) {
                System.out.println("Er disse oplysninger korrekte? Y/N" + "\n" +
                            "Fornavn: " + firstName + "\n" +
                            "Efternavn: " + lastName + "\n" +
                            "Telefon: " + phoneNo);

                answer = stringInput();
                if (answer.equalsIgnoreCase("Y")) {
                    Accountant accountant = new Accountant(firstName, lastName, phoneNo);
                    arrayList.add(accountant);
                    System.out.println("Bogholder tilføjet!");
                    isRunning = false;
                    checkAnswers = false;
                } else if (answer.equalsIgnoreCase("N")) {
                    System.out.println("Prøv igen!");
                    checkAnswers = false;
                } else {
                    System.out.println("Error: Skriv Y eller N");
                }
            }
        }
    }

    public void registerTrainer(ArrayList<Trainer> trainers){
        boolean isRegistering = true;
        boolean checkingAnswers = true;
        String firstName = "";
        String lastName = "";
        int phoneNo = 0;
        while(isRegistering) {
            System.out.println("Indtast fornavn: ");
            stringInput = stringInput();
            firstName = stringInput;
            System.out.println("Indtast efternavn");
            stringInput = stringInput();
            lastName = stringInput;
            System.out.println("Indtast telefon nummer");
            intInput = intInput();
            phoneNo = intInput;

            while(checkingAnswers) {
            System.out.println("Er disse oplysninger korrekte brug Y/N: " + "\n" +
                               "Navn: " + firstName + "\n" +
                               "Efternavn: " + lastName + "\n" +
                               "Telefon: " + phoneNo);

                stringInput = stringInput();
                String checkAnswer = stringInput;
                if(checkAnswer.equalsIgnoreCase("Y")){
                    checkingAnswers = false;
                } else if(checkAnswer.equalsIgnoreCase("N")){
                    System.out.println("Starter registreringen forfra!");
                    checkingAnswers = false;
                } else {
                    System.out.println("Error: Skriv Y eller N");
                }
            }
            isRegistering = false;
        }
        Trainer trainer = new Trainer(firstName, lastName, phoneNo);
        trainers.add(trainer);
    }

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
