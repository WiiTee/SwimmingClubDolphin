package lib.competitive;

import java.time.LocalDate;

public class Competition {
    private String lapTime;
    private LocalDate lapDate;
    private String competitionName;
    private LocalDate competitionDate;

    public Competition(String lapTime, LocalDate lapDate, String competitionName, LocalDate competitionDate){
        this.lapTime = lapTime;
        this.lapDate = lapDate;
        this.competitionName = competitionName;
        this.competitionDate = competitionDate;
    }
}
