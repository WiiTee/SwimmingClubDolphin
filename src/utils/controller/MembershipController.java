package utils.controller;

import lib.persons.Member;
import utils.interfaces.IScannerInput;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MembershipController implements IScannerInput {

    //Indeholder alle metoder der ikke direkte manipulere data i Payment of Membership objekter
    private int intInput;
    private String stringInput;

    // ####################
    // Handles payment part
    // ####################

    //Opdaterer betaling for et medlem
    public void updateLastPaid(ArrayList<Member> arrList){
        for(Member list : arrList){
            System.out.println("Navn: " + list.getFirstName() + " " + list.getLastName() + "\n" +
                               "Telefon: " + list.getPhoneNumber() + "\n" +
                               "MedlemID: " + list.getId() + "\n" +
                               "-----------------------------");
        }
        System.out.println("Indtast MedlemID fra listen");
        stringInput = stringInput();
        for(Member list : arrList) {
            if (stringInput.equals(list.getId())){
                list.getPayment().setLastPayment(LocalDate.now());
                list.getPayment().setHasPaid();

                System.out.println("Medlem har betalt til ved dags dato!");
                break;
            }
        }
    }

    //Checker alle medlemmer igennem og printer dem i restance!
    public void checkDebt(ArrayList<Member> arrList){
        for(Member list : arrList){
            if(!list.getPayment().getHasPaid()){
                System.out.println("Medlem ID; " + list.getId() +
                                   ", Navn; " + list.getFirstName() + " " + list.getLastName() +
                                   ". Er i restance!");
            }
        }
    }

    //Opdatere alle medlemmers betalingssum så den er korrekt i fht. alder
    public void updatePaymentAmount(ArrayList<Member> arrList){
        for(Member list : arrList){
            list.getPayment().setPaymentAmount(list);
        }
        System.out.println("Opdaterede betalingssum for alle medlemmer");
    }

    // #######################
    // Handles membership part
    // #######################

    //Tjekker om et medlem er aktivt (?) Ved ikke hvorfor :).
    public void membershipStatus(Member member){
        if(member.getMembership().getIsActive()){
            System.out.println("Medlem er aktivt");
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
