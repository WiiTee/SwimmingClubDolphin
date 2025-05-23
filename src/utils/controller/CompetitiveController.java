package utils.controller;

import lib.competitive.Competition;
import lib.competitive.Team;
import lib.competitive.Training;
import lib.persons.Member;
import lib.persons.Trainer;
import utils.FileHandler;
import utils.interfaces.IScannerInput;
import utils.containers.ArrayContainer;

import utils.containers.ArrayContainer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class CompetitiveController implements IScannerInput {
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

        for (int i = 0; i < memberList.size(); i++) {
            if (inputID.equalsIgnoreCase(memberList.get(i).getId())) {
                String disciplineStr;
                String answer;
                System.out.println("Registrer discipliner");
                while (isDiscipline) {
                    stringInput = stringInput();
                    disciplineStr = stringInput;

                    System.out.println("Er det alle discipliner brug Y/N");
                    answer = stringInput();
                    if (answer.equalsIgnoreCase("Y")) {
                        disciplines.add(disciplineStr);
                        isDiscipline = false;
                    } else if (answer.equalsIgnoreCase("N")) {
                        System.out.println("Registrer ny disciplin");
                    } else {
                        System.out.println("Error: Brug Y eller N");
                    }
                }

                memberList.get(i).setDisciplines(disciplines);

                System.out.println("Registrer hold");
                for (Team team : teamList) {
                    System.out.println("Holdnavn: " + team.getTeamName() + " Hold Type: " + team.getTeamType());
                }
                System.out.println("Indtast Holdnavn");
                stringInput = stringInput();
                String teamName = stringInput;
                System.out.println("Indtast holdtype");
                stringInput = stringInput();
                String teamType = stringInput;
                for (Team team : teamList) {
                    if (teamName.equals(team.getTeamName()) && teamType.equals(team.getTeamType())) {
                        memberList.get(i).setTeamName(teamName);
                        team.getSwimmers().add(memberList.get(i));
                    } else {
                        System.out.println("Holdet eksisterer ikke");
                    }
                }
            }
        }
    }

    //Registrer nyt hold
    public void addTeam(ArrayList<Team> teamList) {
        boolean isRegistering = true;
        while(isRegistering){
            System.out.println("Indtast hold navn");
            stringInput = stringInput();
            String holdNavn = stringInput;

            System.out.println("Indtast hold type: (Senior eller Junior)");
            stringInput = stringInput();
            String holdType = "";
            boolean isRegisteringType = true;
            while (isRegisteringType) {
                if (stringInput.equalsIgnoreCase("Senior") || stringInput.equalsIgnoreCase("Junior")) {
                    holdType = stringInput;
                    isRegisteringType = false;
                } else {
                    System.out.println("Error: Det skal være senior eller junior");
                }
            }

            Team team = new Team(holdNavn, holdType);

            teamList.add(team);

            for (Team team1 : teamList) {
                System.out.println("Holdnavn: " + team1.getTeamName() + " Hold type: " + team1.getTeamType());
            }

            isRegistering = false;
        }
    }

    //Inddeler member i seniorhold eller juniorhold.
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


    //Registrering af konkurrence
    public void registrerCompetition(ArrayList<Member> memberList) {
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
                System.out.println("Indtast runde tiden i format mm:ss:");
                String competitionTime = stringInput();

                String mm = competitionTime.substring(0, 2);
                String ss = competitionTime.substring(3, 5);

                int intMM = Integer.parseInt(mm);
                int intSS = Integer.parseInt(ss);

                int totalSeconds = (intMM * 60) + intSS;

                System.out.println("Indtast konkurrencens navn:");
                String competitionName = stringInput();

                System.out.println("Indtast konkurrencens dato (YYYY-MM-DD):");
                String competitionDate = stringInput();
                LocalDate competitionLocalDate = LocalDate.parse(competitionDate);

                System.out.println("Indtast disciplin:");
                String discipline = stringInput();

                Competition competition = new Competition(
                        totalSeconds,
                        member.getId(),
                        competitionLocalDate,
                        competitionName,
                        discipline
                );

                member.getCompetitionPerformance().add(competition);

                System.out.println("Konkurrence registreret for medlem: " + member.getFirstName() + " " + member.getLastName());
                break;
            }
        }
    }

    //Add trainer
    public void addTrainer(ArrayList<Trainer> trainerList, ArrayList<Team> teamList) {
        String teamIDStr;
        String trainerIDStr;

        System.out.println("Hvilket hold skal træneren tilføjes");
        for (Team team : teamList) {
            System.out.println("Holdnavn: " + team.getTeamName() + " Hold ID: " + team.getTeamType());
        }
        System.out.println("Indtast Hold ID");
        stringInput = stringInput();
        teamIDStr = stringInput;

        for (Team team : teamList) {
            if (teamIDStr.equalsIgnoreCase(team.getTeamType())) {
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

    public void registerTraining(ArrayList<Member> memberList, ArrayList<Training> trainingList) {
        if (!memberList.isEmpty()) {
            for (Member member : memberList) {
                System.out.println("Navn: " + member.getFirstName() + " " + member.getLastName() + "\n" +
                        "MedlemID: " + member.getId() + "\n" +
                        "---------------------------------------------");
                System.out.println("Vælg et medlemID fra overstående");
                stringInput = stringInput();
                String memberID = stringInput;
                for (Member member1 : memberList) {
                    int totalSeconds;

                    if (memberID.equals(member1.getId())) {
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

                        System.out.println("Indtast disciplin for træning");
                        stringInput = stringInput();
                        String discipline = stringInput;

                        Training training = new Training(memberID, totalSeconds, LocalDate.of(intYear, intMonth, intDay), discipline);

                        //Hvis ArrayList<Training> ikke har en disciplin allerede
                        for (int z = 0; z < member1.getTrainingPerformance().size(); z++) {
                            if (!member1.getTrainingPerformance().get(z).getDiscipline().equals(discipline)) {
                                member1.getTrainingPerformance().add(training);
                                trainingList.add(training);
                                break;
                            } else {
                                //Hvis ArrayList<Training> i member har 5 pladser, sorterer den ArrayListen finder den længste tid og erstatter den med den nye hvis den er mindre
                                member1.getTrainingPerformance().sort(Training::compareTo);
                                for (int i = 0; i < member1.getTrainingPerformance().size(); i++) {
                                    if (member1.getTrainingPerformance().get(i).getDiscipline().equals(discipline)) {
                                        if (member1.getTrainingPerformance().get(i).getLapTime() > totalSeconds) {
                                            member1.getTrainingPerformance().set(i, training);
                                            break;
                                        }
                                    } else {
                                        member1.getTrainingPerformance().add(training);
                                        break;
                                    }
                                }
                                //Tilføjer den til ArrayList<Training>
                                for (int x = 0; x < trainingList.size(); x++) {
                                    if (trainingList.get(x).getDiscipline().equals(discipline)) {
                                        if (trainingList.get(x).getLapTime() > totalSeconds) {
                                            trainingList.set(x, training);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    } else {
                        System.out.println("Medlemmet eksisterer ikke!");
                    }
                }
            }
        } else{
            System.out.println("Der er ingen medlemmer!");
        }
    }

    @Override
    public String stringInput() {
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextLine();

        } catch (Exception e) {
            return "Error: No input was found! " + e;
        }
    }

    @Override
    public int intInput() {
        return 0;

    }
}
