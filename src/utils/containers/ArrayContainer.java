package utils.containers;

import lib.competitive.Competition;
import lib.competitive.Team;
import lib.competitive.Training;
import lib.membership.Membership;
import lib.membership.Payment;
import lib.persons.Accountant;
import lib.persons.Member;
import lib.persons.Trainer;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ArrayContainer {
    //Container klasse så vi kan gemme og load information.
    //Container klassen skal sendes med som argument i alle menuer og gemmes som en variabel
    private ArrayList<Member> memberList = new ArrayList<>();
    private ArrayList<Accountant> accountantList = new ArrayList<>();
    private ArrayList<Trainer> trainerList = new ArrayList<>();

    private ArrayList<Payment> paymentsList = new ArrayList<>();

    private ArrayList<Team> teamList = new ArrayList<>();
    private ArrayList<Competition> competitionList = new ArrayList<>();
    private ArrayList<Training> trainingList = new ArrayList<>();

    public ArrayList<Team> getTeamList(){
        return teamList;
    }

    public ArrayList<Accountant> getAccountantList() {
        return accountantList;
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public ArrayList<Trainer> getTrainerList() {
        return trainerList;
    }

    public ArrayList<Competition> getCompetitionList() {
        return competitionList;
    }

    public ArrayList<Payment> getPaymentsList() {
        return paymentsList;
    }

    public ArrayList<Training> getTrainingList() {
        return trainingList;
    }

    public void createFiles(String fileName){
        try {
            File memberFile = new File("resources/" + fileName);
            if(memberFile.createNewFile()){
                System.out.println("File created: " + memberFile.getName());
            } else {
                System.out.println("File already exists: " + memberFile.getName());
            }
        } catch (IOException e) {
            System.out.println("File could not be created: " + fileName);
            //e.printStackTrace();
        }
    }
    public void saveMember(ArrayList<Member> memberList){
        try {
            //Gemmer medlemsdataer i memberlist.csv
            FileWriter fileWriter = new FileWriter("resources/memberlist.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(Member member : memberList){
                String id = member.getId();
                String firstName = member.getFirstName();
                String lastName = member.getLastName();
                String phoneNumber = String.valueOf(member.getPhoneNumber());
                String address = member.getAddress();
                String age = member.getAge().toString();
                String teamName;
                if(member.getTeamName() != null){
                    teamName = member.getTeamName();
                } else {
                    teamName = "NoTeam";
                }

                bufferedWriter.write(id + "," + firstName + "," + lastName + "," +
                                     phoneNumber + "," + address + "," + age + "," + teamName);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();

            //Gemmer medlemmets payment dataer i paymentlist.csv
            FileWriter fileWriter2 = new FileWriter("resources/paymentlist.csv");
            BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
            for(Member payment : memberList){
                String id = payment.getPayment().getMemberID();
                String subDate = payment.getPayment().getSubscriptionDate().toString();
                String lastDate = payment.getPayment().getLastPayment().toString();
                String payAmount = String.valueOf(payment.getPayment().getPaymentAmount());
                String hasPaid = String.valueOf(payment.getPayment().getHasPaid());
                bufferedWriter2.write(id + "," + subDate + "," + lastDate + "," + payAmount + "," + hasPaid);
                bufferedWriter2.newLine();
            }
            bufferedWriter2.close();
            fileWriter2.close();

            //Gemmer medlemmets membership i membershiplist.csv
            FileWriter fileWriter3 = new FileWriter("resources/membershiplist.csv");
            BufferedWriter bufferedWriter3 = new BufferedWriter(fileWriter3);
            for(Member membership : memberList){
                String id = membership.getMembership().getMemberID();
                String type = membership.getMembership().getMembershipType().getType();
                String active = String.valueOf(membership.getMembership().getIsActive());
                bufferedWriter3.write(id + "," + type + "," + active);
                bufferedWriter3.newLine();
            }
            bufferedWriter3.close();
            fileWriter3.close();
        } catch (IOException e) {
            System.out.println("Member could not be created: " + e.getMessage());
        }
    }

    public void saveTrainer(ArrayList<Trainer> trainerList){
        try {
            //Gemmer trænere i trainerlist.csv
            FileWriter fileWriter = new FileWriter("resources/trainerlist.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Trainer trainer : trainerList) {
                String id = trainer.getId();
                String firstName = trainer.getFirstName();
                String lastName = trainer.getLastName();
                String phoneNumber = String.valueOf(trainer.getPhoneNumber());
                String trainerID = String.valueOf(trainer.getTrainerID());

                bufferedWriter.write(id + "," + firstName + "," + lastName + "," +
                        phoneNumber + "," + trainerID);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Trainer could not be created: " + e.getMessage());
        }
    }

    public void saveTeam(ArrayList<Team> teamList){
        try{
            //Gemmer team i teamlist.csv
            FileWriter fileWriter = new FileWriter("resources/teamlist.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Team team : teamList) {
                String teamName = team.getTeamName();
                String teamType = team.getTeamType();

                bufferedWriter.write(teamName + "," + teamType);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Team could not be created: " + e.getMessage());
        }
    }

    public void load(){
        try{
            Scanner scanner = new Scanner(new File("resources/memberlist.csv"));
            while(scanner.hasNextLine()){
                String[] arr = scanner.nextLine().split(",");
                createMember(arr);
            }
            scanner.close();

            Scanner scanner2 = new Scanner(new File("resources/paymentlist.csv"));
            while(scanner2.hasNextLine()){
                String[] arr = scanner2.nextLine().split(",");
                createPayment(arr);
            }
            scanner2.close();

            Scanner scanner3 = new Scanner(new File("resources/membershiplist.csv"));
            while(scanner3.hasNextLine()){
                String[] arr = scanner3.nextLine().split(",");
                createMembership(arr);
            }
            scanner3.close();

            if(new File("resources/trainerlist.csv").exists()){
                Scanner scanner4 = new Scanner(new File("resources/trainerlist.csv"));
                while(scanner4.hasNextLine()){
                    String[] arr = scanner4.nextLine().split(",");
                    createTrainer(arr);
                }
                scanner4.close();
            }
            if(new File("resources/teamlist.csv").exists()){
                Scanner scanner5 = new Scanner(new File("resources/teamlist.csv"));
                while(scanner5.hasNextLine()){
                    String[] arr = scanner5.nextLine().split(",");
                    createTeam(arr);
                }
                scanner5.close();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void createMember(String[] arr){
        String id = arr[0];
        String firstName = arr[1];
        String lastName = arr[2];
        int phoneNumber = Integer.parseInt(arr[3]);
        String address = arr[4];
        LocalDate age = LocalDate.parse(arr[5]);
        String teamName = arr[6];

        Member member = new Member(id, firstName, lastName, phoneNumber, address, age);
        if(!teamName.equals("NoTeam")){
            member.setTeamName(teamName);
            memberList.add(member);
        } else {
            memberList.add(member);
        }
    }

    public void createPayment(String[] arr){
        String id = arr[0];
        LocalDate subDate = LocalDate.parse(arr[1]);
        LocalDate lastDate = LocalDate.parse(arr[2]);
        double payAmount = Double.parseDouble(arr[3]);
        boolean hasPaid = Boolean.parseBoolean(arr[4]);

        for (Member member : memberList) {
            try {
                if (member.getId().equals(id)) {
                    Payment payment = new Payment(subDate, id);
                    member.setPayment(payment);
                    member.getPayment().setLastPayment(lastDate);
                    member.getPayment().loadPaymentAmount(payAmount);
                    member.getPayment().loadHasPaid(hasPaid);
                }
            } catch (Exception e) {
                System.out.println("Error: Member does not exist");
            }
        }
    }

    public void createMembership(String[] arr){
        String id = arr[0];
        String type = arr[1].toLowerCase();
        Membership.MembershipType membershipType = null;
        boolean active = Boolean.parseBoolean(arr[2]);

        for (Member member : memberList) {
            try {
                if (member.getId().equals(id)) {
                    Membership membership = new Membership(id);
                    member.setMembership(membership);
                    member.getMembership().setIsActive(active);
                    switch (type){
                        case "motionist" -> membershipType = Membership.MembershipType.MOTIONIST;
                        case "konkurrencesvømmer" -> membershipType = Membership.MembershipType.KONKURRENCE;
                    }
                    member.getMembership().setMembershipType(membershipType);
                }
            } catch (Exception e) {
                System.out.println("Error: Member does not exist");
            }
        }
    }

    public void createTrainer(String[] arr){
        String id = arr[0];
        String firstName = arr[1];
        String lastName = arr[2];
        int phoneNumber = Integer.parseInt(arr[3]);
        String trainerID = arr[4];

        Trainer trainer = new Trainer(firstName, lastName, phoneNumber, id, trainerID);

        trainerList.add(trainer);
    }

    public void createTeam(String[] arr){
        String teamName = arr[0];
        String teamType = arr[1];

        Team team = new Team(teamName, teamType);
        if(!memberList.isEmpty()){
            for (Member member : memberList) {
                if (member.getTeamName() != null) {
                    team.getSwimmers().add(member);
                }
            }
        } else {
            System.out.println("Team har ikke nogen medlemmer!");
        }
        teamList.add(team);
    }
}
