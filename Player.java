public class Player {
    
    String name;
    int currPosition;
    
    public Player (String name)
    {
       this.name= name;
       currPosition = 0;
    }
    void changePosition(int diff)
    {
        currPosition+=diff;
    }

}
