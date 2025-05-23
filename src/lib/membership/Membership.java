package lib.membership;

public class Membership {
    public enum MembershipType{
        MOTIONIST("Motionist"),
        KONKURRENCE("Konkurrence");

        private final String type;

        MembershipType(String str){
            this.type = str;
        }

        public String getType() {
            return type;
        }
    }
    private MembershipType membershipType;
    private boolean isActive;
    private String memberID;

    //Opretter medlemskabsobjekter
    public Membership(MembershipType membershipType, String memberID){
        this.membershipType = membershipType;
        this.memberID = memberID;
        this.isActive = true;
    }

    public Membership(String memberID){
        this.memberID = memberID;
    }

    //Sætter isActive
    public boolean isActive(){
        if(isActive){
            return isActive = false;
        } else {
            return isActive = true;
        }
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public boolean getIsActive(){
        return isActive;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
