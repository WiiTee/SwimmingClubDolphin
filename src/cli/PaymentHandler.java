package cli;

import lib.membership.Membership;
import lib.membership.Payment;
import lib.persons.Member;

import java.time.LocalDate;

public class PaymentHandler {

    // ####################
    // Handles payment part
    // ####################
    public static void updateLastPaid(Member member){
        member.getPayment().setLastPayment(LocalDate.now());
        member.getPayment().setHasPaid();
    }

    public static void checkDebt(Member member){
        if(member.getPayment().getHasPaid()){
            System.out.println("Medlem har betalt!");
        } else {
            System.out.println("Medlem er i restance!");
        }
    }

    public static void updatePaymentAmount(Member member){
        member.getPayment().setPaymentAmount(member);
    }

    // #######################
    // Handles membership part
    // #######################
    public static void membershipStatus(Member member){
        if(member.getIsActive()){
            System.out.println("Medlem er aktivt");
        }
    }
}
