package snakeandladder.model;

import java.util.*;

public class Board {
    List<Player> playerList;
    Map<Integer,Snake> snakeMap;//=new HashMap<>();
    Map<Integer,Ladder> ladderMap;//=new HashMap<>();
    int boardSize;
    public Board(List<Player> playerList, Map<Integer,Snake> snakeMap, Map<Integer, Ladder> ladderMap,int boardSize) {
        this.playerList = playerList;
        this.snakeMap = snakeMap;
        this.ladderMap = ladderMap;
        this.boardSize =boardSize;
    }
    void checkSnakesAndUpdatePosition(Player player){
        while(snakeMap.get(player.getPosition())!=null){
            player.setPosition(snakeMap.get(player.getPosition()).getTail());
        }
    }
    void checkLaddersAndUpdatePosition(Player player){
        while(ladderMap.get(player.getPosition())!=null){
            player.setPosition(ladderMap.get(player.getPosition()).getEnd());
        }
    }
    void setFinalPosition(Player player){
        int initialPosition=player.getPosition();
        int numberOfDice=1;//case of multiple dice
        int diceSum=0;
        for(int i=0;i<numberOfDice;i++){
            Dice d = new Dice();
            diceSum+=d.getDiceRoll();
        }
        int finalPosition=initialPosition+diceSum;
        if(finalPosition>100){
            finalPosition=initialPosition;
            System.out.println(player.getName()+" rolled a "+diceSum+" and moved from "+initialPosition+" to "+player.getPosition());
        }else{
            player.setPosition(finalPosition);
            checkSnakesAndUpdatePosition(player);
            checkLaddersAndUpdatePosition(player);
            System.out.println(player.getName()+" rolled a "+diceSum+" and moved from "+initialPosition+" to "+player.getPosition());
        }
    }
    
    public void startGame(){
        int numberOfCurrentPlayersPlaying= playerList.size();
        while (numberOfCurrentPlayersPlaying>1){
            for(Player player: playerList){
                if(!player.checkHasWon()){
                    setFinalPosition(player);
                    if(player.getPosition()== boardSize){
                        numberOfCurrentPlayersPlaying--;
                        System.out.println(player.getName()+" wins the game");
                        player.hasWon =true;
                        if(numberOfCurrentPlayersPlaying<2)return;
                    }
                }
            }
        }

    }
}
