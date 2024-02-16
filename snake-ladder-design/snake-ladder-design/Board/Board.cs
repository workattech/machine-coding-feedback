namespace snake_ladder_design
{
    public class Board : IBoard
    {
        private Dictionary<int, int> _snakes;
        private Dictionary<int, int> _ladders;
        private List<string> _players;
        private int _numOfDice;
        private int _maxBoardSize;

        public Board(int numOfDice, int maxBoardSize)
        {
            _snakes = new Dictionary<int, int>();
            _ladders = new Dictionary<int, int>();
            _players = new List<string>();
            _numOfDice = numOfDice;
            _maxBoardSize = maxBoardSize;
        }

        public int GetNumOfDice()
        {
            return _numOfDice;
        }

        public int GetMaxBoardSize()
        {
            return _maxBoardSize;
        }

        public Dictionary<int, int> GetSnakes()
        {
            return _snakes;
        }

        public Dictionary<int, int> GetLadders()
        {
            return _ladders;
        }

        public List<string> GetPlayers()
        {
            return _players;
        }

        public void ConfigureBoard()
        {
            var boardInput = "data/input.txt"; // input file is present inside bin/Debug/net6.0 folder 
            var populateTo = string.Empty;

            using (var sr = new StreamReader(boardInput))
            {
                var line = sr.ReadLine();

                while (line != null)
                {
                    var data = line.Split(' ');

                    if (data[0].ToLower() == "snakes")
                    {
                        populateTo = "snakes";
                    }
                    else if (data[0].ToLower() == "ladders")
                    {
                        populateTo = "ladders";
                    }
                    else if (data[0].ToLower() == "players")
                    {
                        populateTo = "players";
                    }

                    if (!string.IsNullOrEmpty(populateTo) && populateTo != "players")
                    {
                        if (int.TryParse(data[0], out int start) && int.TryParse(data[1], out int end))
                        {
                            if (populateTo == "snakes")
                            {
                                _snakes.Add(start, end);
                            }
                            else if (populateTo == "ladders")
                            {
                                _ladders.Add(start, end);
                            }
                        }
                    }
                    else if (populateTo == "players")
                    {
                        if (data.Length == 1)
                        {
                            _players.Add(data[0]);
                        }
                    }

                    line = sr.ReadLine();
                }
            }
        }
    }
}
