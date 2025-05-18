package lib.membership;

import lib.persons.Member;

import java.time.LocalDate;
import java.time.Period;

public class Payment {
    private LocalDate subscriptionDate;
    private LocalDate lastPayment;
    private double paymentAmount;
    private boolean hasPaid;
    private String memberID;

    public Payment(LocalDate subscriptionDate, LocalDate age, String memberID){
        this.subscriptionDate = subscriptionDate;
        this.lastPayment = subscriptionDate;
        this.paymentAmount = paymentSelector(age);
        this.hasPaid = true;
        this.memberID = memberID;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public boolean getHasPaid(){
        return hasPaid;
    }

    public LocalDate getLastPayment() {
        return lastPayment;
    }

    public LocalDate getSubscriptionDate() {
        return subscriptionDate;
    }

    public double paymentSelector(LocalDate memberAge){
        int age = Period.between(memberAge, LocalDate.now()).getYears();

        if(age < 18){
            return 1000;
        } else if (age > 18 && age < 65) {
            return 1800;
        } else {
            return 1800 * 0.75;
        }
    }

    public void setPaymentAmount(Member member){
        this.paymentAmount = paymentSelector(member.getAge());
    }

    public void setHasPaid(){
        hasPaid = !lastPayment.plusYears(1).isAfter(LocalDate.now());
    }

    public void setLastPayment(LocalDate lastPayment) {
        this.lastPayment = lastPayment;

    }
/*
    //Metode der indlæser all payment attributter fra én csv fil der indeholder alle Medlemmer objekter, uden at at objekter først loades i en load() metode.


    //Metode der indlæser all payment attributter fra én csv fil der indeholder alle Medlemmer objekter.
    //@Override
    public void load(String filePath) {

    public ArrayList<String> loadPaymentsToPrint(String filePath) {
        List<Integer> allPayments = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((!line = br.nextLine()) = null) {
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
        return allPayments;

        //_______________________________________________________________________________________________________________
    }
    public List<Integer> getAllPayments() {
        return allPayments;
    }

    //___________________________________________________________________________________________________________________

    //metode til at printe enkelte betalinger. (Metoden indeholder loadPaymentsToPrint() metode der loader filen.).
    public void printRespectivePayments() {
        System.out.print("Her er alle de enkelte betalinger: ");
        for (int temp : getAllPayments()) {
            System.out.println(temp);
        }
    }
    //Metode til at printe enkelte betalinger uden objekt. (Metoden indeholder loadPaymentsToPrint() metode der loader filen.).
    public void printRespectivePayments() {
        System.out.print("Her er alle de enkelte betalinger: ");
        for (int temp : loadPaymentsToPrint()) {
            System.out.println(temp);


    //Metode til at returnere summen af alle betalinger. (Metoden indeholder loadPaymentsToPrint() metode der loader filen.).
    public void printSumOfPayments() {
        int sum = 0;
        System.out.println("Her er summen af de enkelte betalinger: ");
        for (int temp : getAllPayments()) {
            sum += temp;
        }

    }

 */
}

