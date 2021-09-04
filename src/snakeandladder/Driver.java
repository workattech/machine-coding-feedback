package snakeandladder;

import snakeandladder.model.Board;
import snakeandladder.model.Ladder;
import snakeandladder.model.Player;
import snakeandladder.model.Snake;

import java.util.*;

public class Driver {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int NumberOfPlayers;
        int NumberOfSnakes;
        int NumberOfLadders;
        List<Player>PlayerList=new ArrayList<>();
        Map<Integer,Snake> SnakeMap=new HashMap<Integer,Snake>();
        Map<Integer, Ladder> LadderMap=new HashMap<Integer, Ladder>();
        int BoardSize=100;

        NumberOfSnakes=sc.nextInt();
        for(int i=0;i<NumberOfSnakes;i++){
            int head=sc.nextInt();
            int tail=sc.nextInt();
            SnakeMap.put(head,new Snake(head,tail));
        }

        NumberOfLadders=sc.nextInt();
        for(int i=0;i<NumberOfLadders;i++){
            int start=sc.nextInt();
            int end=sc.nextInt();
            LadderMap.put(start,new Ladder(start,end));
        }

        NumberOfPlayers=sc.nextInt();
        for(int i=0;i<NumberOfPlayers;i++){
            PlayerList.add(new Player(sc.next()));
        }
        Board b=new Board(PlayerList,SnakeMap,LadderMap,BoardSize);
        b.StartGame();
    }

}
