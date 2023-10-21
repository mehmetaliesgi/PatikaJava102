package AdventurePlay.Location;

import AdventurePlay.Player;

public class Forest extends BattleLoc{
    public Forest(Player player) {
        super(player, "Forest", 4, "Burası orman. Dikkatli ol burada Vampir yaşıyor!", new Vampire(), "firewood", 3);
    }
}
