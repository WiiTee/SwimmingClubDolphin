package lib.persons;

import lib.competitive.Competition;
import lib.competitive.Team;
import lib.competitive.Training;
import lib.membership.Payment;
import lib.membership.Membership;
import java.time.LocalDate;
import java.util.ArrayList;

public class Member extends Person {
    private Membership membership;
    private String address;
    private LocalDate age;
    private Payment payment;
    private ArrayList<String> disciplines;
    private ArrayList<Training> trainingPerformance;
    private ArrayList<Competition> competitionPerformance;


    public Member(String firstName, String lastName, int phoneNumber, String address, LocalDate age){
        super(firstName, lastName, phoneNumber);
        super.constructID(firstName, lastName);
        this.address = address;
        this.age = age;
    }

    public Member(String id, String firstName, String lastName, int phoneNumber, String address, LocalDate age){
        super(firstName, lastName, phoneNumber);
        super.setId(id);
        this.membership = membership;
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

    public ArrayList<Training> getTrainingPerformance(){
        return trainingPerformance;
    }

    public ArrayList<Competition> getCompetitionPerformance() { 
        return competitionPerformance;
    }

    public ArrayList<Competition> getCompetitionPerformance() {
        return competitionPerformance;
    }

    public void setDisciplines(ArrayList<String> disciplines) {
        this.disciplines = disciplines;
    }
  
    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}