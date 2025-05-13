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
        member.getPayment().getHasPaid();
    }

    public static void updatePaymentAmount(Member member){
        member.getPayment().setPaymentAmount(member);
    }

    // #######################
    // Handles membership part
    // #######################
    public static void membershipStatus(Member member){
        member.getMembership().isActive();
    }
}
