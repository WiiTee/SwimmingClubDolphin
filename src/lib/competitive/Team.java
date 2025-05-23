package lib.competitive;

import lib.persons.Member;
import lib.persons.Trainer;

import java.util.ArrayList;

public class Team {
    private String teamType;
    private String teamName;
    private ArrayList<Member> swimmers = new ArrayList<>();
    private Trainer trainer;

    public Team(String teamName, String teamType){
        this.teamName = teamName;
        this.teamType = teamType;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamType() {
        return teamType;
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
