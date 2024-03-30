using System;
namespace SnakeAndLadderGame
{
    class Player
    {
        public string name;
        private Random random;
        public int pos;
        Board board;

        public Player(string name, Board board)
        {
            this.name = name;
            pos = 0;
            random = new Random();
            this.board = board;
        }

        public int rollDice(int min, int max)
        {            
            return random.Next(min, max + 1);
        }

        public int move(int dice_value)
        {
            if(pos + dice_value > 100)
                return pos;
            
            Square destination = board.squares[pos+dice_value];
            while(destination.snake != null || destination.ladder != null)
            {
                if(destination.ladder != null)
                {
                    destination = board.squares[destination.ladder.end];
                    //Console.WriteLine($"\tEncountered a ladder from {pos} to {destination.val}");
                }
                if(destination.snake != null)
                {
                    destination = board.squares[destination.snake.tail];
                    //Console.WriteLine($"\tEncountered a snake from {pos} to {destination.val}");
                }
            }
            Console.WriteLine($"{name} rolled a {dice_value} and moved from {pos} to {destination.val}");
            pos = destination.val;
            return pos;
        }        
    }
}
