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
        if(lastPayment.plusYears(1).isAfter(LocalDate.now())){
            hasPaid = false;
        } else {
            hasPaid = true;
        }
    }

    public void setLastPayment(LocalDate lastPayment) {
        this.lastPayment = lastPayment;
    }
/*
    //Indlæs payment data fra csv fil der indeholder alle members.

    //NEED:
    //Sort payments into two arrays, with sort on age.

    //Array der holder all payments.
    private List<Integer> allPayments = new ArrayList<>();

    //Metode der indlæser all payment attributter fra én csv fil der indeholder alle Medlemmer objekter.
    //@Override
    public void load(String filePath) {
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

 */
}

