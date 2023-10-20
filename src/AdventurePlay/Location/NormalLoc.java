package AdventurePlay.Location;

import AdventurePlay.Player;

public abstract class NormalLoc extends Location {
    public NormalLoc(Player player, String name, int id, String description) {
        super(player, name ,id, description);
    }
    @Override
    public boolean onLocation() {
        return true;
    }
}
