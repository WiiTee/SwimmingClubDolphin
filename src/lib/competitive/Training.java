package lib.competitive;

import java.time.LocalDate;

public class Training implements Comparable<Training>{
    private String memberID;
    private int lapTime;
    private LocalDate lapDate;

    //Opretter træning objekter
    public Training(String memberID, int lapTime, LocalDate lapDate){
        this.memberID = memberID;
        this.lapTime = lapTime;
        this.lapDate = lapDate;
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

    @Override
    public int compareTo(Training o) {
        return Integer.compare(this.lapTime, o.lapTime);
    }
}
