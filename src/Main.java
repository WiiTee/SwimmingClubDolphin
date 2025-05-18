import cli.main.MainViewer;
import lib.competitive.Team;
import lib.persons.Member;
import lib.persons.Trainer;
import utils.controller.CompetitiveController;

import java.time.LocalDate;
import java.util.ArrayList;

import static lib.persons.Member.MembershipType.*;

public class Main {
    public static void main(String[] args) {
        MainViewer mainViewer = new MainViewer();
        CompetitiveController cc = new CompetitiveController();
        Member member = new Member("Jens", "Gotfredsen", 12345678, MOTIONIST, "Test Addresse", LocalDate.of(1987, 11, 14));
        Trainer trainer = new Trainer("Peter", "Larsen", 12345678);
        Team team = new Team("Hold A");

        System.out.println("Payment Selection based on Age: " +  member.getPayment().getPaymentAmount() + "\n" +
                           "ID: " + member.getId() + "\n" +
                           "TrainerID: " + trainer.getTrainerID());

        ArrayList<Trainer> trainerArrayList = new ArrayList<>();
        //ArrayList<Team> teamArrayList = new ArrayList<>();
        trainerArrayList.add(trainer);
        //teamArrayList.add(team);

        //ch.addTrainer(trainerArrayList, teamArrayList);
    }
}