package cricbuzz;

public class BattingScoreUpdater implements ScoreUpdaterObserver {
    @Override
    public void update(Balls ballDetails) {
        int run = 0;

        if (RunType.ONE == ballDetails.runType) {
            run = 1;
        } else if (RunType.TWO == ballDetails.runType) {
            run = 2;
        } else if (RunType.FOUR == ballDetails.runType) {
            run = 4;
            ballDetails.playedBy.battingScoreCard.totalFours++;
        } else if (RunType.SIX == ballDetails.runType) {
            run = 6;
            ballDetails.playedBy.battingScoreCard.totalSixes++;
        }
        ballDetails.playedBy.battingScoreCard.totalRuns += run;

        ballDetails.playedBy.battingScoreCard.totalBallsPlayed++;

        if (ballDetails.wicket != null) {
            ballDetails.playedBy.battingScoreCard.wicketDetails = ballDetails.wicket;
        }
    }
}

