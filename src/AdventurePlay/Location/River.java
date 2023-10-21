package AdventurePlay.Location;

import AdventurePlay.Player;

public class River extends BattleLoc{
    public River(Player player) {
        super(player, "River", 5, "Burası nehir. Dikkatli ol burada Ayı yaşıyor.", new Bear(), "water", 2);
    }
}
