package lib.membership;

public class Membership {
    private String membershipType;
    private boolean isActive;

    public Membership(String membershipType){
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
