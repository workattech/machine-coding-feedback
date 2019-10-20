import java.util.ArrayList;
import java.util.List;

public class SnakeAndLadderService {
    private SnakeAndLadderBoard board;
    private List<User> users;

    private int winPosition;
    private int diceCount;
    private int diceMaxValue;
    private static final int DEFAULT_DICE_MAX_VALUE = 6;
    private static final int DEFAULT_DICE_COUNT = 1;

    public SnakeAndLadderService(SnakeAndLadderBoard board, List<User> users) {
        this.board = board;
        this.users = users;
        this.winPosition = board.getSize();
        this.diceMaxValue = DEFAULT_DICE_MAX_VALUE;
        this.diceCount = DEFAULT_DICE_COUNT;
    }

    public void setDiceMaxValue(int diceMaxValue) {
        this.diceMaxValue = diceMaxValue;
    }

    public void setDiceCount(int diceCount) {
        this.diceCount = diceCount;
    }

    public void run() {
        DiceService diceService = new DiceService(diceMaxValue);
        while(true) {
            List<User> usersCurrent = new ArrayList<>();
            for(User user: users) {
                int valueAfterDiceRolls = 0;
                for(int i = 0; i < diceCount; i++)
                    valueAfterDiceRolls += diceService.run();

                user = setNewPosition(user, valueAfterDiceRolls);
                if(isWinner(user))
                    return;
                usersCurrent.add(user);
            }
            users = usersCurrent;
        }
    }

    private boolean validatePosition(int position) {
        if(position > board.getSize())
            return false;
        return true;
    }
    private User setNewPosition(User user, int valueAfterDicRolls) {
        int newPosition;
        int currentPosition = user.getPosition() + valueAfterDicRolls;

        if (!validatePosition(currentPosition))
            return user;

        do {
             newPosition = currentPosition;
             for(Snake snake: board.getSnakes()) {
                 if(snake.getStart() == currentPosition) {
                     currentPosition = snake.getEnd();
                 }
             }
             for(Ladder ladder: board.getLadders()) {
                 if(ladder.getStart() == currentPosition) {
                     currentPosition = ladder.getEnd();
                 }
             }

        } while(newPosition!=currentPosition);

        System.out.println(user.getName() + " rolled a " + valueAfterDicRolls + " and moved from " + user.getPosition() + " to " + newPosition);
        user.setPosition(newPosition);
        return user;
    }

    private boolean isWinner(User user) {
        if(user.getPosition() == winPosition) {
            System.out.println(user.getName() + " wins the game");
            return true;
        }
        return false;
    }
}
