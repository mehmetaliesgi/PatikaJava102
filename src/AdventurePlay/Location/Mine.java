package AdventurePlay.Location;

import AdventurePlay.Player;

public class Mine extends BattleLoc{
    public Mine(Player player) {
        super(player, "Maden", 6, "Burası maden. Dikkatli ol burada Yılan yaşıyor.", new Snake(), "Rastgele bir ödül", 5);
    }
}
