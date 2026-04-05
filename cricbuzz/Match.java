package cricbuzz;

import java.util.Date;

public class Match {
    Team teamA;
    Team teamB;
    Date date;
    String location;
    Innings[] innings;
    MatchType type;
    Team tossWon;

    public Match(Team teamA, Team teamB, Date matchDate, String venue, MatchType matchType) {

        this.teamA = teamA;
        this.teamB = teamB;
        this.date = matchDate;
        this.location = venue;
        this.type = matchType;
        innings = new Innings[2];
    }

    public void startMatch() {

        //1. Toss
        tossWon = toss(teamA, teamB);

        //start The Inning, there are 2 innings in a match
        for(int inning=1; inning<=2; inning++){

            Innings inningDetails;
            Team bowlingTeam;
            Team battingTeam;

            //assuming here that tossWon batFirst
            boolean isChasing = false;
            if(inning == 1){
                battingTeam = tossWon;
                bowlingTeam = tossWon.getTeamName().equals(teamA.getTeamName()) ? teamB : teamA;
                inningDetails = new Innings(battingTeam, bowlingTeam, type);
                inningDetails.start( -1);

            }else {
                bowlingTeam = tossWon;
                battingTeam = tossWon.getTeamName().equals(teamA.getTeamName()) ? teamB : teamA;
                inningDetails = new Innings(battingTeam, bowlingTeam, type);
                inningDetails.start(innings[0].getTotalRuns());
                if(bowlingTeam.getTotalRuns() > battingTeam.getTotalRuns()) {
                    bowlingTeam.isWinner = true;
                }
            }


            innings[inning-1] = inningDetails;

            //print inning details
            System.out.println();
            System.out.println("INNING " + inning + " -- total Run: " + battingTeam.getTotalRuns());
            System.out.println("---Batting ScoreCard : " + battingTeam.name + "---");

            battingTeam.printBattingScoreCard();

            System.out.println();
            System.out.println("---Bowling ScoreCard : " + bowlingTeam.name + "---");
            bowlingTeam.printBowlingScoreCard();

        }

        System.out.println();
        if(teamA.isWinner){
            System.out.println("---WINNER---" + teamA.name);

        }else {
            System.out.println("---WINNER---" + teamB.name);

        }

    }

    private Team toss(Team teamA, Team teamB){
        //random function return value between 0 and 1
        if(Math.random() < 0.5) {
            return teamA;
        } else {
            return teamB;
        }
    }
}
