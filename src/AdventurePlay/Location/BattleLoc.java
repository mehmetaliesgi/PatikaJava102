package AdventurePlay.Location;

import AdventurePlay.Player;

import java.util.Random;

public abstract class BattleLoc extends Location {
    private Monster monster;
    private String award;
    private int maxMonster;
    public BattleLoc(Player player, String name, int id, String description, Monster monster, String award, int maxMonster) {
        super(player, name, id, description);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }
    @Override
    public boolean onLocation() {
        int monsterNum = randomMonsterNumber();
        System.out.println("Şuan buradasınız: " + this.getName());
        System.out.println("Dikkatli olun! Burada " + monsterNum + " tane " + this.getMonster().getName() + " yaşıyor!");
        System.out.print("<S>avaş veya <K>aç: ");
        String selectBattleCase = scanner.next();
        selectBattleCase = selectBattleCase.toUpperCase();
        if (selectBattleCase.equals("S")) {
            System.out.println("Savaş işlemleri olacak.");
            //Savaşma işlemi
        }
        else {

        }
        return true;
    }

    public int randomMonsterNumber() {
        Random random = new Random();
        return random.nextInt(this.maxMonster) + 1;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }
}
