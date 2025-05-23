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

                System.out.println("Registrer hold");
                for (Team team : teamList) {
                    System.out.println("Holdnavn: " + team.getTeamName() + " Team ID: " + team.getTeamType());
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


    //Special getter method (returns the first object of the competitionPerformance (ArrayList) attribute within the Member object).
    public Competition getFirstCompetition() {
        return competitionPerformance.get(0);
    }


    //Find the top five contestants
    public void printTopFive() {

        //ArrayList that holds all members that have a Competition object with values.
        ArrayList<Member> tempCompetitors = new ArrayList<>();

        //ArrayList for abovementioned objects, for parting into an ArrayList of each respective discpline.
        ArrayList<Member> crawlMember = new ArrayList<>();
        ArrayList<Member> butterflyMember = new ArrayList<>();
        ArrayList<Member> rygcrawlMember = new ArrayList<>();
        ArrayList<Member> brystsvømningMember = new ArrayList<>();

        //memberList ligger i ArrayContainer class - hvorfor fanden genkender den ikke den i denne klasse?:'(
        for (Member temp : memberList) {
            //Is the respective member's competitionPerformance attribute empty for competition objects?
            if (!temp.getCompetitionPerformance().isEmpty()) {
                tempCompetitors.add(temp);
                //skal man have et for loop her, som tager competitionPerformance array for temp og gennemgår hvert Competition object, eller kan nedenstående kode godt iterere igennem det array der sættes til at skulle sortes? JA, denne linje af kode itererer.
                //Sort competitionPerformance array for every member object by competitionTime attribute:
                temp.getCompetitionPerformance().sort(Comparator.comparingInt(o -> Integer.parseInt(o.getCompetitionTime())));
            }
        }
        //part the sorted Memberobjects into for distinct arraylist for each discipline:
        for (Member temp : tempCompetitors) {
            switch (temp.getFirstCompetition().getDiscipline()) {
                case "Crawl":
                    crawlMember.add(temp);
                    break;
                case "Butterfly":
                    butterflyMember.add(temp);
                    break;
                case "Rygcrawl":
                    rygcrawlMember.add(temp);
                    break;
                case "Brystsvømning":
                    brystsvømningMember.add(temp);
                    break;
                default:
                    System.out.println("Unknown value:");

            }
        }

        //Sort the crawlMember ArrayList.
        crawlMember.sort(Comparator.comparingInt(o -> Integer.parseInt(o.getFirstCompetition().competitionTime())));

        //Sort the other disciplinary lists:
        butterflyMember.sort(Comparator.comparingInt(o -> Integer.parseInt(o.getFirstCompetition().competitionTime())));

        rygcrawlMember.sort(Comparator.comparingInt(o -> Integer.parseInt(o.getFirstCompetition().competitionTime())));

        brystsvømningMember.sort(Comparator.comparingInt(o -> Integer.parseInt(o.getFirstCompetition().competitionTime())));

        //Print
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("These are the top five contestants within the discipline CRAWL: MemberID = " + crawlMember.get(i).getMemberID() + "\\n whose name is: " + crawlMember.get(i).getFirstName() + " " + crawlMember.get(i).getLastName() + "\\nwho completed his lap in " + crawlMember.get(i).getCompetitionTime() + " seconds.\nLap was undertaken at: " + crawlMember.get(i).getCompetitionDate();
            }
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Contestants not found in this discipline");

        }
        //Print
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("These are the top five contestants within the discipline Butterfly: MemberID = " + butterflyMember.get(i).getMemberID() + "\\n whose name is: " + butterflyMember.get(i).getFirstName() + " " + crawlMember.get(i).getLastName() + "\\nwho completed his lap in " + butterflyMember.get(i).getCompetitionTime() + " seconds.\nLap was undertaken at: " + butterflyMember.get(i).getCompetitionDate();
            }
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Contestants not found in this discipline");

        //Print
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("These are the top five contestants within the discipline Rygcrawl: MemberID = " + rygcrawlMember.get(i).getMemberID() + "\\n whose name is: " + rygcrawlMember.get(i).getFirstName() + " " + rygcrawlMember.get(i).getLastName() + "\\nwho completed his lap in " + rygcrawlMember.get(i).getCompetitionTime() + " seconds.\nLap was undertaken at: " + rygcrawlMember.get(i).getCompetitionDate();
            }
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Contestants not found in this discipline");

        //Print
        }
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("These are the top five contestants within the discipline BrystSvømning: MemberID = " + brystsvømningMember.get(i).getMemberID() + "\\n whose name is: " + brystsvømningMember.get(i).getFirstName() + " " + brystsvømningMember.get(i).getLastName() + "\\nwho completed his lap in " + brystsvømningMember.get(i).getCompetitionTime() + " seconds.\nLap was undertaken at: " + brystsvømningMember.get(i).getCompetitionDate();
            }
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Contestants not found in this discipline");
        }


        System.out.println("Dear dipshit - these contestants are the following top 5 performers within the respective branch of swimming: " )

    }




        /*
        for (Member temp : crawlMember) {

        }

        for (Member temp : butterflyMember) {

        }

        for (Member temp : rygcrawlMember) {

        }

        for (Member temp : brystsvømning) {
        */

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
