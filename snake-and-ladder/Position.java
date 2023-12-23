public class Position {
    Integer start;
    Integer end;

    public Position(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    Integer key() {
        return start;
    }

    Integer value() {
        return end;
    }
}
