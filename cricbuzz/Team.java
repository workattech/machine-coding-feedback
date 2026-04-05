package cricbuzz;


import java.util.List;
import java.util.Queue;



public class Team {

    String name;
    Queue<Player> players;
    List<Player> extraPlayers;
    PlayerBattingController battingController;
    PlayerBowlingController bowlingController;
    public boolean isWinner;
    public Team(String teamName, Queue<Player> playing11, List<Player> bench, List<Player> bowlers){
        this.name = teamName;
        this.players = playing11;
        this.extraPlayers = bench;
        battingController = new PlayerBattingController(playing11);
        bowlingController = new PlayerBowlingController(bowlers);
    }

    public String getTeamName() {
        return name;
    }

    public void chooseNextBatsMan() throws Exception{
        battingController.getNextPlayer();
    }

    public void chooseNextBowler(int maxOverCountPerBowler){
        bowlingController.getNextBowler(maxOverCountPerBowler);
    }

    public Player getStriker() {
        return battingController.getStriker();
    }

    public Player getNonStriker() {
        return battingController.getNonStriker();
    }

    public void setStriker(Player player) {
        battingController.setStriker(player);
    }

    public void setNonStriker(Player player) {
        battingController.setNonStriker(player);
    }

    public Player getCurrentBowler() {
        return bowlingController.getCurrentBowler();
    }

    public void printBattingScoreCard(){

        for(Player Player : players){
            Player.printBattingScoreCard();
        }
    }

    public void printBowlingScoreCard(){

        for(Player Player : players){
            if(Player.bowlingScoreCard.totalOversDelivered > 0) {
                Player.printBowlingScoreCard();
            }
        }
    }

    public int getTotalRuns(){
        int totalRun=0;
        for (Player player :  players){

            totalRun+=player.battingScoreCard.totalRuns;
        }
        return totalRun;
    }
}
