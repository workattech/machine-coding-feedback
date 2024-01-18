package board;

import players.Peice;

public class Board {
	private Snake[] snakes;
    private Ladder[] ladders;
    
    public Board(int[][] snakelist, int[][] ladderlist){
        snakes = new Snake[snakelist.length];
        for(int i = 0; i<snakelist.length; i+=1){
            snakes[i] = new Snake(snakelist[i][0], snakelist[i][1]);
        }

        ladders = new Ladder[ladderlist.length];
        for(int i = 0; i<ladderlist.length; i+=1){
            ladders[i] = new Ladder(ladderlist[i][0], ladderlist[i][1]);
        }
    }

    public void checkSnake(Peice peice){
        for(int i = 0; i < snakes.length; i+=1){
            if(peice.getPos() == snakes[i].gethead()){
                peice.setPos(snakes[i].bite());
                checkSnake(peice);
                checkLadder(peice);
            }
        }
    }

    public void checkLadder(Peice peice){
        for(int i = 0; i < ladders.length; i+=1){
            if(peice.getPos() == ladders[i].getstart()){
                peice.setPos(ladders[i].elevate());
                checkSnake(peice);
                checkLadder(peice);
            }
        }
    }
}
