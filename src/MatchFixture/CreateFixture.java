package MatchFixture;

import javax.swing.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class CreateFixture {
    public LinkedList createTeams(int teamsCount) {
        LinkedList<String> teams = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        if (teamsCount > 0) {
            for (int i = 0; i < teamsCount; i++) {
                System.out.print("Lütfen " + (i+1) +". takımı giriniz: ");
                String team = scanner.next();
                teams.add(team);
            }
        } else {
            System.out.println("Takım sayısı negatif veya 0 olamaz!!!");
            System.out.print("Lütfen yeni bir değer giriniz: ");
            createTeams(scanner.nextInt());
        }

        if(teamsCount % 2 != 0) {
            teams.add(null);
        }

        Collections.shuffle(teams);

        return teams;
    }

    public void createFixture(LinkedList teams) {

        int matchNum = teams.size() * (teams.size() -1);
        int roundNum = matchNum / (teams.size() / 2);
        int matchPerRound = teams.size() / 2;

        String[] host = new String[matchNum / 2];
        String[] away = new String[matchNum / 2];

        //[B, A, D, C]
        //[B, C, A, D]
        //[B, D, C, A]
        //[B, A, D, C]
        /*System.out.println("***********************");
        System.out.println(teams);
        System.out.println("***********************");*/
        for (int i = 0, a = 0; i < teams.size() - 1; i++) {
            for (int j = 0; j < teams.size() / 2 ; j++) {
                if (teams.get(j) != null && teams.get(teams.size() - 1 - j) != null) {
                    host[a] = teams.get(j).toString();
                    away[a] = teams.get(teams.size() - 1 - j).toString();
                    /*System.out.println("HOSTA -> "+host[a] + " AWAYA -> "+away[a] + " TEAAMS_SIZE ->" + teams.size());*/
                } else if (teams.get(j) != null && teams.get(teams.size() - 1 - j) == null) {
                    host[a] = teams.get(j).toString();;
                    away[a] = "BAY";
                }
                else if (teams.get(j) == null && teams.get(teams.size() - 1 - j) != null) {
                    host[a] = "BAY";
                    away[a] = teams.get(teams.size() - 1 - j).toString();
                }
                a++;
            }

            Collections.rotate(teams.subList(1, teams.size()), 1);
            /*System.out.println("---------");
            System.out.println(teams);
            System.out.println("---------");*/
        }

        for (int i = 0, a = 0, b = 0; i < roundNum / 2; ) {
            System.out.println("\n" + (++i) + ". Round");
            for (int j = 0; j < matchPerRound; j++, a++) {
                System.out.println(host[a] + " vs " + away[a]);
            }
        }
        for (int i = roundNum / 2, b = 0; i < roundNum; ) {
            System.out.println("\n" + (++i) + ". Round");
            for (int j = 0; j < matchPerRound; j++, b++){
                    System.out.println(away[b] + " vs " + host[b]);
            }
        }
    }
}
