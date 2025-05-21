package utils.controller;

import lib.persons.Accountant;
import lib.persons.Member;
import lib.persons.Trainer;
import utils.FileHandler;
import utils.containers.ArrayContainer;
import utils.interfaces.IScannerInput;

import java.util.ArrayList;
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
            while(checkAnswers){
                System.out.println("Er disse oplysninger korrekte? Y/N" + "\n" +
                        "Fornavn: " + firstName + "\n" +
                        "Efternavn: " + lastName + "\n" +
                        "Telefon: " + phoneNo);

                answer = stringInput();
                if(answer.equalsIgnoreCase("Y")){
                    Accountant accountant = new Accountant(firstName, lastName, phoneNo);
                    arrayList.add(accountant);
                    System.out.println("Bogholder tilføjet!");


                    var dataRecord = new String[]{firstName, lastName, String.valueOf(phoneNo)};
                    var recordContainer = new ArrayList<String[]>();
                    recordContainer.add(dataRecord);
                    var fh = new FileHandler();
                    fh.save(recordContainer,"accountants.csv");

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

    public void registerMember(ArrayList<Member> arrayList){
        String answer;
        boolean checkAnswers = true;
        boolean isRunning = true;

        System.out.println("""
                #######################
                # Registrer Medlem #
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
            while(checkAnswers){
                System.out.println("Er disse oplysninger korrekte? Y/N" + "\n" +
                        "Fornavn: " + firstName + "\n" +
                        "Efternavn: " + lastName + "\n" +
                        "Telefon: " + phoneNo);

                answer = stringInput();
                if(answer.equalsIgnoreCase("Y")){
//                    Member member = new Member(firstName, lastName, phoneNo);
//                    arrayList.add(member);
                    System.out.println("Medlem tilføjet!");


                    var dataRecord = new String[]{firstName, lastName, String.valueOf(phoneNo)};
                    var recordContainer = new ArrayList<String[]>();
                    recordContainer.add(dataRecord);
                    var fh = new FileHandler();
                    fh.save(recordContainer,"members.csv");

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

    public void registerTrainer(ArrayList<Trainer> arrayList){
        String answer;
        boolean checkAnswers = true;
        boolean isRunning = true;

        System.out.println("""
                #######################
                # Registrer Træner #
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
            while(checkAnswers){
                System.out.println("Er disse oplysninger korrekte? Y/N" + "\n" +
                        "Fornavn: " + firstName + "\n" +
                        "Efternavn: " + lastName + "\n" +
                        "Telefon: " + phoneNo);

                answer = stringInput();
                if(answer.equalsIgnoreCase("Y")){
//                    Member member = new Member(firstName, lastName, phoneNo);
//                    arrayList.add(member);
                    System.out.println("Medlem tilføjet!");


                    var dataRecord = new String[]{firstName, lastName, String.valueOf(phoneNo)};
                    var recordContainer = new ArrayList<String[]>();
                    recordContainer.add(dataRecord);
                    var fh = new FileHandler();
                    fh.save(recordContainer,"trainers.csv");

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

    @Override
    public String stringInput(){
        Scanner sc = new Scanner(System.in);
        try {
            stringInput = sc.nextLine();
            return stringInput;

        } catch (Exception e) {
            return "Error: No input was found! " + e;
        }
    }

    @Override
    public int intInput(){
        Scanner sc = new Scanner(System.in);
        try {
            intInput = sc.nextInt();
            return intInput;

        } catch (Exception e) {
            System.out.println("Error: Not an int input! " + e);
            return -1;
        }
    }
}
