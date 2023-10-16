package AdventurePlay;

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
    }
}
