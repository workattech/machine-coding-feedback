package org.main;

public class SnakeAndLadderGameBoardPlay implements GamePlay {
    private SnakeAndLadderGameBoard snakeAndLadderGameBoard;
    private SnakeAndLadderGamePlayers snakeAndLadderGamePlayers;

    public SnakeAndLadderGameBoardPlay(SnakeAndLadderGameBoard snakeAndLadderGameBoard, SnakeAndLadderGamePlayers snakeAndLadderGamePlayers) {
        this.snakeAndLadderGameBoard = snakeAndLadderGameBoard;
        this.snakeAndLadderGamePlayers = snakeAndLadderGamePlayers;
    }

    public void updatePlayersGameStart() {
        for (Player player : snakeAndLadderGamePlayers.getPlayers()) {
            player.setPlayerStatus(PlayerStatus.PLAYING);
            player.setPlayerStatus(PlayerStatus.PLAYING);
        }
    }

    public boolean stopGame () {
        if ((snakeAndLadderGamePlayers.getPlayers().size() - snakeAndLadderGamePlayers.getNumOfPlayersWon()) == 1) {
            return true;
        }
        return false;
    }

    public void StartGame() throws InterruptedException {
        Integer diceVal;
        Integer consecutiveMaxDiceRollCount = 0;
        updatePlayersGameStart();

        while (!(stopGame())) {
            for (Player player : snakeAndLadderGamePlayers.getPlayers()) {
                consecutiveMaxDiceRollCount = 0;
                if (stopGame()) {
                    break;
                }
                if (player.getPlayerStatus() == PlayerStatus.WON) {
                    continue;
                }

                //First Roll
                diceVal = snakeAndLadderGameBoard.getDice().rollDice();

                //Consecutive Dice Rolls
                if (diceVal == snakeAndLadderGameBoard.getDice().getMaxDiceRollValue()) {
                    do {
                        consecutiveMaxDiceRollCount++;
                        System.out.println(player.getName()+" Rolled a "+snakeAndLadderGameBoard.getDice().getMaxDiceRollValue()+" will get another chance ,Currently Chance num "+ consecutiveMaxDiceRollCount);
                        movePlayerOnBoard(diceVal, player, MovementCause.DICE);
                        diceVal = snakeAndLadderGameBoard.getDice().rollDice();
                    } while (diceVal == snakeAndLadderGameBoard.getDice().getMaxDiceRollValue() && consecutiveMaxDiceRollCount<3);
                }

                if (consecutiveMaxDiceRollCount == 3 && diceVal == snakeAndLadderGameBoard.getDice().getMaxDiceRollValue()) {
                    revertMovesOfPlayerOnBoard(player);
                } else {
                    movePlayerOnBoard(diceVal, player, MovementCause.DICE);
                }
            }
        }
    }

    public void revertMovesOfPlayerOnBoard(Player player) {
        System.out.println(player.getName()+ " Rolled more than 4 times consecutively "+ snakeAndLadderGameBoard.getDice().getMaxDiceRollValue()+" So we are cancelling all his moves ");
        PlayerMove lastMove;
        int i = 3;

        while (i>0) {
            lastMove = player.getMoves().removeLast();
            System.out.println(player.getName()+ " movement reverted from "+ lastMove.getFinalPosition() +" to "+lastMove.getInitialPosition());
            player.setCurPosition(lastMove.getInitialPosition());
            i--;
        }

    }

    public void printMove(Integer newPos, Player player, MovementCause cause) {
        if (newPos > snakeAndLadderGameBoard.getBoardSize()) {
            System.out.println(player.getName()+" Is trying to move to "+ newPos +" which is out of boundary of the board of size "+ snakeAndLadderGameBoard.getBoardSize());
        }

        if (cause == MovementCause.DICE) {
            int diceVal = newPos - player.getCurPosition();
            System.out.println(player.getName()+ " rolled a "+diceVal+" and Moved From "+player.getCurPosition()+ " to "+newPos);
        } else {
            System.out.println(player.getName()+" "+cause.getDescription()+" and Moved From "+player.getCurPosition()+ " to "+newPos);
        }
    }

    public void updatePlayer(Integer newPos, Player player, MovementCause cause) {
        printMove(newPos, player, cause);
        if (newPos <= snakeAndLadderGameBoard.getBoardSize()) {
            player.getMoves().add(new PlayerMove(player.getCurPosition(), newPos, cause));
            if (newPos == snakeAndLadderGameBoard.getBoardSize()) {
                player.setPlayerStatus(PlayerStatus.WON);
                System.out.println(player.getName()+" Reached "+snakeAndLadderGameBoard.getBoardSize()+" won!! ");
                snakeAndLadderGamePlayers.getPlayersWon().add(player);
            }
            player.setCurPosition(newPos);
        }
    }

    public void movePlayerOnBoard(Integer diceVal, Player player, MovementCause cause) {
        Integer newPos;
        if (cause == MovementCause.DICE) {
            newPos = player.getCurPosition() + diceVal;
        } else {
            newPos = diceVal;
        }
        updatePlayer(newPos, player, cause);
        if (snakeAndLadderGameBoard.caughtBySnake(newPos)!=-1) {
            newPos = snakeAndLadderGameBoard.caughtBySnake(newPos);
            movePlayerOnBoard(newPos, player, MovementCause.SNAKE_BITE);
        } else if (snakeAndLadderGameBoard.gotLadder(newPos)!=-1) {
            newPos = snakeAndLadderGameBoard.gotLadder(newPos);
            movePlayerOnBoard(newPos, player, MovementCause.GOT_LADDER);
        }
    }
}
