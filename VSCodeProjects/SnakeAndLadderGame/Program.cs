namespace SnakeAndLadderGame;

class Program
{
    static void Main(string[] args)
    {
        //Console.WriteLine("Hello, World!");
        string inputFilePath = ("./InputOutput/input.txt");

        string[] lines = File.ReadAllLines(inputFilePath);

        int lineCount = lines.Length;
        int num_snakes = int.Parse(lines[0]);
        int num_ladders = int.Parse(lines[num_snakes+1]);
        int num_players = int.Parse(lines[num_ladders+num_snakes+2]);

        Board board = new Board();
        List<Player> players = new List<Player>();

        Console.WriteLine($"{lineCount} {num_snakes} {num_ladders} {num_players}");

        for(int index = 1; index <= num_snakes; index++)
        {
            string[] tokens = lines[index].Split(' ');
            int head = int.Parse(tokens[0]);
            int tail = int.Parse(tokens[1]);
            board.addSnake(head, tail);
        }
        for(int index = num_snakes+2; index < num_snakes+num_ladders+2; index++)
        {
            string[] tokens = lines[index].Split(' ');
            //Console.WriteLine("Parsing " + lines[index]);
            int start = int.Parse(tokens[0]);
            int end = int.Parse(tokens[1]);
            board.addLadder(start, end);
        }
        for(int index = num_snakes+num_ladders+3; index<lineCount; index++)
        {
            players.Add(new Player(lines[index], board));
        }

        bool gameOver = false;
        while(!gameOver)
        {
            foreach(Player player in players)
            {
                int newPosition = player.move(player.rollDice(1,6));
                if(newPosition == 100)
                {
                    gameOver = true;
                    Console.WriteLine($"{player.name} wins the game");
                    break;
                }
            }
        }
    }
}
