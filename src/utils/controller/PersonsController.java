package utils.controller;

import lib.membership.Membership;
import lib.persons.Accountant;
import lib.persons.Member;
import lib.persons.Person;
import lib.persons.Trainer;
import utils.FileHandler;
import utils.containers.ArrayContainer;
import utils.interfaces.IScannerInput;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class PersonsController implements IScannerInput{

    //Indeholder alle metoder der ikke direkte manipulere data i Trainer, Member og Accountant objekter!
    private String stringInput;
    private int intInput;
    public String[] personRecord;
    public String personId;

    public void registerPerson(){
        String answer;
        boolean checkAnswers = true;
        boolean isRunning = true;

        System.out.println("""
                #######################
                # Registrer Person #
                #######################
                """);

        while(isRunning) {
            System.out.println("Indtast fornavn");
            stringInput = stringInput();
            String firstName = stringInput;

            System.out.println("Indtast efternavn");
            stringInput = stringInput();
            String lastName = stringInput;

            System.out.println("Indtast telefon nummer");
            intInput = intInput();
            int phoneNo = intInput;

            System.out.println("Indtast addresse");
            stringInput = stringInput();
            String address = stringInput;

            System.out.println("Indtast alder");
            intInput = intInput();
            int age = intInput;

            //Validering inden den opretter objektet
            while(checkAnswers){
                System.out.println("Er disse oplysninger korrekte? Y/N" + "\n" +
                        "Fornavn: " + firstName + "\n" +
                        "Efternavn: " + lastName + "\n" +
                        "Telefon: " + phoneNo + "\n" +
                        "Addresse: " + address + "\n" +
                        "Alder: " + age);

                answer = stringInput();
                if(answer.equalsIgnoreCase("Y")){

                    isRunning = false;
                    checkAnswers = false;

                    System.out.println("Person tilføjet!");

                    var person = new Person(firstName, lastName, phoneNo, address,age);
                    this.personRecord = person.personRecord;
                    this.personId = person.getId();

                    var fh = new FileHandler();
                    fh.save(this.personRecord,"persons.csv",true);

                } else if (answer.equalsIgnoreCase("N")) {
                    System.out.println("Prøv igen!");
                    checkAnswers = false;
                } else {
                    System.out.println("Error: Skriv Y eller N");
                }
            }
        }
    }

    public void registerMember(){
        String answer;
        boolean checkAnswers = true;
        boolean isRunning = true;

        System.out.println("""
                #######################
                # Registrer Medlem #
                #######################
                """);

        while(isRunning) {

            System.out.println("Har medlem betalt\nJa - skriv 1\nNej - skriv 2");
            stringInput = stringInput();
            String hasPaid = stringInput;

            var fh = new FileHandler();
            var dataRecord = new String[]{this.personId,hasPaid};
            fh.save(dataRecord,"payments.csv",true);


            System.out.println("Hvilket hold skal medlem være en del af?\nHold 1 - skriv 1\nHold 2 - skriv 2\nHold 3 - skriv 3\nHold 4 - skriv 4");
            stringInput = stringInput();
            String teamName = stringInput;

            System.out.println("Er medlem motionist eller konkurrencesvømmer?\nMotionist - skriv 1\nKonkurrencesvømmer - skriv 2");
            stringInput = stringInput();
            String membershipType = stringInput;

            dataRecord = new String[]{this.personId,teamName};
            fh.save(dataRecord,"members.csv",true);

            if(Objects.equals(membershipType, "1")){
                System.out.println("Medlem registreret og tilføjet til: Hold " + teamName);
                return;
            }

            System.out.println("Hvilken disciplin deltager medlem i?\nButterfly - skriv 1\nCrawl - skriv 2\nRygcrawl - skriv 3\nBrystsvømmning - skriv 4");
            stringInput = stringInput();
            String discipline = stringInput;


            //Validering inden den opretter objektet
            while(checkAnswers){
                System.out.println("Er disse oplysninger korrekte? Y/N" + "\n" +
                        "Holdnavn: Hold "+ teamName + "\n" +
                        "Disciplin: "+ discipline);

                answer = stringInput();
                if(answer.equalsIgnoreCase("Y")){
                    System.out.println("Medlem registreret og tilføjet til: Hold " + teamName);
                    dataRecord = new String[]{this.personId,teamName,discipline};
                    fh.save(dataRecord,"competition.csv",true);

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

    public void registerTrainer(){
        String answer;
        boolean checkAnswers = true;
        boolean isRunning = true;

        System.out.println("""
                #######################
                # Registrer Træner #
                #######################
                """);

        while(isRunning) {
            System.out.println("Hvilket hold skal træner være en del af?\nHold 1 - skriv 1\nHold 2 - skriv 2\nHold 3 - skriv 3\nHold 4 - skriv 4");
            stringInput = stringInput();
            String teamName = stringInput;

            //Validering inden den opretter objektet
            while(checkAnswers){
                System.out.println("Er disse oplysninger korrekte? Y/N" + "\n" +
                        "Holdnavn: Hold " + teamName );

                answer = stringInput();
                if(answer.equalsIgnoreCase("Y")){

                    var dataRecord = new String[]{personId,teamName};
                    var fh = new FileHandler();
                    fh.save(dataRecord,"trainers.csv",true);

                    System.out.println("Træner tilføjet!");
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
