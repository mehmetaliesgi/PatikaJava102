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
        if (selectBattleCase.equals("S") && combat(monsterNum)) {
            System.out.println(this.getName() + " tüm düşmanları yendiniz.");
            return true;
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("Öldünüz !!");
            return false;
        }
        return true;
    }

    public boolean combat(int monsterNum) {
        for (int i = 1; i <= monsterNum; i++) {
            this.getMonster().setHealth(this.getMonster().getOrjinalHealth());
            playerStats();
            monsterStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                System.out.println("<V>ur veya <K>aç");
                String selectCombat = scanner.next().toUpperCase();
                if (selectCombat.equals("V")) {
                    System.out.println("Siz vurdunuz !");
                    this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().totalDamage());
                    afterHit();
                    if (this.getMonster().getHealth() > 0) {
                        System.out.println();
                        System.out.println(this.getMonster().getName() + " size vurdu !");
                        int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (monsterDamage < 0) {
                            monsterDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                        afterHit();
                    }
                } else {
                    return false;
                }
            }
            if (this.getMonster().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("Düşmanı Yendiniz !!");
                System.out.println(this.getMonster().getAward() + " para kazandınız !!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
                System.out.println("Güncel Paranız : " + this.getPlayer().getMoney());
            } else {
                return false;
            }
        }
        return false;
    }

    public void playerStats() {
        System.out.println("Oyuncu Değerleri: " +
                "\n------------------------------------------" +
                "\nSağlık : " + this.getPlayer().getHealth() +
                "\nHasar : " + this.getPlayer().totalDamage() +
                "\nSilah : " + this.getPlayer().getInventory().getWeapon().getName() +
                "\nZırh : " + this.getPlayer().getInventory().getArmor().getArmorName() +
                "\nBlocklama : " + this.getPlayer().getInventory().getArmor().getBlock() +
                "\nPara : " + this.getPlayer().getMoney() + "\n");
    }

    public void afterHit() {
        System.out.println("Canınız: " + this.getPlayer().getHealth() +
                "\n" + this.getMonster().getName() + " Canı : " + this.getMonster().getHealth() + "\n");
    }

    public void monsterStats(int i) {
        System.out.println(i + ". " + this.getMonster().getName() + " Değerleri: " +
                "\n------------------------------------------" +
                "\nSağlık : " + this.getMonster().getHealth() +
                "\nHasar : " + this.getMonster().getDamage() +
                "\nÖdül : " + this.getMonster().getAward() + "\n");
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
