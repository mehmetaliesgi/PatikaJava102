package AdventurePlay;

import AdventurePlay.Location.*;

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
        Location[] gameMaps = {new SafeHouse(player), new ToolStore(player), new Cave(player), new Forest(player), new River(player)};
        while (true) {
            player.printPlayerInfo();
            System.out.println();
            System.out.println("################## Bölgeler ################## ");
            System.out.println();
            for (Location map : gameMaps) {
                if (map.getId() > 2) {
                    System.out.println(map.getId() + " - " + map.getName() +  " --> " + map.getDescription() + " Ödül --> " + map.getAward().toUpperCase());
                }
                else {
                    System.out.println(map.getId() + " - " + map.getName() +  " --> " + map.getDescription());
                }
            }
            System.out.println("0 - Çıkış Yap --> Oyunu sonlandır.");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selectLoc = scanner.nextInt();

            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz.");
            }

            if (location == null) {
                System.out.println("Oyun bitti. Görüşmek üzere!");
                break;
            }
            if(!location.onLocation())
            {
                System.out.println("GAME OVER");
                break;
            }
        }

    }
}
