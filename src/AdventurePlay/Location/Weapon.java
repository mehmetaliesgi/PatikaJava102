package AdventurePlay.Location;

public class Weapon {
    private String name;
    private int id, damage, price;

    public Weapon( String name, int id, int damage, int price) {
        this.id = id;
        this.damage = damage;
        this.price = price;
        this.name = name;
    }
    public static Weapon[] weapons() {
        Weapon[] weaponList = new Weapon[3];
        //Burada her bir weapon için alt sınıf oluşturabilirdik fakat bu da farklı bir yöntem.
        weaponList[0] = new Weapon("Tabanca", 1, 3, 25);
        weaponList[1] = new Weapon("Kılıç", 2, 5, 35);
        weaponList[2] = new Weapon("Tüfek", 3, 8, 45);

        return weaponList;
    }

    public static Weapon getWeaponObjByID(int id) {
        for (Weapon weapon : Weapon.weapons()) {
            if (weapon.getId() == id) {
                return weapon;
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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
