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

    //________________________________________________________________________________________________________________


    //Metode der finder summen af paymentAmount attributer fra Medlemobjekter.
    //Metoden antager at load() returnerer en arraylist med Member Objekter der kan benyttes direkte i metoden her.
    //Variablen 'MemberObjects' henviser til denne ArrayList fra load().

    public void printSumOfpaymentAmountAttributesFromLoadedObjects() {

        try {
            for (ArrayList<Member> temp : **MemberObjects**) {
                double singlePaymentAmountString = temp.getPayment().getPaymentAmount();
                double sumOfAllPayments +=singlePaymentAmount;
            }
        catch(Exception e){
                System.out.println("Mistake happened at: " + e);
            }
            System.out.println("Summen af indbetalinger ligger på nuværende tidspunkt på: " + sumOfAllPayments);
        }
    }

    //Metode der printer alle enkelte paymentAmount attributer fra Member (<-- Payment) objekter.
    public printRespectivePaymentAmountAttributesFromLoadedObjects() {
        try {
            System.out.println("Oversigt over de enkelte betalinger: n/________________________________________________________");
            for (Member temp : **MemberObjects**) {
                double respectivePaymentAmount = temp.getPayment().getPaymentAmount();
                String firstNameTemp = temp.getfirstName();
                String lastNameTemp =  temp.getlastName();
                System.out.println("Amount: " + respectivePaymentAmount ", from: " + lastNameTemp + ", " + firstNameTemp);
            }
        }
        catch (exception e) {
            return "Error occured at " + e;
        }
    }
//Metode der finder summen af paymentAmount attributer fra Medlemobjekter.
    //Metoden antager at load() returnerer en arraylist med Member Objekter der kan benyttes direkte i metoden her.
    //Variablen 'MemberObjects' henviser til denne ArrayList fra load().

    public void printSumOfpaymentAmountAttributesFromLoadedObjects() {

            while ((!line = br.nextLine()) = null) {
                String[] fields = line.split(",");
        try {
            for (ArrayList<Member> temp : **MemberObjects**) {
                double singlePaymentAmountString = temp.getPayment().getPaymentAmount();
                double sumOfAllPayments +=singlePaymentAmount;
            }
        catch(Exception e){
                System.out.println("Mistake happened at: " + e);
            }
            System.out.println("Summen af indbetalinger ligger på nuværende tidspunkt på: " + sumOfAllPayments);
        }
    }

    //Metode der printer alle enkelte paymentAmount attributer fra Member (<-- Payment) objekter.
    public printRespectivePaymentAmountAttributesFromLoadedObjects() {
        try {
            System.out.println("Oversigt over de enkelte betalinger: n/________________________________________________________");
            for (Member temp : **MemberObjects**) {
                double respectivePaymentAmount = temp.getPayment().getPaymentAmount();
                String firstNameTemp = temp.getfirstName();
                String lastNameTemp =  temp.getlastName();
                System.out.println("Amount: " + respectivePaymentAmount ", from: " + lastNameTemp + ", " + firstNameTemp);
            }
        }
        catch (exception e) {
            return "Error occured at " + e;
        }
        return allPayments;

        //_______________________________________________________________________________________________________________
    }
    public List<Integer> getAllPayments() {
        return allPayments;
    }

    }
