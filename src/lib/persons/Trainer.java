package lib.persons;

public class Trainer extends Person{
    private String trainerID;

    public Trainer(String firstName, String lastName, int phoneNumber){
        super(firstName, lastName, phoneNumber);
        this.trainerID = super.constructAccessID();
    }

    public Trainer(String firstName, String lastName, int phoneNumber, String id, String trainerID){
        super(firstName, lastName, phoneNumber, id);
        this.trainerID = trainerID;
    }

    public String getTrainerID() {
        return trainerID;
    }
}
