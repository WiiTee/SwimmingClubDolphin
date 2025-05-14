package lib.persons;

public class Accountant extends Person{
    private String accountantID;
    private String AccessLevel;

    public Accountant(String firstName, String lastName, int phoneNumber){
        super(firstName, lastName, phoneNumber);
        super.constructID(firstName, lastName);
        this.accountantID = super.constructAccessID();
    }
}

import java.util.*;
import java.io.*;

//Indlæs payment data fra csv fil der indeholder alle members.

public class Accountant extends Person implements IFileHandler {


    //NEED:
    //Sort payments into two arrays, with sort on age.

    //Array der holder all payments.
    private List<Integer> allPayments = new ArrayList<>();

    //Metode der indlæser all payment attributer fra én csv fil der indeholder alle Medlemmer objekter.
    @Override
    public void load(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((!line = br.nextLine) = null) {
                String[] fields = line.split(",");

                if (fields.length >= 4);
                try {
                    int amount = Integer.parseInt(fields[3].trim());
                    allPaymments.add(amount);
                }
                catch (NumberFormatException e) {
                    System.err.println("Ikke validt tal format i linjen: " + line);
                }
                else {
                    System.err.println("Invalid line(too few fields)): " + line);

                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<Integer> getAllPayments() {
        return allPayments;
    }

    //metode til at printe betalinger enkeltvis: (Metoden indeholder load() metode der loader filen.).
    public void printRespectivePayments() {
        System.out.print("Her er alle de enkelte betalinger: ");
        for (int temp : getAllPayments()) {
            System.out.println(temp);
        }
    }

    //Metode til at returnere summen af alle betalinger: (Metoden indeholder load() metode der loader filen.).
    public void printSumOfPayments() {
        int sum = 0;
        System.out.println("Her er summen af de enkelte betalinger: ");
        for (int temp : getAllPayments()) {
            sum += temp;
        }
    }
}
