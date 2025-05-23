package lib.membership;

import lib.persons.Member;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Payment {
    private LocalDate subscriptionDate;
    private LocalDate lastPayment;
    private double paymentAmount;
    private boolean hasPaid;
    private String memberID;

    public Payment(LocalDate subscriptionDate, String memberID) {
        this.subscriptionDate = subscriptionDate;
        this.lastPayment = subscriptionDate;
        this.hasPaid = true;
        this.memberID = memberID;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public boolean getHasPaid() {
        return hasPaid;
    }

    public LocalDate getLastPayment() {
        return lastPayment;
    }

    public LocalDate getSubscriptionDate() {
        return subscriptionDate;
    }

    public String getMemberID() {
        return memberID;
    }

    public double paymentSelector(LocalDate memberAge, Member member) {
        int age = Period.between(memberAge, LocalDate.now()).getYears();

        if(member.getMembership().getIsActive()){
            if (age < 18) {
                return 1000;
            } else if (age > 18 && age < 65) {
                return 1800;
            } else {
                return 1800 * 0.75;
            }
        } else {
            return 500;
        }

    }

    public void setPaymentAmount(Member member) {
        this.paymentAmount = paymentSelector(member.getAge(), member);
    }

    public void setHasPaid() {
        hasPaid = !lastPayment.plusYears(1).isAfter(LocalDate.now());
    }

    public void setLastPayment(LocalDate lastPayment) {
        this.lastPayment = lastPayment;
    }

    public void loadHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }
    public void loadPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}
