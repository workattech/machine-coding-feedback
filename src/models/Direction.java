package models;

public class Direction {
    private long rowDelta;
    private long columnDelta;

    public Direction(long rowDelta, long columnDelta) {
        this.rowDelta = rowDelta;
        this.columnDelta = columnDelta;
    }

    public long getRowDelta() {
        return rowDelta;
    }

    public long getColumnDelta() {
        return columnDelta;
    }
}
