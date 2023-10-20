package AdventurePlay.Location;

public class Armor {
    private int id;
    private String armorName;
    private int armorDefence;
    private int armorPrice;
    public Armor(int id, String armorName, int armorDefence, int armorPrice) {
        this.id = id;
        this.armorName = armorName;
        this.armorDefence = armorDefence;
        this.armorPrice = armorPrice;
    }

    public static Armor[] armors() {
       Armor[] armorlist = new Armor[3];
       armorlist[0] = new Armor(1,"Zırh 1", 10, 10);
       armorlist[1] = new Armor(2,"Zırh 2", 15, 15);
       armorlist[2] = new Armor(3,"Zırh 3", 20, 20);
       return armorlist;
    }

    public static Armor getArmorObjByID(int id) {
        for (Armor armor : Armor.armors()) {
            if (armor.getId() == id) {
                return armor;
            }
        }
        return null;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getArmorDefence() {
        return armorDefence;
    }

    public void setArmorDefence(int armorDefence) {
        this.armorDefence = armorDefence;
    }

    public int getArmorPrice() {
        return armorPrice;
    }

    public void setArmorPrice(int armorPrice) {
        this.armorPrice = armorPrice;
    }
}
