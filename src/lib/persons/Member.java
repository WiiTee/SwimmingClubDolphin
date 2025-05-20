package lib.persons;

import lib.competitive.Competition;
import lib.competitive.Team;
import lib.competitive.Training;
import lib.membership.Payment;

import java.time.LocalDate;
import java.util.ArrayList;

public class Member extends Person {
    public enum MembershipType{
        MOTIONIST,
        KONKURRENCE
    }
    private MembershipType membership;
    private String address;
    private LocalDate age;
    private Payment payment;
    private ArrayList<String> disciplines;
    private boolean isActive;
    private ArrayList<Training> trainingPerformance;
    private ArrayList<Competition> competitionPerformance;

    public Member(String firstName, String lastName, int phoneNumber, MembershipType membership, String address, LocalDate age){
        super(firstName, lastName, phoneNumber);
        super.constructID(firstName, lastName);
        this.membership = membership;
        this.address = address;
        this.age = age;
        this.payment = new Payment(LocalDate.now(), age, getId());
    }

    public Member(String firstName, String lastName, int phoneNumber, MembershipType membership, Team team,  String address, LocalDate age, Payment payment, ArrayList<String> disciplines, ArrayList<String> competitionPerformance) {
        super(firstName, lastName, phoneNumber);
        super.constructID(firstName, lastName);
        this.membership = membership;
        this.address = address;
        this.age = age;
        this.payment = payment;
        this.disciplines = disciplines;
        this.competitionPerformance = competitionPerformance;
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

    public MembershipType getMembership() {
        return membership;
    }

    public boolean getIsActive(){
        return isActive;
    }

    public ArrayList<Training> getTrainingPerformance(){
        return trainingPerformance;
    }

    public ArrayList<Competition> getCompetitionPerformance() { return competitionPerformance}

    public void setDisciplines(ArrayList<String> disciplines) {
        this.disciplines = disciplines;
    }
}