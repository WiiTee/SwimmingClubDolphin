package lib.competitive;

import java.time.LocalDate;

public class Competition {
    private String memberID;
    private String competitionTime;
    private String competitionName;
    private LocalDate competitionDate;
    private String discipline;


    //Opretter Competition objekter
    public Competition(String competitionTime, String memberID, String competitionName, LocalDate competitionDate, String discipline){
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

    public String getCompetitionTime() {
        return competitionTime;
    }



}
