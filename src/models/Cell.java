package models;

public class Cell {
    private long rowIndex;
    private long columnIndex;
    private Tile tile;

    public Cell(long rowIndex, long columnIndex, Tile tile) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        this.tile = tile;
    }

    public long getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(long rowIndex) {
        this.rowIndex = rowIndex;
    }

    public long getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(long columnIndex) {
        this.columnIndex = columnIndex;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public boolean merge(Cell cell) {
        Tile mergingTile = cell.getTile();
        if(this.tile.isSimilarTo(mergingTile)) {
            this.tile.getValue().increaseValue();
            cell.setTile(null);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "rowIndex=" + rowIndex +
                ", columnIndex=" + columnIndex +
                ", tile=" + tile +
                '}';
    }
}
