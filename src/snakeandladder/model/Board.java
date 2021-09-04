package snakeandladder.model;

import java.util.*;

public class Board {
    List<Player> PlayerList;
    Map<Integer,Snake>SnakeMap;//=new HashMap<>();
    Map<Integer,Ladder> LadderMap;//=new HashMap<>();
    int BoardSize;
    public Board(List<Player> PlayerList, Map<Integer,Snake> SnakeMap, Map<Integer, Ladder> LadderMap,int BoardSize) {
        this.PlayerList = PlayerList;
        this.SnakeMap = SnakeMap;
        this.LadderMap = LadderMap;
        this.BoardSize=BoardSize;
    }
    void checkSnakesAndUpdatePosition(Player Player){
        while(SnakeMap.get(Player.getPosition())!=null){
            Player.setPosition(SnakeMap.get(Player.getPosition()).getTail());
        }
    }
    void checkLaddersAndUpdatePosition(Player Player){
        while(LadderMap.get(Player.getPosition())!=null){
            Player.setPosition(LadderMap.get(Player.getPosition()).getEnd());
        }
    }
    void setFinalPosition(Player Player){
        int InitialPosition=Player.getPosition();
        int NumberOfDice=1;//case of multiple dice
        int DiceSum=0;
        for(int i=0;i<NumberOfDice;i++){
            Dice d = new Dice();
            DiceSum+=d.getDiceRoll();
        }
        int FinalPosition=InitialPosition+DiceSum;
        if(FinalPosition>100){
            FinalPosition=InitialPosition;
            System.out.println(Player.getName()+" rolled a "+DiceSum+" and moved from "+InitialPosition+" to "+Player.getPosition());
        }else{
            Player.setPosition(FinalPosition);
            checkSnakesAndUpdatePosition(Player);
            checkLaddersAndUpdatePosition(Player);
            System.out.println(Player.getName()+" rolled a "+DiceSum+" and moved from "+InitialPosition+" to "+Player.getPosition());
        }
    }
    
    public void StartGame(){
        int NumberOfCurrentPlayersPlaying=PlayerList.size();
        while (NumberOfCurrentPlayersPlaying>1){
            for(Player Player:PlayerList){
                if(!Player.checkHasWon()){
                    setFinalPosition(Player);
                    if(Player.getPosition()==BoardSize){
                        NumberOfCurrentPlayersPlaying--;
                        System.out.println(Player.getName()+" wins the game");
                        Player.HasWon=true;
                        if(NumberOfCurrentPlayersPlaying<2)return;
                    }
                }
            }
        }

    }
}
