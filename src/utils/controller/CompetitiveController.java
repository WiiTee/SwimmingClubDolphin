package utils.controller;

import lib.competitive.Competition;
import lib.competitive.Team;
import lib.competitive.Training;
import lib.persons.Member;
import lib.persons.Trainer;
import utils.FileHandler;
import utils.interfaces.IScannerInput;

import utils.containers.ArrayContainer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CompetitiveController implements IScannerInput{
    //Indeholder alle metoder der ikke direkte manipulere data i Competition og Training objekter.
    private String stringInput;

    //Registrer en ny svømmer
    public void addSwimmer(ArrayList<Member> memberList, ArrayList<Team> teamList) {
        ArrayList<String> disciplines = new ArrayList<>();
        boolean isDiscipline = true;

        for (Member member : memberList) {
            System.out.println("Medlemmets navn: " + member.getFirstName() + " " + member.getLastName() + "\n" +
                    "Medlemmets ID: " + member.getId() + "\n" +
                    "----------------------------------------------------");
        }

        System.out.println("Indtast MedlemID");
        stringInput = stringInput();
        String inputID = stringInput;

        for (Member member : memberList) {
            if (inputID.equalsIgnoreCase(member.getId())) {
                String disciplineStr;
                String answer;
                System.out.println("Registrer discipliner");
                while (isDiscipline) {
                    stringInput = stringInput();
                    disciplineStr = stringInput;

                    System.out.println();
                    answer = stringInput();
                    if (answer.equalsIgnoreCase("Y")) {
                        disciplines.add(disciplineStr);
                    } else if (answer.equalsIgnoreCase("N")) {
                        isDiscipline = false;
                    } else {
                        System.out.println("Error: Brug Y eller N");
                    }
                }

                member.setDisciplines(disciplines);
                divideCompetitionByAge(memberList, teamList);

                System.out.println("Registrer hold");
                for (Team team : teamList) {
                    System.out.println("Holdnavn: " + team.getTeamName() + " Team ID: " + team.getTeamID());
                }
                System.out.println("Indtast Hold navn");
                stringInput = stringInput();
                for (Team team : teamList) {
                    if (stringInput.equals(team.getTeamName())) {
                        team.setSwimmers(member);
                    }
                }
            }
        }
    }

    //Indeler member i seniorhold eller juniorhold.
    public void divideCompetitionByAge(ArrayList<Member> members, ArrayList<Team> teamList) {
        Team juniorTeam = null;
        Team seniorTeam = null;

        for (Team team : teamList) {
            if (team.getTeamName().equalsIgnoreCase("Juniorhold")) {
                juniorTeam = team;
            } else if (team.getTeamName().equalsIgnoreCase("Seniorhold")) {
                seniorTeam = team;
            }
        }

        if (juniorTeam == null || seniorTeam == null) {
            System.out.println("Fejl: Junior- eller Seniorhold ikke fundet i teamList.");
            return;
        }

        for (Member member : members) {
            LocalDate birthDate = member.getAge();
            if (birthDate == null) {
                System.out.println("Du har ikke givet alder på dette medlem: " + member.getId());
            } else if (birthDate.plusYears(18).isAfter(LocalDate.now())) {
                juniorTeam.setSwimmers(member);
                System.out.println(member.getId() + " Tilføjet til juniorhold.");
            } else {
                seniorTeam.setSwimmers(member);
                System.out.println(member.getId() + " Tilføjet til seniorhold.");
            }
        }
    }


    //Registrering af konkurrencesvømmer.
    public void registrerCompetition(ArrayList<Member> memberList, ArrayList<Competition> competitionList) {
        System.out.println("Hvilket medlem deltager i konkurrencen?");
        for (Member member : memberList) {
            System.out.println("Navn: " + member.getFirstName() + " " + member.getLastName() +
                    ". Medlemmets ID: " + member.getId());
        }

        System.out.println("Indtast MedlemID:");
        stringInput = stringInput();
        String inputCompetition = stringInput;

        for (Member member : memberList) {
            if (inputCompetition.equalsIgnoreCase(member.getId())) {
                System.out.println("Indtast konkurrencens tidspunkt:");
                String competitionTime = stringInput();

                System.out.println("Indtast konkurrencens navn:");
                String competitionName = stringInput();

                System.out.println("Indtast konkurrencens dato (YYYY-MM-DD):");
                String competitionDate = stringInput();
                LocalDate competitionLocalDate = LocalDate.parse(competitionDate);

                System.out.println("Indtast disciplin:");
                String discipline = stringInput();

                Competition competition = new Competition(
                        competitionTime,
                        member.getId(),
                        competitionName,
                        competitionLocalDate,
                        discipline
                );

                member.getCompetitionPerformance().add(competition);
                competitionList.add(competition);

                System.out.println("Konkurrence registreret for medlem: " + member.getFirstName() + " " + member.getLastName());
                break;
            }
        }
    }

    //Add trainer
    public void addTrainer(ArrayList<Trainer> trainerList, ArrayList<Team> teamList){
        String teamIDStr;
        String trainerIDStr;

        System.out.println("Hvilket hold skal træneren tilføjes");
        for (Team team : teamList) {
            System.out.println("Holdnavn: " + team.getTeamName() + " Hold ID: " + team.getTeamID());
        }
        System.out.println("Indtast Hold ID");
        stringInput = stringInput();
        teamIDStr = stringInput;

        for (Team team : teamList) {
            if (teamIDStr.equalsIgnoreCase(team.getTeamID())) {
                System.out.println("Hvilken træner skal tilføjes?");
                for (Trainer trainer : trainerList) {
                    System.out.println("Navn: " + trainer.getFirstName() +
                            " " + trainer.getLastName() + "\n" +
                            " " + "Træner ID: " + trainer.getTrainerID());
                }
                System.out.println("Indtast Træner ID");
                stringInput = stringInput();
                trainerIDStr = stringInput;

                for (Trainer trainer : trainerList) {
                    if (trainerIDStr.equalsIgnoreCase(trainer.getTrainerID())) {
                        team.setTrainer(trainer);
                        break;
                    }
                }
            }
        }
        System.out.println("Træner tilføjet!");
    }

    public void registerTraining(ArrayList<Member> memberList){
        for(Member member : memberList){
            System.out.println("Navn: " + member.getFirstName() + " " + member.getLastName() + "\n" +
                               "MedlemID: " + member.getId() + "\n" +
                               "---------------------------------------------");
        }
        System.out.println("Vælg et medlemID fra overstående");
        stringInput = stringInput();
        String memberID = stringInput;
        for(Member member : memberList){
            int totalSeconds;

            if(memberID.equals(member.getId())){
                System.out.println("Indtast venligst dato for træningen i format; dd/mm/yyyy");

                stringInput = stringInput();
                String date = stringInput.trim();

                String day = date.substring(0, 2);
                String month = date.substring(3, 5);
                String year = date.substring(6, 10);

                int intDay = Integer.parseInt(day);
                int intMonth = Integer.parseInt(month);
                int intYear = Integer.parseInt(year);

                System.out.println("Indtast tiden for træning i format; mm:ss");

                stringInput = stringInput();
                String time = stringInput.trim();

                String mm = time.substring(0, 2);
                String ss = time.substring(3, 5);

                int intMM = Integer.parseInt(mm);
                int intSS = Integer.parseInt(ss);

                totalSeconds = (intMM * 60) + intSS;

                Training training = new Training(memberID,totalSeconds, LocalDate.of(intYear, intMonth, intDay));

                //Hvis ArrayList<Training> har mindre end 5 entries bliver det bare tilføjet
                if(member.getTrainingPerformance().size() < 5) {
                    member.getTrainingPerformance().add(training);
                } else {
                    //Hvis ArrayList<Training> har 5 pladser, sorterer den ArrayListen finder den længste tid og erstatter den med den nye hvis den er mindre
                    member.getTrainingPerformance().sort(Training::compareTo);
                    if(member.getTrainingPerformance().getLast().getLapTime() > totalSeconds) {
                        member.getTrainingPerformance().set(4, training);
                    }
                }
                break;

            }
        }
    }

    @Override
    public String stringInput(){
        Scanner sc = new Scanner(System.in);
        try {
            stringInput = sc.nextLine();
            return stringInput;

        } catch (Exception e) {
            return "Error: No input was found! " + e;
        }
    }

    @Override
    public int intInput() {
        return 0;
    }
}
