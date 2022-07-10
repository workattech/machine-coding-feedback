import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {
    private Board mBoard;
    private List<Player> mPlayers;
    private GameState gameState;
    private Dice mDice;

    GameController() {
        initGame();
    }

    private void initGame() {
        mBoard = new Board();
        Scanner scanner = new Scanner(System.in);
        int playerNum = scanner.nextInt();
        mPlayers = new ArrayList<>();
//        System.out.println("Players: " + playerNum);
        Scanner textScan = new Scanner(System.in);
        while (playerNum != 0) {
            String s = textScan.nextLine();
            mPlayers.add(new Player(s));
            --playerNum;
        }
        mDice = new Dice();
    }

    public void playGame() {
        gameState = GameState.STARTED;
        int turn = 0;
        while (gameState != GameState.FINISHED) {
            int diceVal = mDice.roll();
            int nextPos = mPlayers.get(turn).getPos() + diceVal;
            if(nextPos > 100) {
                nextPos -= diceVal;
            } else {
                nextPos = mBoard.getNextPos(mPlayers.get(turn).getPos() + diceVal);
            }
            System.out.println(mPlayers.get(turn).getName() + " rolled a " + diceVal + " and moved from " + mPlayers.get(turn).getPos() + " to " + nextPos);
            mPlayers.get(turn).setPos(nextPos);
            if(nextPos == 100) {
                System.out.println(mPlayers.get(turn).getName() + " wins the Game");
                gameState = GameState.FINISHED;
            } else {
                turn = (turn+1)% (mPlayers.size());
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
