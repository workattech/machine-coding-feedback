package players;

public class Peice {
	private int pos;

    public Peice(){
        pos = 0;
    }

    public void setPos(int newpos){
        if(newpos >= 100){
            pos = 100;
        }else{
            pos = newpos;
        }
    }

    public int getPos(){
        return pos;
    }

    public void move(int p){
        setPos(pos+p);
    }
}
