package Enum;

public enum StaffMembers {
    ADMINISTRATION (1),
    SUPERMODERATOR (2),
    MODERATOR (3),
    MEMBER (4); // Enum elemanları arasında virgül konur.
    private int staffRank;
    StaffMembers(int staffRank) {
        this.staffRank = staffRank;
    }
    public int getStaffRank(){
        return staffRank;
    }
}
