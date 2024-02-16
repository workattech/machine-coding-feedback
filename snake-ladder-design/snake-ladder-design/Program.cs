using snake_ladder_design;

public class Solution
{
    public static void Main(string[] agrs)
    {
        IGame game = new Game(new Board(numOfDice: 1, maxBoardSize: 100));

        game.Configure();
        
        if (game.Validate() == false)
        {
            Console.WriteLine("Invalid game board details are provided.");
            return;
        }

        game.Start();
    }
}