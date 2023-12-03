package Examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CreateFixture {
    public CreateFixture() {

    }
    public ArrayList createTeams() {
        ArrayList<String> teams = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lütfen takım sayısını giriniz: ");
        int teamCount = scanner.nextInt();
        System.out.println();

        if (teamCount > 0) {
            for (int i = 0; i < teamCount; i++) {
                System.out.print("Lütfen " + (i +1) +  ". Takımın İsmini Giriniz: ");
                teams.add(scanner.next());
            }
        } else {
            System.out.println("Takım sayısı negatif veya 0 olamaz!!!");
            System.out.print("Lütfen yeni bir değer giriniz: ");
            createTeams();
        }

        if (teamCount % 2 != 0) {
            teams.add(null);
        }

        System.out.println(teams);

        Collections.shuffle(teams);

        System.out.println(teams);

        return teams;
    }

    public void createFixture(ArrayList teams) {
        int toplamTakim = teams.size();
        int macSayisi = toplamTakim * (toplamTakim - 1);
        int haftadakiMacSayisi = toplamTakim / 2;
        int karsilasmaSayisi = (toplamTakim - 1) * 2;

        System.out.println("Takım Sayısı: " + toplamTakim +
                "\nLigdeki Maç Sayısı: " + macSayisi +
                "\nBir Haftada Oynanacak Maç Sayısı: " + haftadakiMacSayisi +
                "\nSezondaki Toplam Hafta Sayısı: " + karsilasmaSayisi
        );

        String[] home = new String[macSayisi / 2];
        String[] away = new String[macSayisi / 2];
        ArrayList<String> tempTeams = teams;

        for (int i = 0; i < toplamTakim; i++) {
            for (int j = 1; j < toplamTakim; j++) {
                home[i+j] = teams.get(i).toString();
                away[j+i] = teams.get(j).toString();
            }
            if (i < toplamTakim - 1) {
                String s = teams.get(i).toString();
                System.out.println("S: " +s);
                teams.set(i, teams.get(i + 1));
                System.out.println("get(i): "+teams.get(i));
                teams.set(i+1, s);
                System.out.println("get i+1: " + teams.get(i+1));
            }
        }

        for (int i = 0, a = 0; i < macSayisi / 2; ) {
            System.out.println("\n" + (++i) + ". Round");
            for (int j = 0; j < haftadakiMacSayisi; j++, a++) {
                System.out.println(home[a] + " vs " + away[a]);
            }
        }
        for (int i = macSayisi / 2, b = 0; i < macSayisi; ) {
            System.out.println("\n" + (++i) + ". Round");
            for (int j = 0; j < haftadakiMacSayisi; j++, b++){
                System.out.println(away[b] + " vs " + home[b]);
            }
        }
    }

}

