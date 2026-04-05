package cricbuzz;

public class BowlingScoreUpdater implements ScoreUpdaterObserver {
    @Override
    public void update(Balls Balls) {

        if (Balls.ballNumber == 6 && Balls.type == BallType.NORMAL) {
            Balls.bowledBy.bowlingScoreCard.totalOversDelivered++;
        }

        if (RunType.ONE == Balls.runType) {
            Balls.bowledBy.bowlingScoreCard.runsGiven += 1;
        } else if (RunType.TWO == Balls.runType) {
            Balls.bowledBy.bowlingScoreCard.runsGiven += 2;
        } else if (RunType.FOUR == Balls.runType) {
            Balls.bowledBy.bowlingScoreCard.runsGiven += 4;
        } else if (RunType.SIX == Balls.runType) {
            Balls.bowledBy.bowlingScoreCard.runsGiven += 6;
        }

        if (Balls.wicket != null) {
            Balls.bowledBy.bowlingScoreCard.wicketsTaken++;
        }

        if (Balls.type == BallType.NO_BALL) {
            Balls.bowledBy.bowlingScoreCard.noBallCount++;
        }

        if (Balls.type == BallType.WIDE_BALL) {
            Balls.bowledBy.bowlingScoreCard.wideBalls++;
        }
    }
}
