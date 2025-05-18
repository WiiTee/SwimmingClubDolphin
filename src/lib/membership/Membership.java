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

    //Sætter isActive
    public boolean isActive(){
        if(isActive){
            return isActive = false;
        } else {
            return isActive = true;
        }
    }
}
