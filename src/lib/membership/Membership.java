package lib.membership;

public class Membership {
    public enum MembershipType{
        MOTIONIST,
        KONKURRENCE
    }
    private MembershipType membershipType;
    private boolean isActive;

    public Membership(MembershipType membershipType){
        this.membershipType = membershipType;
        this.isActive = true;
    }

    public boolean isActive(){
        if(isActive){
            return isActive = false;
        } else {
            return isActive = true;
        }
    }
}
