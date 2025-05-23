package lib.competitive;

import java.time.LocalDate;

public class Training implements Comparable<Training>{
    private String memberID;
    private int lapTime;
    private LocalDate lapDate;
    private String discipline;

    //Opretter træning objekter
    public Training(String memberID, int lapTime, LocalDate lapDate, String discipline){
        this.memberID = memberID;
        this.lapTime = lapTime;
        this.lapDate = lapDate;
        this.discipline = discipline;
    }

    public int getLapTime() {
        return lapTime;
    }

    public LocalDate getLapDate() {
        return lapDate;
    }

    public String getMemberID() {
        return memberID;
    }

    public String getDiscipline() {
        return discipline;
    }

    @Override
    public int compareTo(Training o) {
        return Integer.compare(this.lapTime, o.lapTime);
    }
}
