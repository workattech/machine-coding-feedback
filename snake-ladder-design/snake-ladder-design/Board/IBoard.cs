namespace snake_ladder_design
{
    public interface IBoard
    {
        Dictionary<int, int> GetSnakes();

        Dictionary<int, int> GetLadders();

        List<string> GetPlayers();

        int GetNumOfDice();

        int GetMaxBoardSize();

        void ConfigureBoard();
    }
}
