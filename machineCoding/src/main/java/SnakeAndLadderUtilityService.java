public class SnakeAndLadderUtilityService {

    int[] board = new int[101];

    public boolean checkIfNewTileContainsSnakeAndUpdatePosition(int[][] snakesStartAndEnd,int newPosition,Player player){
        for(int i=0;i<snakesStartAndEnd.length;i++)
            if(snakesStartAndEnd[i][0]==newPosition){
                player.updatePosition(snakesStartAndEnd[i][1]);
                return true;
        }
        return false;
    }

    public boolean checkIfNewTileContainsLadderAndUpdatePosition(int[][] laddersStartAndEnd,int newPosition,Player player){
        for(int i=0;i<laddersStartAndEnd.length;i++)
            if(laddersStartAndEnd[i][0]==newPosition){
                player.updatePosition(laddersStartAndEnd[i][1]);
                return true;
            }
        return false;
    }

    public boolean startGameUtil(int[][] snakesStartAndEnd, int[][] laddersStartAndEnd, Player player, int diceRollOutput) {

        int tentativeCurrentPosition = player.current_position + diceRollOutput;
        if (tentativeCurrentPosition > 100) {
            System.out.println("Player "+player.getName()+" did not move");
            return false;
        }
        if(tentativeCurrentPosition==100){
            player.updatePosition(100);
            return true;
        }
        boolean gotSnake=checkIfNewTileContainsSnakeAndUpdatePosition(snakesStartAndEnd,tentativeCurrentPosition,player);
        boolean gotLadder=checkIfNewTileContainsLadderAndUpdatePosition(laddersStartAndEnd,tentativeCurrentPosition,player);

        if(!gotSnake && !gotLadder)
            player.updatePosition(tentativeCurrentPosition);

        return false;
    }
}
