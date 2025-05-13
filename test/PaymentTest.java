import lib.persons.Member;
import lib.membership.Payment;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {
    @Test
    void getPaymentAmount() {
    }

    @Test
    void getHasPaid() {
        Payment payment = new Payment(LocalDate.now(), LocalDate.of(1987, 11, 14));

        assertTrue(payment.getHasPaid());
    }

    @Test
    void getSubscriptionDate() {
        Payment payment = new Payment(LocalDate.of(2025, 1, 1), LocalDate.of(1987, 11, 14));

        assertEquals(LocalDate.of(2025, 1, 1), payment.getSubscriptionDate());
    }

    @Test
    void paymentSelector() {
        Payment payment = new Payment(LocalDate.now(), LocalDate.of(1987, 11, 14));

        assertEquals(1800, payment.paymentSelector(LocalDate.of(1987, 11, 14)));
        assertEquals(1350, payment.paymentSelector(LocalDate.of(1900, 1, 1)));
        assertEquals(1000, payment.paymentSelector(LocalDate.of(2015, 1, 1)));
    }

    @Test
    void setPaymentAmount() {
        Payment payment = new Payment(LocalDate.now(), LocalDate.of(1987, 11, 14));
        Member member = new Member("test", "test", 1234, "test", "test", LocalDate.of(1987, 11, 14));

        payment.setPaymentAmount(member);

        assertEquals(1800, payment.getPaymentAmount());
    }

    @Test
    void setHasPaid() {
        Payment payment = new Payment(LocalDate.now(), LocalDate.of(1987, 11, 14));
        payment.setLastPayment(LocalDate.now());
        payment.setHasPaid();

        assertTrue(payment.getHasPaid());

        payment.setLastPayment(LocalDate.of(2020, 10, 1));
        payment.setHasPaid();

        assertFalse(payment.getHasPaid());
    }

    @Test
    void setLastPayment() {
        Payment payment = new Payment(LocalDate.now(), LocalDate.of(1987, 11, 14));
        payment.setLastPayment(LocalDate.of(2025, 1, 1));

        assertEquals(LocalDate.of(2025, 1, 1), payment.getLastPayment());
    }
}
