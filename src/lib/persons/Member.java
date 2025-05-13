package lib.persons;

import lib.CompetitiveSwimming.Team;
import lib.Membership.Membership;
import lib.Membership.Payment;

import java.time.LocalDate;
import java.util.ArrayList;

public class Member {
    private Membership membership;
    private Team team;
    private String address;
    private LocalDate age;
    private Payment payment;
    private ArrayList<String> disciplines;
    //private ArrayList<Training> trainingPerformance;
    //private ArrayList<Competition> competitionPerformance;

    public Member(Membership membership, String address, LocalDate age, Payment payment){
        this.membership = membership;
        this.address = address;
        this.age = age;
        this.payment = payment;
    }

    public Member(Membership membership, Team team,  String address, LocalDate age, Payment payment, ArrayList<String> disciplines){
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
}