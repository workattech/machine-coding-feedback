public class Game 
{
    public List<Snake> Snakes = new List<Snake>();
    public List<Ladder> Ladders = new List<Ladder>();
    public List<Player> Players = new List<Player>();

    public bool IsGameOver => Players.Exists(p => p.IsWinner);

    public void AddLadder(Ladder ladder)
    {
        Ladders.Add(ladder);
    }

    /// <summary>
    /// If a ladder connects with a bottom of another ladder, consider the two ladders as a combined ladder
    /// </summary>
    public void CombineLadders()
    {
        Ladders.Sort(delegate(Ladder x,Ladder y)
        {
            return x.StartPosition.CompareTo(y.StartPosition);
        });

        for(int i = 0;i<Ladders.Count;i++)
        {
            for (int j=i+1; j<Ladders.Count;j++)
            {
                if(Ladders[j].StartPosition == Ladders[i].EndPosition)
                {
                    Ladders[i].EndPosition = Ladders[j].EndPosition;
                    Ladders.RemoveAt(j);
                }
            }
        }
    }


    /// <summary>
    /// If a snake head connects with a tail on the same piece of the board, consider the the two snakes as one combined snake.
    /// </summary>
    public void CombineSnakes()
    {
        Snakes.Sort((x,y) => x.StartPosition.CompareTo(y.StartPosition));
        Snakes.Reverse();

        for (int i = 0; i < Snakes.Count; i++)
        {
            for (int j = i + 1; j < Snakes.Count; j++)
            {
                if(Snakes[j].StartPosition == Snakes[i].EndPosition)
                {
                    Snakes[i].EndPosition = Snakes[i].EndPosition;
                    Snakes.RemoveAt(j);
                }

            }
        }
    }


    public void AddSnake(Snake snake)
    {
        Snakes.Add(snake);
    }

    public void AddPlayer(Player player)
    {
        Players.Add(player);
    }

    public void StartGame()
    {
        if(!Players.Any())
        {
            throw new Exception();
        }

        CombineLadders();
        CombineSnakes();

        while (!IsGameOver)
        {
            int newPosition = 0;
            foreach (Player currentPlayer in Players)
            {
                int roll = new Random().Next(1, 6);
                newPosition = currentPlayer.MoveToNewPosition(roll);

                foreach (Snake snake in Snakes)
                {
                    if (newPosition == snake.StartPosition)
                    {
                        newPosition = snake.EndPosition;
                    }
                }

                foreach (Ladder ladder in Ladders)
                {
                    if (newPosition == ladder.StartPosition)
                    {
                        newPosition = ladder.EndPosition;
                    }
                }

                Console.WriteLine($"The player {currentPlayer.Name} got a roll of {roll} has moved from {currentPlayer.GetPosition()} to {newPosition}");
                currentPlayer.SetPosition(newPosition);

                if (currentPlayer.IsWinner)
                {
                    Console.WriteLine($"The winner is {currentPlayer.Name}");
                    break;
                }
            }
        }

    }


}