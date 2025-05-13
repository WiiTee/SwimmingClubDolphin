package lib.Membership;

public class Membership {
    private String membershipType;
    private boolean isActive;

    public Membership(String membershipType){
        this.membershipType = membershipType;
        this.isActive = true;
    }
}
