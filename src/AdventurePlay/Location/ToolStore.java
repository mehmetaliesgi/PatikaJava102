package AdventurePlay.Location;

import AdventurePlay.Player;

public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Mağaza", 2, "Silah ve zırh satın alabilirsiniz.");
    }

    public boolean onLocation() {
        System.out.println("----- Mağazaya hoş geldiniz! -----");
        System.out.println("1 - Silahlar");
        System.out.println("2 - Zırhlar");
        System.out.println("3 - Çıkış Yap");
        System.out.print("Seçiminiz: ");

        int selectCase = scanner.nextInt();

        while (selectCase > 3 || selectCase < 1) {
            System.out.print("Geçersiz bir değer girdiniz, geçerli bir değer giriniz: ");
            selectCase = scanner.nextInt();
        }
        switch (selectCase) {
            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmor();
                buyArmor();
                break;
            case 3:
                System.out.println("Bir daha bekleriz!");
                return true;
        }
        return true;
    }
    public void printWeapon() {
        System.out.println(" ---------- Silahlar ----------");
        for (Weapon weapon : Weapon.weapons()) {
            System.out.println(weapon.getId() + " - " + weapon.getName() + " < Para : " + weapon.getPrice() + ", Hasar : " + weapon.getDamage() + " >");
        }
    }

    public void buyWeapon() {
        System.out.print("Bir silah seçiniz: ");
        int selectWeaponID = scanner.nextInt();

        while (selectWeaponID > Weapon.weapons().length || selectWeaponID < 1) {
            System.out.print("Geçersiz bir değer girdiniz, geçerli bir değer giriniz: ");
            selectWeaponID = scanner.nextInt();
        }
        Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);

        if(selectedWeapon != null) {
            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Yeterli paranız yok.");
            }
            else {
                System.out.println(selectedWeapon.getName() + " silahını satın aldınız.");
                int balace = getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balace);
                System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                //System.out.println("Önceki Silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                //System.out.println("Şuan ki silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
            }
        }
    }
    public void printArmor() {
        System.out.println(" ---------- Zırhlar ----------");
        for (Armor armor : Armor.armors()) {
            System.out.println(armor.getId() + " - " + armor.getArmorName() + " < Para : " + armor.getArmorPrice() + ", Defans : " + armor.getArmorDefence() + " >");
        }
    }
    public void buyArmor() {
        System.out.print("Bir zırh seçiniz: ");
        int selectArmorID = scanner.nextInt();

        while (selectArmorID < 1 || selectArmorID > Armor.armors().length) {
            System.out.print("Hatalı bir seçim yaptınız. Tekrar deneyiniz.");
            selectArmorID = scanner.nextInt();
        }
        Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);

        if (selectedArmor != null) {
            if (selectedArmor.getArmorPrice() > this.getPlayer().getMoney()) {
                System.out.println("Paranız yetersiz.");
            }
            else {
                System.out.println(selectedArmor.getArmorName() + " zırhını aldınız.");
                int balace = getPlayer().getMoney() - selectedArmor.getArmorPrice();
                this.getPlayer().setMoney(balace);
                System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                //System.out.println("Önceki Zırhınız: " + this.getPlayer().getInventory().getArmor().getArmorName());
                this.getPlayer().getInventory().setArmor(selectedArmor);
                //System.out.println("Şuan ki Zırhınız: " + this.getPlayer().getInventory().getArmor().getArmorName());
            }
        }
    }
}
