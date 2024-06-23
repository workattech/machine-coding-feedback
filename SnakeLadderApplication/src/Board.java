import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private final int rows;
    private final int columns;

    private final Map<Integer,Integer> snakeMap;
    private final Map<Integer,Integer> laddersMap;
    private final List<List<Integer>> values;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        values = new ArrayList<>(rows);
        for(int i=0;i< rows;i++){
            List<Integer> row = new ArrayList<>(columns);
            for(int j=0;j<columns;j++) {
                row.add(0);
            }
            values.add(row);
        }
        setupValues();
        snakeMap = new HashMap<>();
        laddersMap = new HashMap<>();
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    private void setupValues() {
        int start= rows * columns;
        for(int i=0;i<rows;i++) {
            if(i%2==0) {
                for (int j = 0; j < columns; j++) {
                    values.get(i).set(j, start--);
                }
            }
            else {
                for (int j = columns-1; j >=0; j--) {
                    values.get(i).set(j, start--);
                }
            }
        }
    }

    public Map<Integer, Integer> getSnakeMap() {
        return snakeMap;
    }

    public Map<Integer, Integer> getLaddersMap() {
        return laddersMap;
    }

    public void display() {
        System.out.println("\n-----------------------Board State--------------------\n");
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                System.out.print(values.get(i).get(j));
                System.out.print("   ");
            }
            System.out.println();
        }
        System.out.println("\n-----------------------END------------------------------\n");
    }
}
