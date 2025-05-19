package lib.compswim;

import lib.persons.Member;
import lib.persons.Trainer;

import java.util.ArrayList;

public class Team {
    private String teamID;
    private String teamName;
    private ArrayList<Member> swimmers;
    private Trainer trainer;

    public Team(String teamName, Trainer trainer) {
        this.teamName = teamName;
        this.trainer = trainer;
        this.swimmers = new ArrayList<>();
        this.teamID = constructTeamID();
    }

    public String constructTeamID() {
        return "a";
    }

    public void addSwimmer(Member member) {
        swimmers.add(member);
    }

    public ArrayList<Member> getSwimmers() {
        return swimmers;
    }

    public String getTeamID() {
        return teamID;
    }

    public String getTeamName() {
        return teamName;
    }
}
