package cricbuzz;



import java.util.ArrayList;
import java.util.List;


public class Overs {
    int overNumber;
    List<Balls> balls;
    int extraBallsCount;
    Player bowledBy;


    Overs(int overNumber, Player bowledBy){
        this.overNumber = overNumber;
        balls = new ArrayList<>();
        this.bowledBy = bowledBy;
    }

    public List<Balls> getBalls() {
        return balls;
    }

    public Player getBowledBy() {
        return bowledBy;
    }

    public int getExtraBallsCount() {
        return extraBallsCount;
    }

    public int getOverNumber() {
        return overNumber;
    }

    public void setBalls(List<Balls> balls) {
        this.balls = balls;
    }

    public void setBowledBy(Player bowledBy) {
        this.bowledBy = bowledBy;
    }

    public void setExtraBallsCount(int extraBallsCount) {
        this.extraBallsCount = extraBallsCount;
    }

    public void setOverNumber(int overNumber) {
        this.overNumber = overNumber;
    }

    public boolean startOver(Team battingTeam, Team bowlingTeam, int runsToWin) throws Exception{

        int ballCount = 1;
        while(ballCount<=6){

            Balls ball = new Balls(ballCount);
            ball.startBallDelivery(battingTeam, bowlingTeam, this);
            if(ball.type == BallType.NORMAL) {
                balls.add(ball);
                ballCount++;
                if(ball.wicket != null) {
                    battingTeam.chooseNextBatsMan();
                }

                if( runsToWin != -1 && battingTeam.getTotalRuns() >= runsToWin){
                    battingTeam.isWinner = true;
                    return true;
                }
            }
            else {
                extraBallsCount++;
            }
        }

        return false;
    }

}
