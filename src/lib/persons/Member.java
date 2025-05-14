package lib.persons;

import lib.compswim.Team;
import lib.membership.Membership;
import lib.membership.Payment;

import java.time.LocalDate;
import java.util.ArrayList;

public class Member extends Person {
    private Membership membership;
    private Team team;
    private String address;
    private LocalDate age;
    private Payment payment;
    private ArrayList<String> disciplines;
    //private ArrayList<Training> trainingPerformance;
    //private ArrayList<Competition> competitionPerformance;

    public Member(String firstName, String lastName, int phoneNumber, String newMembership, String address, LocalDate age){
        super(firstName, lastName, phoneNumber);
        super.constructID(firstName, lastName);
        this.membership = new Membership(newMembership);
        this.address = address;
        this.age = age;
        this.payment = new Payment(LocalDate.now(), age);
    }

    public Member(String firstName, String lastName, int phoneNumber, Membership membership, Team team,  String address, LocalDate age, Payment payment, ArrayList<String> disciplines){
        super(firstName, lastName, phoneNumber);
        super.constructID(firstName, lastName);
        this.membership = membership;
        this.team = team;
        this.address = address;
        this.age = age;
        this.payment = payment;
        this.disciplines = disciplines;
    }

    public LocalDate getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public Payment getPayment() {
        return payment;
    }

    public Membership getMembership() {
        return membership;
    }
}