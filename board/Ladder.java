package board;

public class Ladder {
	private int start;
    private int end;

    public Ladder(int startval, int endval){
        start = startval;
        end = endval;
    }

    public int getstart(){
        return start;
    }

    public int getend(){
        return end;
    }

    public int elevate(){
        return end;
    }
}
