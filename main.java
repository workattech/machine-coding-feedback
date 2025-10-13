import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    
    public static void main(String[] args) {
        
        int size=0;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the size of the board: ");
        size = sc.nextInt();

        List<Cell> cells = new ArrayList<>();
        
        for(int i=0; i <size;i++)
        {
            cells.add(new Cell(i + 1));
        }

        int snakesLaddersCount=0;

        System.out.println("Enter the count of snakes and ladders: ");

        snakesLaddersCount = sc.nextInt();

        List<SnakeLadder> snakeLadders = new ArrayList<>();

        System.out.println("Enter " + snakesLaddersCount + " lines containing start and end coordinates of snakes and ladders: ");

        for(int i=0; i <snakesLaddersCount;i++)
        {
            int l = sc.nextInt();
            int r = sc.nextInt();

            snakeLadders.add(new SnakeLadder(l,r));
        }

         //System.out.println(cells.getClass());
        // System.out.println(snakeLadders.getClass());

         //sc.close();
         Board board = new Board(size, cells, snakeLadders);

        int playerCount = 0;

        System.out.println("Enter count of players");
        playerCount = sc.nextInt();

        List<Player> players = new ArrayList<>();

        sc.nextLine(); // fix: consume the newline
        System.out.println("Enter " + playerCount + " lines containing names of players: ");

        for (int i = 0; i < playerCount; i++) {
            String name = sc.nextLine();
            players.add(new Player(name));
        }

        int diceCount = 0;
        System.out.println("Enter count of dice");

        diceCount = sc.nextInt();

        List<Dice> dices = new ArrayList<>();

        for (int i = 0; i < diceCount; i++) {
            dices.add(new Dice());
        }

        //System.out.println(board.getClass());
       // System.out.println(players.getClass());
       // System.out.println(dices.getClass());

        Game game = new Game(board, players, dices);

        int turn =0;
        int hasturn=0;
        while(true)
        {
            turn++;
            if(turn ==500000 ) break;
           Player player = players.get(hasturn);
           int nowpos= player.currPosition;

           //System.out.println("enter to throw dice!!" + player.name);

           int count = 0;
           for(int i=0;i<diceCount;i++)
           {
            count+=dices.get(i).rollDice();
           }

           //System.out.println("number rolled in dice" + count);

            int newpos= game.newPosOfPlayer(player,count);

            if(newpos>board.size)
            {
                System.out.println("Player " + player.name + "rolled a " + count + " and moved from " + nowpos + " to " + player.currPosition);
                System.out.println("Player " + player.name + " has gone outisze the board. Skipping ts move");
                hasturn++;
                hasturn%=playerCount;
                continue;
            }

            player.currPosition = newpos;
            
            int finall= board.handleSnakesAndLadders(player);
            player.currPosition= finall;

            System.out.println("Player " + player.name + " rolled a " + count + " and moved from " + nowpos + " to " + player.currPosition);

            if(game.hasWon(player))
            {
              System.out.println(" Player " + player.name + " has won ");
              break;
            }


                hasturn++;
                hasturn%=playerCount;
        }

    }

    
}
