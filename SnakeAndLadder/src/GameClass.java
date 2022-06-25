import java.util.Map;

public class GameClass extends PlayerClass{
	public void playGame(int min,int max,PlayerClass player,Map<Integer,Integer> snakemap,Map<Integer,Integer> laddermap)
	{
		 int x = (int)(Math.random()*((max-min)+1))+min;
		 
		 player.normal(x);
		 while(snakemap.containsKey(player.getCurrentPosition())||laddermap.containsKey(player.getCurrentPosition()))
		 {
			 if(snakemap.containsKey(player.getCurrentPosition()))
			 {
				 player.isSnake(snakemap.get(player.getCurrentPosition()));
			 }
			 else
			 {
				 player.isLadder(laddermap.get(player.getCurrentPosition()));
			 }
			 
		}
	}
         
}
