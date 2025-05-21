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

    public Member(String firstName, String lastName, int phoneNumber, Membership membership, String address, LocalDate age) {
        super(firstName, lastName, phoneNumber);
        super.constructID(firstName, lastName);
        this.membership = membership;
        this.address = address;
        this.age = age;
        this.payment = new Payment(LocalDate.now(), age, getId());
    }


    public Member(String firstName, String lastName, int phoneNumber, Membership membership, Team team, String address, LocalDate age, Payment payment, ArrayList<String> disciplines) {
        super(firstName, lastName, phoneNumber);
        super.constructID(firstName, lastName);
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

    public ArrayList<Training> getTrainingPerformance() {
        return trainingPerformance;
    }

    public void setDisciplines(ArrayList<String> disciplines) {
        this.disciplines = disciplines;
    }


    public ArrayList<Competition> getCompetitionPerformance() {
        return competitionPerformance;
    }
}