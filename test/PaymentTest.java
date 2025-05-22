import lib.membership.Membership;
import lib.persons.Member;
import lib.membership.Payment;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {
    Member member = new Member("test", "test", 1234, new Membership(Membership.MembershipType.MOTIONIST, "test"), "test", LocalDate.of(1987, 11, 14));

    @Test
    void getPaymentAmount() {
    }

    @Test
    void getHasPaid() {
        Payment payment = new Payment(LocalDate.now(), LocalDate.of(1987, 11, 14), member.getId());

        assertTrue(payment.getHasPaid());
    }

    @Test
    void getSubscriptionDate() {
        Payment payment = new Payment(LocalDate.of(2025, 1, 1), LocalDate.of(1987, 11, 14), member.getId());

        assertEquals(LocalDate.of(2025, 1, 1), payment.getSubscriptionDate());
    }

    @Test
    void paymentSelector() {
        Member member1 = new Member("Jens", "Gotfredsen", 12345678, new Membership(Membership.MembershipType.KONKURRENCE, "test1"), "test", LocalDate.of(1987, 11, 14));
        Payment payment = new Payment(LocalDate.now(), LocalDate.of(1987, 11, 14), member1.getId());

        member1.setPayment(payment);
        member1.getPayment().setPaymentAmount(member1);

        assertEquals(1800, payment.paymentSelector(LocalDate.of(1987, 11, 14), member1));
        assertEquals(1350, payment.paymentSelector(LocalDate.of(1950, 1, 1), member1));
        assertEquals(1000, payment.paymentSelector(LocalDate.of(2015, 1, 1), member1));
        member1.getMembership().isActive();
        assertEquals(500, payment.paymentSelector(LocalDate.of(1987, 10, 14), member1));
    }

    @Test
    void setPaymentAmount() {
        Payment payment = new Payment(LocalDate.now(), member.getAge(), member.getId());
        member.setPayment(payment);
        member.getPayment().setPaymentAmount(member);

        assertEquals(1800, payment.getPaymentAmount());
    }

    @Test
    void setHasPaid() {
        Payment payment = new Payment(LocalDate.now(), LocalDate.of(1987, 11, 14), member.getId());
        payment.setLastPayment(LocalDate.now());
        payment.setHasPaid();

        assertFalse(payment.getHasPaid());

        System.out.println("Restance: " + payment.getHasPaid());

        payment.setLastPayment(LocalDate.of(2020, 10, 1));
        payment.setHasPaid();

        assertTrue(payment.getHasPaid());

        System.out.println("Restance: " + payment.getHasPaid());
    }

    @Test
    void setLastPayment() {
        Payment payment = new Payment(LocalDate.now(), LocalDate.of(1987, 11, 14), member.getId());
        payment.setLastPayment(LocalDate.of(2025, 1, 1));

        assertEquals(LocalDate.of(2025, 1, 1), payment.getLastPayment());
    }
}
