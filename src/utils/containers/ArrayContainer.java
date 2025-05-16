package utils.containers;

import lib.competitive.Competition;
import lib.competitive.Team;
import lib.competitive.Training;
import lib.membership.Payment;
import lib.persons.Accountant;
import lib.persons.Member;
import lib.persons.Trainer;

import java.util.ArrayList;

public class ArrayContainer {
    private ArrayList<Member> memberList = new ArrayList<>();
    private ArrayList<Accountant> accountantList = new ArrayList<>();
    private ArrayList<Trainer> trainerList = new ArrayList<>();

    private ArrayList<Payment> paymentsList = new ArrayList<>();

    private ArrayList<Team> teamList = new ArrayList<>();
    private ArrayList<Competition> competitionList = new ArrayList<>();
    private ArrayList<Training> trainingList = new ArrayList<>();

    public ArrayList<Team> getTeamList() {
        return teamList;
    }

    public ArrayList<Accountant> getAccountantList() {
        return accountantList;
    }
}
