package snakeandladder;

import snakeandladder.model.Board;
import snakeandladder.model.Ladder;
import snakeandladder.model.Player;
import snakeandladder.model.Snake;

import java.util.*;

public class driver {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int numberOfPlayers;
        int numberOfSnakes;
        int numberOfLadders;
        List<Player> playerArrayList=new ArrayList<>();
        Map<Integer,Snake> snakeHashMap=new HashMap<Integer,Snake>();
        Map<Integer, Ladder> ladderHashMap=new HashMap<Integer, Ladder>();
        int boardSize=100;

        numberOfSnakes=sc.nextInt();
        for(int i=0;i<numberOfSnakes;i++){
            int head=sc.nextInt();
            int tail=sc.nextInt();
            snakeHashMap.put(head,new Snake(head,tail));
        }

        numberOfLadders=sc.nextInt();
        for(int i=0;i<numberOfLadders;i++){
            int start=sc.nextInt();
            int end=sc.nextInt();
            ladderHashMap.put(start,new Ladder(start,end));
        }

        numberOfPlayers=sc.nextInt();
        for(int i=0;i<numberOfPlayers;i++){
            playerArrayList.add(new Player(sc.next()));
        }
        Board b=new Board(playerArrayList,snakeHashMap,ladderHashMap,boardSize);
        b.startGame();
    }

}
