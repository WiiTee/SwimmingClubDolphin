package lib.persons;

import java.util.UUID;

public class Trainer extends Person{
    private String trainerID;

    public Trainer(String firstName, String lastName, int phoneNumber){
        super(firstName, lastName, phoneNumber);
        super.constructID(firstName, lastName);
        this.trainerID = super.constructAccessID();
    }

    public String getTrainerID() {
        return trainerID;
    }
}
