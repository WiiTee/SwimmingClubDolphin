package lib.CompetitiveSwimming;

import lib.persons.Member;
import lib.persons.Trainer;

import java.util.ArrayList;

public class Team {
    private String teamID;
    private String teamName;
    private ArrayList<Member> swimmers;
    private Trainer trainer;

    public Team(String teamName, Trainer trainer){
        this.teamName = teamName;
        this.trainer = trainer;
        this.teamID = constructTeamID();
    }

    public String constructTeamID(){
        return "a";
    }
}
