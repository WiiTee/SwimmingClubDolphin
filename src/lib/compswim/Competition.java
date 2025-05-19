package lib.compswim;

import java.time.LocalDate;

public class Competition {
    private String CompetitionType;
    private LocalDate CompetitionDate;
    private int competitionPlacement;
    private String CompetitionTime;

    public Competition(String CompetitionType, LocalDate CompetitionDate, int competitionPlacement, String CompetitionTime) {
        this.CompetitionType = CompetitionType;
        this.CompetitionDate = CompetitionDate;
        this.competitionPlacement = competitionPlacement;
        this.CompetitionTime = CompetitionTime;
    }

    public String getCompetitionType() {
        return CompetitionType;
    }

    public void setCompetitionType(String CompetitionType) {
        this.CompetitionType = CompetitionType;
    }

    public LocalDate getCompetitionDate() {
        return CompetitionDate;
    }

    public void setCompetitionDate(LocalDate CompetitionDate) {
        this.CompetitionDate = CompetitionDate;
    }

    public int getCompetitionPlacement() {
        return competitionPlacement;
    }

    public void setCompetitionPlacement(int competitionPlacement) {
        this.competitionPlacement = competitionPlacement;
    }

    public String getCompetitionTime() {
        return CompetitionTime;
    }

    public void setCompetitionTime(String CompetitionTime) {
        this.CompetitionTime = CompetitionTime;
    }
    

}
