namespace Game2048
{
    public class GameOverException : Exception
    {
        // You can add custom properties or constructors as needed
        public GameOverException(string message) : base(message)
        {
            // You can include custom initialization code here
        }
    }
}