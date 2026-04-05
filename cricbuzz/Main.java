package cricbuzz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String args[]) {

        Main ob = new Main();

        Team teamA = ob.addTeam("India");
        Team teamB = ob.addTeam("SriLanka");

        MatchType matchType = new T20MatchType();
        Match match = new Match(teamA, teamB, null, "SMS STADIUM", matchType);
        match.startMatch();

    }

    private Team addTeam(String name) {

        Queue<Player> Player = new LinkedList<>();

        Player p1 = addPlayer(name + "1", PlayerType.ALLROUNDER);
        Player p2 = addPlayer(name + "2", PlayerType.ALLROUNDER);
        Player p3 = addPlayer(name + "3", PlayerType.ALLROUNDER);
        Player p4 = addPlayer(name + "4", PlayerType.ALLROUNDER);
        Player p5 = addPlayer(name + "5", PlayerType.ALLROUNDER);
        Player p6 = addPlayer(name + "6", PlayerType.ALLROUNDER);
        Player p7 = addPlayer(name + "7", PlayerType.ALLROUNDER);
        Player p8 = addPlayer(name + "8", PlayerType.ALLROUNDER);
        Player p9 = addPlayer(name + "9", PlayerType.ALLROUNDER);
        Player p10 = addPlayer(name + "10", PlayerType.ALLROUNDER);
        Player p11 = addPlayer(name + "11", PlayerType.ALLROUNDER);

        Player.add(p1);
        Player.add(p2);
        Player.add(p3);
        Player.add(p4);
        Player.add(p5);
        Player.add(p6);
        Player.add(p7);
        Player.add(p8);
        Player.add(p9);
        Player.add(p10);
        Player.add(p11);

        List<Player> bowlers = new ArrayList<>();
        bowlers.add(p8);
        bowlers.add(p9);
        bowlers.add(p10);
        bowlers.add(p11);

        Team team = new Team(name, Player, new ArrayList<>(), bowlers);
        return team;

    }

    private Player addPlayer(String name, PlayerType playerType) {

        Person person = new Person();
        person.name = name;
        Player Player = new Player(person, playerType);
        return Player;
    }
}
