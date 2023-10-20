package AdventurePlay.Location;

import AdventurePlay.Player;

import java.util.Scanner;

public abstract class Location {
    private Player player;
    private String name, description;
    private int id;
    public static Scanner scanner = new Scanner(System.in);
    public Location(Player player, String name, int id, String description) {
        this.player = player;
        this.name = name;
        this.id = id;
        this.description = description;
    }

    public abstract boolean onLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
