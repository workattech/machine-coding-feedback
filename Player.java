public class Player{

    private String name;
    private int position;
  
    public Player(String name,int position){
        this.name=name;
        this.position=position;
    }

  
    public String getName(){
        return this.name;
    }

    public int getPosition(){
        return this.position;
    }
    public void setPosition(int position){
        this.position=position;
    }
     


}