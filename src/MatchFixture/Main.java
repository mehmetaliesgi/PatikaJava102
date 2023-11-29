package MatchFixture;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        CreateFixture cFixture = new CreateFixture();
        LinkedList<String> teams = cFixture.createTeams(5);
        cFixture.createFixture(teams);
    }
}
