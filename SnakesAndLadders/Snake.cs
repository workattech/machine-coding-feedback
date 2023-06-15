public class Snake
{
    public int StartPosition { get; set; }

    public int EndPosition { get; set; }

    public Snake(int startPosition,int endPosition)
    {
        StartPosition = startPosition;
        EndPosition = endPosition;
    }

}