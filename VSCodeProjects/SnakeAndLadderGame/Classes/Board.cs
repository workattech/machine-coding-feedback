namespace SnakeAndLadderGame
{
    class Board
    {
        public Square[] squares;

        public Board()
        {
            squares = new Square[101];
            for(int i=0; i<101; i++)
            {
                squares[i] = new Square(i);
            }
        }

        public void addSnake(int head, int tail)
        {
            squares[head].snake = new Snake(head, tail);
        }

        public void addLadder(int start, int end)
        {
            squares[start].ladder = new Ladder(start,end);
        }

    }
}
