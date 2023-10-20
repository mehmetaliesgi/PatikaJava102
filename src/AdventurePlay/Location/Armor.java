package AdventurePlay.Location;

public class Armor {
    private int id;
    private String armorName;
    private int block;
    private int armorPrice;
    public Armor(int id, String armorName, int block, int armorPrice) {
        this.id = id;
        this.armorName = armorName;
        this.block = block;
        this.armorPrice = armorPrice;
    }

    public static Armor[] armors() {
       Armor[] armorlist = new Armor[3];
       armorlist[0] = new Armor(1,"Hafif", 2, 10);
       armorlist[1] = new Armor(2,"Orta", 5, 30);
       armorlist[2] = new Armor(3,"Ağır", 10, 40);
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

    public int getBlock() {
        return block;
    }

    public void setBlock(int armorDefence) {
        this.block = armorDefence;
    }

    public int getArmorPrice() {
        return armorPrice;
    }

    public void setArmorPrice(int armorPrice) {
        this.armorPrice = armorPrice;
    }
}
