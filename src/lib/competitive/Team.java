package lib.competitive;

import lib.persons.Member;
import lib.persons.Trainer;

import java.util.ArrayList;

public class Team {
    private String teamID;
    private String teamName;
    private ArrayList<Member> swimmers;
    private Trainer trainer;

    public Team(String teamName){
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamID() {
        return teamID;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public ArrayList<Member> getSwimmers() {
        return swimmers;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public void setSwimmers(Member member) {
        swimmers.add(member);
    }
}
