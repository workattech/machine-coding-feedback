namespace SnakeAndLadderGame
{
    class Square
    {
        public int val;
        public Snake snake;
        public Ladder ladder;

        public Square(int val)
        {
            this.val = val;
            snake = null;
            ladder = null;
        }
    }
}
