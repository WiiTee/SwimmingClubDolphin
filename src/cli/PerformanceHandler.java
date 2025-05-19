package cli;

import java.time.LocalDate;
import java.util.ArrayList;

import lib.compswim.Competition;
import lib.compswim.Team;
import lib.persons.Member;
import utils.input.ScannerInput;


public class PerformanceHandler {
    private Team seniorTeam;
    private Team juniorTeam;

    public PerformanceHandler(Team seniorTeam, Team juniorTeam) {
        this.seniorTeam = seniorTeam;
        this.juniorTeam = juniorTeam;
    }

    public void divideCompetitionByAge(ArrayList<Member> members) {
        for (Member member : members) {
            LocalDate birthDate = member.getAge();
            if (birthDate == null) {
                System.out.println("You have not specified the age of this member: " + member.getId());
            } else if (birthDate.plusYears(18).isAfter(LocalDate.now())) {
                juniorTeam.addSwimmer(member);
            } else {
                seniorTeam.addSwimmer(member);
            }
        }
    }

    public Team getSeniorTeam() {
        return seniorTeam;
    }

    public Team getJuniorTeam() {
        return juniorTeam;
    }

    //Registrering af medlem uden scanner.
   public void registerCompetition(Member member, String competitionType, LocalDate competitionDate, int competitionPlacement, String competitionTime) {
       Competition competition = new Competition(competitionType, competitionDate, competitionPlacement, competitionTime);
       member.getCompetitionPerformance().add(competition);
       System.out.println("Competition added: " + member.getId());
   }

    /* Registreting af medlem med scanner.
    public void registerCompetition(ArrayList<Member> members) {
        ScannerInput input = new ScannerInput();
        System.out.println("Enter member ID: ");
        String memberId = input.stringInput();

        Member selectedMember = null;
        for (Member member : members) {
            if (memberId.equalsIgnoreCase(member.getId())) {
                selectedMember = member;
                break;
            }
        }
        if (selectedMember == null) {
            System.out.println("Member not found");
            return;
        }
        System.out.println("Enter type of competition: ");
        String competitionType = input.stringInput();

        LocalDate competitionDate;
        System.out.println("Enter date of the competition: ");
        while (true) {
            try {
                competitionDate = LocalDate.parse(input.stringInput());
                break;
            } catch (Exception e) {
                System.out.println("Invalid date format");
            }
        }
        System.out.println("Enter your result in the competition: ");
        int competitionPlacement = input.intInput();

        System.out.println("Enter your time in the competition: ");
        String competitionTime = input.stringInput();

        Competition competition = new Competition(competitionType, competitionDate, competitionPlacement, competitionTime);
        selectedMember.getCompetitionPerformance().add(competition);

        System.out.println("Competition added: " + selectedMember.getId());
    }
*/

}


