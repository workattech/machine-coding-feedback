package src.snake_and_ladder;

public class GameConfig {
    private static GameConfig instance;
    private int boardSize;
    
    public GameConfig() {}

    public static GameConfig getInstance(){
        if(instance == null){
            instance = new GameConfig();
        }
        return instance;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

}
