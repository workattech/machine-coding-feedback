package board;

public class Snake {
	private int head;
    private int tail;

    public Snake(int headval, int tailval){
        head = headval;
        tail = tailval;
    }

    public int bite(){
        return tail;
    }

    public int gethead(){
        return head;
    }

    public int gettail(){
        return tail;
    }

}
