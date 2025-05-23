import lib.membership.Membership;
import lib.persons.Member;
import lib.membership.Payment;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {
    Member member = new Member("test", "test", 1234, "test", LocalDate.of(1987, 11, 14));

    @Test
    void getPaymentAmount() {
    }

    @Test
    void getHasPaid() {
        Payment payment = new Payment(LocalDate.now(), member.getId());

        assertTrue(payment.getHasPaid());
    }

    @Test
    void getSubscriptionDate() {
        Payment payment = new Payment(LocalDate.of(2025, 1, 1), member.getId());

        assertEquals(LocalDate.of(2025, 1, 1), payment.getSubscriptionDate());
    }

    @Test
    void paymentSelector() {
        Payment payment = new Payment(LocalDate.now(), member.getId());

        assertEquals(1800, payment.paymentSelector(LocalDate.of(1987, 11, 14), member));
        assertEquals(1350, payment.paymentSelector(LocalDate.of(1900, 1, 1), member));
        assertEquals(1000, payment.paymentSelector(LocalDate.of(2015, 1, 1), member));
        member.getMembership().isActive();
        assertEquals(500, payment.paymentSelector(member.getAge(), member));
    }

    @Test
    void setPaymentAmount() {
        Payment payment = new Payment(LocalDate.now(), member.getId());

        payment.setPaymentAmount(member);

        assertEquals(1800, payment.getPaymentAmount());
    }

    @Test
    void setHasPaid() {
        Payment payment = new Payment(LocalDate.now(), member.getId());
        payment.setLastPayment(LocalDate.now());
        payment.setHasPaid();

        assertFalse(payment.getHasPaid());

        payment.setLastPayment(LocalDate.of(2020, 10, 1));
        payment.setHasPaid();

        assertTrue(payment.getHasPaid());
    }

    @Test
    void setLastPayment() {
        Payment payment = new Payment(LocalDate.now(), member.getId());
        payment.setLastPayment(LocalDate.of(2025, 1, 1));

        assertEquals(LocalDate.of(2025, 1, 1), payment.getLastPayment());
    }
}
