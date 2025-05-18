package lib.competitive;

import java.time.LocalDate;

public class Competition {
    private String lapTime;
    private LocalDate lapDate;
    private String competitionName;
    private LocalDate competitionDate;

    //Opretter Competition objekter
    public Competition(String lapTime, LocalDate lapDate, String competitionName, LocalDate competitionDate){
        this.lapTime = lapTime;
        this.lapDate = lapDate;
        this.competitionName = competitionName;
        this.competitionDate = competitionDate;
    }

    public LocalDate getCompetitionDate() {
        return competitionDate;
    }

    public LocalDate getLapDate() {
        return lapDate;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public String getLapTime() {
        return lapTime;
    }
}
