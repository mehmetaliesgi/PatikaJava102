package AdventurePlay.Location;

public abstract class Monster {
    private String name;
    private int id;
    private int damage;
    private int health;
    private int orjinalHealth;
    private int award;

    public Monster(String name, int id, int damage, int health, int orjinalHealth, int award) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.orjinalHealth = orjinalHealth;
        this.award = award;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }
}
