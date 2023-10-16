package AdventurePlay;

import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int money;
    private String charName;
    private String name;
    private GameCharacter gameCharacter;

    private Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
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
        System.out.println("Karakter: " + this.getName());
        System.out.println("Hasar\t: " + this.getDamage());
        System.out.println("Sağlık\t: " + this.getHealth());
        System.out.println("Para\t: " + this.getMoney());
        System.out.println("--------------------------------------------------------------------------------");
    }

    public void initPlayer(GameCharacter gameCharacter) {
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealth());
        this.setMoney(gameCharacter.getMoney());
        this.setName(gameCharacter.getName());
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
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
