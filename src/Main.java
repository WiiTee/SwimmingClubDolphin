import lib.persons.Member;
import lib.persons.Trainer;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Member member = new Member("Jens", "Gotfredsen", 12345678, "Motionist", "Test Addresse", LocalDate.of(1987, 11, 14));
        Trainer trainer = new Trainer("Peter", "Larsen", 12345678);

        System.out.println("Payment Selection based on Age: " +  member.getPayment().getPaymentAmount() + "\n" +
                           "ID: " + member.getId() + "\n" +
                           "TrainerID: " + trainer.getTrainerID());
    }
}