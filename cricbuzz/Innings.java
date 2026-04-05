package cricbuzz;

import java.util.ArrayList;
import java.util.List;

public class Innings {

    Team battingTeam;
    Team bowlingTeam;
    MatchType matchType;
    List<Overs> Overss;
    public Innings(Team battingTeam, Team bowlingTeam, MatchType matchType) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.matchType = matchType;
        Overss = new ArrayList<>();
    }

    public void start(int runsToWin){

        //set batting players
        try {
            battingTeam.chooseNextBatsMan();
        }catch (Exception e) {

        }

        int noOfOverss = matchType.noOfOvers();
        for (int OversNumber = 1; OversNumber <= noOfOverss; OversNumber++) {

            //chooseBowler
            bowlingTeam.chooseNextBowler(matchType.maxOverCountBowlers());

            Overs Overs = new Overs(OversNumber, bowlingTeam.getCurrentBowler());
            Overss.add(Overs);
            try {
                boolean won = Overs.startOver(battingTeam, bowlingTeam, runsToWin);
                if(won == true) {
                    break;
                }
            }catch (Exception e) {
                break;
            }

            //swap striket and non striker
            Player temp = battingTeam.getStriker();
            battingTeam.setStriker(battingTeam.getNonStriker());
            battingTeam.setNonStriker(temp);
        }
    }

    public int getTotalRuns(){
        return battingTeam.getTotalRuns();
    }
}
