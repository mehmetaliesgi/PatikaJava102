package AdventurePlay;

import AdventurePlay.GameCharacter.Archer;
import AdventurePlay.GameCharacter.GameCharacter;
import AdventurePlay.GameCharacter.Knight;
import AdventurePlay.GameCharacter.Samurai;
import AdventurePlay.Location.Location;
import AdventurePlay.Location.SafeHouse;
import AdventurePlay.Location.ToolStore;

import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);
    public void start() {
        System.out.println("Macera oyununa hoş geldiniz!!");
        System.out.print("Lütfen bir isim giriniz: ");
        String playerName = scanner.next();

        Player player = new Player(playerName);
        System.out.println("Sayın " + player.getName() + " Hoşgeldiniz!!");
        System.out.println("Lütfen oyuna başlamak için bir karakter seçiniz: ");
        player.selectChar();

        Location location = null;
        Location[] gameMaps = {new SafeHouse(player), new ToolStore(player)};
        while (true) {
            player.printPlayerInfo();
            System.out.println();
            System.out.println("################## Bölgeler ################## ");
            System.out.println();
            for (Location map : gameMaps) {
                System.out.println(map.getId() + " - " + map.getName() +  " --> " + map.getDescription());
            }
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selectLoc = scanner.nextInt();

            switch (selectLoc) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }

            if(!location.onLocation())
            {
                System.out.println("GAME OVER");
                break;
            }
        }

    }
}
