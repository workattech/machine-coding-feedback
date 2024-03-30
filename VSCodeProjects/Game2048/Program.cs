namespace Game2048;

class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("Hello, World!");

        BoardManager boardManager = new BoardManager();

        int count = 100;
        Random random = new Random();
        try
        {
            while(count-- >0 || boardManager.reachedEnd == true || boardManager.reached2048 == true)
            {
                int direction = random.Next(0,4);
                boardManager.executeMove(direction);
            }
        }
        catch(GameOverException e)
        {
            Console.WriteLine("GameOver!");
        }
        if(boardManager.reachedEnd)
            Console.WriteLine("Game Over!");
        if(boardManager.reached2048)
            Console.WriteLine("Congratulations!");
    }
}
