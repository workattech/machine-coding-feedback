import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("input size of the board");
        int size=sc.nextInt();
        Board gameBoard=new Board(size);
        //size can be taken as input
        System.out.println("input number of snakes and their start and end points");
        int numberOfSnakes=sc.nextInt();
        for(int i=0;i<numberOfSnakes;i++)
        {
            int start=sc.nextInt();
            int end=sc.nextInt();
            gameBoard.addSpecialMove(new Snake(start,end));
        }
        System.out.println("input number of ladders and their start and end points");
        int numberOfLadders=sc.nextInt();
        for(int i=0;i<numberOfLadders;i++)
        {
            int start=sc.nextInt();
            int end=sc.nextInt();
            gameBoard.addSpecialMove(new Ladder(start,end));
        }
        System.out.println("input number of players and their names");
        int numberOfPlayers=sc.nextInt();
        ArrayList<Player> players=new ArrayList<Player>();
        for(int i=0;i<numberOfPlayers;i++)
        {
            players.add(new Player(sc.next()));
        }
        //start the game
        while(players.size()>1)
        {
            for(Player curPlayer:players)
            {
                int dice= (int)(Math.random()*6+1);
                int start=curPlayer.pos;
                curPlayer.move(gameBoard,dice);
                if(curPlayer.pos==size)
                {
                    System.out.println(curPlayer.name+" wins the game at rank "+(numberOfPlayers-players.size()+1));
                    players.remove(curPlayer);
                }
            }
        }
    }
}
