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
    //Container klasse så vi kan gemme og load information.
    //Container klassen skal sendes med som argument i alle menuer og gemmes som en variabel
    private ArrayList<Member> memberList = new ArrayList<>();
    private ArrayList<Accountant> accountantList = new ArrayList<>();
    private ArrayList<Trainer> trainerList = new ArrayList<>();

    private ArrayList<Payment> paymentsList = new ArrayList<>();

    private ArrayList<Team> teamList = new ArrayList<>();
    private ArrayList<Competition> competitionList = new ArrayList<>();
    private ArrayList<Training> trainingList = new ArrayList<>();

    public ArrayList<Team> getTeamList(){
        return teamList;
    }

    public ArrayList<Accountant> getAccountantList() {
        return accountantList;
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public ArrayList<Trainer> getTrainerList() {
        return trainerList;
    }

    public ArrayList<Competition> getCompetitionList() {
        return competitionList;
    }

    public ArrayList<Payment> getPaymentsList() {
        return paymentsList;
    }

    public ArrayList<Training> getTrainingList() {
        return trainingList;
    }
}
