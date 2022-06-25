
public class PlayerClass {
	private  int currentposition=0;
	public int getCurrentPosition()
	{
		return currentposition;
	}
	public void isLadder(int number)
	{
		 
		currentposition=number;
		
	}
	public void isSnake(int number)
	{
		currentposition=number;
	}
	public void normal(int number)
	{
		if(currentposition+number<=100) {
		currentposition+=number;
		}
	}
	

}
