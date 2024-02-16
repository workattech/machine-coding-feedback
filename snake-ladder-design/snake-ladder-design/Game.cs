namespace snake_ladder_design
{
    public class Game : IGame
    {
        private readonly IBoard _board;

        public Game(IBoard board)
        {
            _board = board ?? throw new ArgumentNullException(nameof(board));
        }

        public void Configure()
        {
            _board.ConfigureBoard();
        }

        public void Start()
        {
            var snakes = _board.GetSnakes();
            var ladders = _board.GetLadders();
            var players = _board.GetPlayers();
            var playerState = new int[players.Count()];
            var boardSize = _board.GetMaxBoardSize();
            var numOfDice = _board.GetNumOfDice();

            for (int i = 0; i < playerState.Length; i++)
            {
                playerState[i] = 0;
            }

            var currentPlayerIdx = 0;
            var random = new Random();
            var winners = 0;

            while (winners < playerState.Length-1)
            {
                var diceVal = random.Next(1, (numOfDice * 6) + 1);
                var initialPosition = playerState[currentPlayerIdx];

                if (initialPosition < boardSize)
                {
                    var finalPosition = Math.Min(boardSize, playerState[currentPlayerIdx] + diceVal);

                    while (true)
                    {
                        if (snakes.ContainsKey(finalPosition) == true)
                        {
                            finalPosition = snakes[finalPosition];
                        }
                        else if (ladders.ContainsKey(finalPosition) == true)
                        {
                            finalPosition = ladders[finalPosition];
                        }
                        else
                        {
                            break;
                        }
                    }

                    playerState[currentPlayerIdx] = finalPosition;
                    Console.WriteLine($"{players[currentPlayerIdx]} rolled a {diceVal} and moved from {initialPosition} to {finalPosition}");

                    if (finalPosition == boardSize)
                    {
                        Console.WriteLine($"{players[currentPlayerIdx]} wins the game.");
                        winners++;
                    }
                }

                currentPlayerIdx = (currentPlayerIdx + 1) % playerState.Length;
            }
        }

        public bool Validate()
        {
            var snakes = _board.GetSnakes();
            var ladders = _board.GetLadders();
            var boardSize = _board.GetMaxBoardSize();

            foreach (var snake in snakes)
            {
                var start = snake.Key;
                var end = snake.Value;

                if (start <= end)
                {
                    return false;
                }

                if (start < 0 || start > boardSize)
                {
                    return false;
                }

                if (end < 0 || end > boardSize)
                {
                    return false;
                }
            }

            foreach (var ladder in ladders)
            {
                var start = ladder.Key;
                var end = ladder.Value;

                if (start >= end)
                {
                    return false;
                }

                if (start < 0 || start > boardSize)
                {
                    return false;
                }

                if (end < 0 || end > boardSize)
                {
                    return false;
                }
            }

            return true;
        }
    }
}
