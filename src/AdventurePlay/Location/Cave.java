package AdventurePlay.Location;

import AdventurePlay.Player;

public class Cave extends BattleLoc{
    public Cave(Player player) {
        super(player, "Cave", 3, "Mağaraya Gir. Dikkatli ol Zombie vardır.", new Zombie(), "food",3);
    }
}
