namespace Game2048
{
    public class Board
    {
        public Tile[,] tiles;

        public List<Tile> emptyTiles;
        public List<Tile> occupiedTiles;


        public int size;

        public Board(int size)
        {
            this.size = size;
            tiles = new Tile[size, size]; // default value is zero;
            for(int i=0; i<size; i++)
                for(int j = 0 ; j<size; j++)
                {
                    tiles[i,j] = new Tile(i,j,0);
                }

            occupiedTiles = new List<Tile>();
            emptyTiles = new List<Tile>();            
        }

        public void printBoard()
        {
            Console.WriteLine("Printing the board");
            for(int row=0; row<size; row++)
            {
                Console.WriteLine();
                for(int column = 0 ; column<size; column++)
                {
                    Console.Write(tiles[row,column].val + ", ");
                }
            }
        }
    }
}