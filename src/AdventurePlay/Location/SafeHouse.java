package AdventurePlay.Location;

import AdventurePlay.Player;

public class SafeHouse extends NormalLoc {
    public SafeHouse(Player player) {
        super(player, "Güvenli Ev", 1, "Burası güvenli bir ev, düşman yok.");
    }
    public boolean onLocation() {
        System.out.println("Güvenli Evdesiniz.");
        System.out.println("Canınız yenilendi.");
        return true;
    }
}
