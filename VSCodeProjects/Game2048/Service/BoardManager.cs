namespace Game2048
{
    public class BoardManager
    {
        Board board;        
        private Random random;

        public bool reached2048 = false;
        public bool reachedEnd = false;

        public BoardManager()
        {
            board = new Board(4);
            random = new Random();
            //board.printBoard();
            initializeBoard();
        } 

        public void initializeBoard()
        {
            insert(2);
            insert(2);
            Console.WriteLine("Initialized the board");
            board.printBoard();
        }

        public void insert(int value)
        {
            Tile toInsert = getRandomPositionForInsertion();
            Console.WriteLine($"\nInserting {value} at {toInsert.row}, {toInsert.column}");
            board.tiles[toInsert.row, toInsert.column].val = value;
        }

        public int getRandomValueForInsertion()
        {
            int[] values = {2,2,4};
            int pos = random.Next(0,values.Length);
            return values[pos];
        }

        public Tile getRandomPositionForInsertion()
        {
            resetVacancy();
            int availableCount = board.emptyTiles.Count;
            if(availableCount == 0)
            {
                reachedEnd = true;
                throw new GameOverException("Game is over!");
            }
            int pos = random.Next(0, availableCount);
            return board.emptyTiles[pos];
        }

        public void executeMove(int direction)
        {
            resetVacancy();
            board.printBoard();
            Move(direction);            
            insert(getRandomValueForInsertion());            
        }  

        public void Move(int direction)
        {
            switch(direction)
            {
                case 0: 
                {
                    MoveHorizontal(left:true);
                    break;
                }
                case 1:
                {
                    MoveHorizontal(left:false);
                    break;
                }
                case 2:
                {
                    MoveVertical(up:true);
                    break;
                }
                case 3:
                {
                    MoveVertical(up:false);
                    break;
                }
            }
        }

        public void MoveHorizontal(bool left = true)
        { 
            Console.WriteLine("\nMoving "+ (left?"Left":"Right"));         
            
            for(int row=0; row<board.size; row++)
            {
                //ProcessEachRow
                //Console.WriteLine($"\nProcessing Row {row}");
                List<int> toProcess = new List<int>();
                for(int column=0; column<board.size; column++)
                {
                    if(board.tiles[row,column].val !=0)
                        toProcess.Add(board.tiles[row,column].val);
                }
                //printList(toProcess);
                List<int> processedList = mergeList(toProcess);
                //printList(processedList);
                if(left)
                {
                    for(int column=0; column<board.size; column++)
                    {
                        board.tiles[row,column].val = processedList[column];
                        
                    }
                }
                else
                {
                    for(int column=board.size-1; column>=0; column--)
                    {
                        //Console.WriteLine($"{row}, {column}, {board.size-1-row}");

                        board.tiles[row,column].val = processedList[board.size-1-column];
                    }
                }
            }
        }

        public void resetVacancy()
        {
            board.emptyTiles = new List<Tile>();
            board.occupiedTiles = new List<Tile>();

            for(int row=0; row<board.size; row++)
            {
                for(int column=0; column<board.size; column++)
                {
                    if(board.tiles[row,column].val == 0)
                    {
                        board.emptyTiles.Add(board.tiles[row,column]);
                    }
                    else
                    {
                        board.occupiedTiles.Add(board.tiles[row,column]);
                    }
                }
            }
            if(board.emptyTiles.Count == 0)
            {
                reachedEnd = true;
            }
        }

        public void MoveVertical(bool up = true)
        {
            Console.WriteLine("\nMoving "+ (up?"Up":"Down"));         
            
            for(int column=0; column<board.size; column++)
            {
                //ProcessEachColumn
                //Console.WriteLine($"\nProcessing column {column}");
                List<int> toProcess = new List<int>();
                for(int row=0; row<board.size; row++)
                {
                    if(board.tiles[row,column].val !=0)
                        toProcess.Add(board.tiles[row,column].val);
                }
                //printList(toProcess);
                List<int> processedList = mergeList(toProcess);
                //printList(processedList);
                if(up)
                {
                    for(int row=0; row<board.size; row++)
                    {
                        board.tiles[row,column].val = processedList[row];
                    }
                }
                else
                {
                    for(int row=board.size-1; row>=0; row--)
                    {
                        //Console.WriteLine($"{row}, {column}, {board.size-1-row}");
                        board.tiles[row,column].val = processedList[board.size-1-row];
                    }
                }
            }
        }

        public void TestMergeList()
        {
            printList(mergeList(new List<int>{2,2,2}));
            printList(mergeList(new List<int>{2}));
            printList(mergeList(new List<int>{2,2,2,2}));
            printList(mergeList(new List<int>{2,2}));
            printList(mergeList(new List<int>{}));
        }

        public void printList(List<int> toPrint)
        {
            Console.Write("\nPrinting List: ");
            for(int i=0; i<toPrint.Count; i++)
                Console.Write(toPrint[i] + ",");
        }

        private List<int>  mergeList(List<int> toProcess)
        {
            //<ToDo> Fix the bug when the order is reversed when 2,4,8,16 is sent vertically
            List<int> result = new List<int>(board.size);
            int count = toProcess.Count;
            if(count != 0) 
            {
                int current = toProcess[0];
                for(int i = 1; i<count; i++)
                {
                    if(toProcess[i] == current)
                    {
                        result.Add(2*current);
                        if(2*current == 2048)
                            reached2048 = true;
                        current=0;
                    }
                    else
                    {
                        if(current!=0)
                            result.Add(current);
                        current = toProcess[i];
                    }
                }
                result.Add(current);
            }
            while(result.Count < board.size)
            {
                result.Add(0);
            }
            return result;
        }    
    }
}