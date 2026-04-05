package cricbuzz;



import java.util.ArrayList;
import java.util.List;


public class Balls {

    int ballNumber;
    BallType type;
    RunType runType;
    Player playedBy;
    Player bowledBy;
    public Wicket wicket;
    List<ScoreUpdaterObserver> scoreUpdaterObserverList = new ArrayList<>();

    public Balls(int ballNumber) {
        this.ballNumber = ballNumber;
        scoreUpdaterObserverList.add(new BowlingScoreUpdater());
        scoreUpdaterObserverList.add(new BattingScoreUpdater());
    }

    public int getBallNumber() {
        return ballNumber;
    }

    public Player getBowledBy() {
        return bowledBy;
    }

    public Player getPlayedBy() {
        return playedBy;
    }

    public List<ScoreUpdaterObserver> getScoreUpdaterObserverList() {
        return scoreUpdaterObserverList;
    }

    public BallType getType() {
        return type;
    }

    public Wicket getWicket() {
        return wicket;
    }

    public void setBallNumber(int ballNumber) {
        this.ballNumber = ballNumber;
    }

    public void setBowledBy(Player bowledBy) {
        this.bowledBy = bowledBy;
    }

    public void setPlayedBy(Player playedBy) {
        this.playedBy = playedBy;
    }

    public void setRunType(RunType runType) {
        this.runType = runType;
    }

    public void setScoreUpdaterObserverList(List<ScoreUpdaterObserver> scoreUpdaterObserverList) {
        this.scoreUpdaterObserverList = scoreUpdaterObserverList;
    }

    public void setType(BallType type) {
        this.type = type;
    }

    public void setWicket(Wicket wicket) {
        this.wicket = wicket;
    }

    public void startBallDelivery(Team battingTeam, Team bowlingTeam, Overs over) {

        playedBy = battingTeam.getStriker();
        this.bowledBy = over.bowledBy;
        //THROW BALL AND GET THE BALL TYPE, assuming here that ball type is always NORMAL
        type = BallType.NORMAL;

        //wicket or no wicket
        if (isWicketTaken()) {
            runType = RunType.ZERO;
            //considering only BOLD
            wicket = new Wicket(WicketType.BOLD, bowlingTeam.getCurrentBowler(), over,this);
            //making only striker out for now
            battingTeam.setStriker(null);
        } else {
            runType = getRunType();

            if(runType == RunType.ONE || runType == RunType.THREE) {
                //swap striket and non striker
                Player temp = battingTeam.getStriker();
                battingTeam.setStriker(battingTeam.getNonStriker());
                battingTeam.setNonStriker(temp);
            }
        }

        //update player scoreboard
        notifyUpdaters(this);
    }

    private void notifyUpdaters(Balls Balls){

        for(ScoreUpdaterObserver observer : scoreUpdaterObserverList) {
            observer.update(Balls);
        }
    }

    private RunType getRunType() {

        double val = Math.random();
        if (val <= 0.2) {
            return RunType.ONE;
        } else if (val >= 0.3 && val <= 0.5) {
            return RunType.TWO;
        } else if (val >= 0.6 && val <= 0.8) {
            return RunType.FOUR;
        } else {
            return RunType.SIX;
        }
    }

    private boolean isWicketTaken() {
        //random function return value between 0 and 1
        if (Math.random() < 0.2) {
            return true;
        } else {
            return false;
        }
    }

}
