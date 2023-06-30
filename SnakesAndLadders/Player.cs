public class Player
{

    public Player(string name)
    {
        Name = name;
    }
    public string Name { get; set; }
    public int CurrentPosition { get; set; } = 0;
    public bool IsWinner => CurrentPosition == 100;

    public int MoveToNewPosition(int increment)
    {
        if(CurrentPosition + increment > 100)
        {
            return CurrentPosition;
        }

        return CurrentPosition + increment;
    }

    public void SetPosition(int position)
    {
        CurrentPosition = position;
    }

    public int GetPosition()
    {
        return CurrentPosition;
    }


}