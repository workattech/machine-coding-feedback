namespace Game2048
{
    public class Tile
    {
        public int row;
        public int column;

        public int val = -1;

        public Tile(int row, int column, int val = -1)
        {
            this.row = row;
            this.column = column;
            this.val = val;
        }

        public void setTileValue(int val)
        {
            this.val = val;
        }
    }
}