package lib.competitive;

import java.time.LocalDate;

public class Competition {
    private String memberID;
    private int competitionTime;
    private String competitionName;
    private LocalDate competitionDate;
    private String discipline;


    //Opretter Competition objekter
    public Competition(int competitionTime, String competitionName, LocalDate competitionDate, String discipline, String memberID){
        this.competitionTime = competitionTime;
        this.memberID = memberID;
        this.competitionName = competitionName;
        this.competitionDate = competitionDate;
        this.discipline = discipline;
    }

    public String getMemberID() {
        return memberID;
    }

    public String getDiscipline() {
        return discipline;
    }

    public LocalDate getCompetitionDate() {
        return competitionDate;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public int getCompetitionTime() {
        return competitionTime;
    }



}
