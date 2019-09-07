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
      /**
     * Method used to calcluate the players position after rolling dice
     * @param diceValue
     * @param currentPosition
     * @param playerName
     * @return
     */
    public int calculatePlayerPosition(int diceValue,int currentPosition,String playerName,Board board){

        int finalPosition=currentPosition+diceValue;
        if(board.getSnakes().containsKey(finalPosition)){
            finalPosition=board.getSnakes().get(finalPosition);
            
            //snake encountered move down the board

        }else if(board.getLadders().containsKey(finalPosition)){
            finalPosition=board.getLadders().get(finalPosition);
            //ladder encountered move up the board
        }
       
            return finalPosition;
        
    
    

}


}