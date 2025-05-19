import cli.PerformanceHandler;
import lib.compswim.Team;
import lib.persons.Member;
import lib.persons.Trainer;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Member member1 = new Member("Jens", "Gotfredsen", 12345678, "Motionist", "Test Addresse", LocalDate.of(1987, 11, 14));
        Trainer trainer = new Trainer("Peter", "Larsen", 12345678);

        System.out.println("Payment Selection based on Age: " +  member.getPayment().getPaymentAmount() + "\n" +
                           "ID: " + member.getId() + "\n" +
                           "TrainerID: " + trainer.getTrainerID());

        //Opretter af medlem.
        ArrayList<Member> members = new ArrayList<>();
        members.add(member1);

        //Opretter to hold.
        Team seniorTeam = new Team("Senior", trainer);
        Team juniorTeam = new Team("Junior", trainer);

        //Fordeler hold baseret på alder.
        PerformanceHandler performanceHandler = new PerformanceHandler(seniorTeam, juniorTeam);
        performanceHandler.divideCompetitionByAge(members);

        //Registrerer konkurrencesvømmer.
        performanceHandler.registerCompetition(member1,"butterfly", LocalDate.of(2025,5,10),1,"00:54:07");

    }
}