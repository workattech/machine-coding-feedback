import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DriverClass {
	public void playgame(Map<String,PlayerClass> playermap,Map<Integer,Integer> snakemap,Map<Integer,Integer> laddermap)
	{
		int flag=1;
		GameClass game=new GameClass();
		while(flag!=0) {
		for(Map.Entry<String,PlayerClass> map:playermap.entrySet())
		{
			
				PlayerClass player=map.getValue();
				int before=player.getCurrentPosition();
				game.playGame(1,6,player,snakemap,laddermap);
				int after=player.getCurrentPosition();
				if(after!=100) {
				System.out.println(map.getKey()+" moved from "+before+" to "+after);
				}
				else
				{
					System.out.println(map.getKey()+" moved from "+before+" to "+after);
			       System.out.println(map.getKey() +"win the game");
			       flag=0;
			       break;
				}
				
			
			
		}
		}
		
	}
        public static void main(String[] args)
        {
        	DriverClass driver =new DriverClass();
        	Scanner sc=new Scanner(System.in);
        	int snakes=sc.nextInt();
        	Map<Integer,Integer> snakemap=new HashMap<Integer,Integer>();
        	for(int i=0;i<snakes;i++)
        	{
        		int head=sc.nextInt();
        		int tail=sc.nextInt();
        		snakemap.put(head,tail);
        	}
        	int ladders=sc.nextInt();
        	Map<Integer,Integer> laddermap=new HashMap<Integer,Integer>();
        	for(int i=0;i<ladders;i++)
        	{
        		int start=sc.nextInt();
        		int end=sc.nextInt();
        		laddermap.put(start,end);
        	}
        	int p=sc.nextInt();
        	Map<String,PlayerClass> playermap=new HashMap<String,PlayerClass>();
        	
        	for(int i=0;i<p;i++)
        	{
        		String name=sc.next();
        		playermap.put(name,new PlayerClass());
        	}
        	;
        	driver.playgame(playermap,snakemap,laddermap);
        	
        	
        	
        	
        }
}
