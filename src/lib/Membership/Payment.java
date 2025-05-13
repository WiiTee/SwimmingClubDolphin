package lib.Membership;

import lib.persons.Member;

import java.time.LocalDate;
import java.time.Period;

public class Payment {
    private LocalDate subscriptionDate;
    private LocalDate lastPayment;
    private double paymentAmount;
    private boolean hasPaid;

    public Payment(LocalDate subscriptionDate, Member member){
        this.subscriptionDate = subscriptionDate;
        this.paymentAmount = paymentSelector(member);
    }

    public double paymentSelector(Member member){
        int age = Period.between(member.getAge(), LocalDate.now()).getYears();

        if(age < 18){
            return 1000;
        } else if (age > 18 && age < 65) {
            return 1800;
        } else {
            return 1800 * 0.75;
        }
    }
}
