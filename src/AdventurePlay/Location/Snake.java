package AdventurePlay.Location;

import java.util.Random;

public class Snake extends Monster{
    private static Random random = new Random();
    public Snake() {
        super("Snake", 4, random.nextInt(4) + 3, 12, 12, 0);
    }
}
