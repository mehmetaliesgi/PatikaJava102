package AdventurePlay;

import AdventurePlay.GameCharacter.Archer;
import AdventurePlay.GameCharacter.GameCharacter;
import AdventurePlay.GameCharacter.Knight;
import AdventurePlay.GameCharacter.Samurai;

import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int money;
    private String name;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {

        GameCharacter[] gameCharacters = {new Samurai(), new Archer(), new Knight()};
        System.out.println("--------------------------------------------------------------------------------");
        for (GameCharacter gameCharacter : gameCharacters) {
            System.out.println("ID\t: " + gameCharacter.getId() +
                    "\t\t Karakter: " + gameCharacter.getName() +
                    "\t\t Hasar: " + gameCharacter.getDamage() +
                    "\t\t Sağlık: " + gameCharacter.getHealth() +
                    "\t\t Para: " + gameCharacter.getMoney());
        }
        System.out.println("--------------------------------------------------------------------------------");
        System.out.print("Lütfen bir karakter giriniz: ");
        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
                break;
        }
        /*
        System.out.println("Karakter: " + this.getName());
        System.out.println("Hasar\t: " + this.getDamage());
        System.out.println("Sağlık\t: " + this.getHealth());
        System.out.println("Para\t: " + this.getMoney());
        System.out.println("--------------------------------------------------------------------------------");
         */
    }
    public void initPlayer(GameCharacter gameCharacter) {
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealth());
        this.setMoney(gameCharacter.getMoney());
        this.setName(gameCharacter.getName());
    }

    public void printPlayerInfo() {
        System.out.println("Silah: " + this.getInventory().getWeapon().getName() +
                "\tZırh: " + this.getInventory().getArmor().getArmorName() +
                "\tBlock: " + this.getInventory().getArmor().getBlock() +
                ",\tHasar: " + this.getDamage() +
                ",\tSağlık: " + this.getHealth() +
                ",\tPara: " + this.getMoney());
    }

    public int getDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
